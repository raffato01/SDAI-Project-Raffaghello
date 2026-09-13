import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.leap.LEAPCodec;
import jade.content.onto.Ontology;
import mars_project.*;
import java.util.Random;

public class EnvironmentAgent extends Agent {

    static final int GSize = 7;
    static final int MAX_ERR = 2;
    static final int TOT_GARB = 6;

    boolean[][] garb = new boolean[GSize][GSize];
    int[][] pos = new int[3][2];       // pos[agent][0=x, 1=y]
    boolean[] carrying = new boolean[3];
    int[] pickErr = new int[3];
    int burned = 0;
    Random rnd = new Random();

    Codec codec = new LEAPCodec();
    Ontology onto = MarsOntology.getInstance();

    @Override
    protected void setup() {
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(onto);

        // starting positions: r1=(0,0), r2=(3,3), r3=(0,4)
        pos[0] = new int[]{0, 0};
        pos[1] = new int[]{3, 3};
        pos[2] = new int[]{0, 4};

        // 6 garbage pieces at random positions
        garb[3][0] = true;
        garb[6][0] = true;
        garb[1][2] = true;
        garb[0][5] = true;
        garb[6][5] = true;
        garb[2][6] = true;

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) EnvironmentAgent.this.handle(msg);
                else block();
            }
        });
    }

    private void handle(ACLMessage msg) {
        String name = msg.getSender().getLocalName();
        int ag = agIndex(name);

        ACLMessage reply = msg.createReply();
        reply.setPerformative(ACLMessage.INFORM);
        reply.setLanguage(codec.getName());
        reply.setOntology(onto.getName());

        try {
            ContentElement ce = getContentManager().extractContent(msg);

            if (ce instanceof DoNextSlot) {
                nextSlot(ag);
                replyPercepts(reply, ag);

            } else if (ce instanceof DoMoveTowards) {
                DoMoveTowards mv = (DoMoveTowards) ce;
                moveTowards(ag, mv.getTargetX(), mv.getTargetY());
                replyPercepts(reply, ag);

            } else if (ce instanceof DoPick) {
                boolean ok = pick(ag);
                fillAndSend(reply, ok ? new PickedSuccessfully() : new PickFailed());

            } else if (ce instanceof DoDrop) {
                drop(ag);
                fillAndSend(reply, new ActionCompleted());
                // if r2 is at base, notify it that garbage has been dropped
                if (pos[ag][0] == pos[1][0] && pos[ag][1] == pos[1][1])
                    notifyR2();

            } else if (ce instanceof DoBurn) {
                burn();
                fillAndSend(reply, new ActionCompleted());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
    }

    // --- sending replies ---

    private void replyPercepts(ACLMessage reply, int ag) throws Exception {
        Percepts p = new Percepts();
        p.setMyX(pos[ag][0]);
        p.setMyY(pos[ag][1]);
        p.setR2X(pos[1][0]);
        p.setR2Y(pos[1][1]);
        p.setHasGarbage(hasGarb(pos[ag][0], pos[ag][1]));
        getContentManager().fillContent(reply, p);
        send(reply);
    }

    private void fillAndSend(ACLMessage reply, ContentElement content) {
        try {
            getContentManager().fillContent(reply, content);
            send(reply);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void notifyR2() {
        try {
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("r2", AID.ISLOCALNAME));
            msg.setLanguage(codec.getName());
            msg.setOntology(onto.getName());
            getContentManager().fillContent(msg, new GarbageAtBase());
            send(msg);
        } catch (Exception e) { e.printStackTrace(); }
    }

    // --- logica griglia ---

    private void nextSlot(int ag) {
        pos[ag][0]++;
        if (pos[ag][0] >= GSize) {
            pos[ag][0] = 0;
            pos[ag][1]++;
        }
    }

    private void moveTowards(int ag, int tx, int ty) {
        if (pos[ag][0] < tx) pos[ag][0]++;
        else if (pos[ag][0] > tx) pos[ag][0]--;
        if (pos[ag][1] < ty) pos[ag][1]++;
        else if (pos[ag][1] > ty) pos[ag][1]--;
    }

    private boolean pick(int ag) {
        int x = pos[ag][0], y = pos[ag][1];
        if (!garb[x][y]) return false;
        if (rnd.nextBoolean() || pickErr[ag] >= MAX_ERR) {
            garb[x][y] = false;
            carrying[ag] = true;
            pickErr[ag] = 0;
            return true;
        }
        pickErr[ag]++;
        return false;
    }

    private void drop(int ag) {
        if (carrying[ag]) {
            carrying[ag] = false;
            garb[pos[ag][0]][pos[ag][1]] = true;
        }
    }

    private void burn() {
        int x = pos[1][0], y = pos[1][1];
        if (garb[x][y]) {
            garb[x][y] = false;
            burned++;
            System.out.println("BURNED " + burned + "/" + TOT_GARB);
            if (burned >= TOT_GARB) {
                System.out.println("Mission complete.");
                new Thread(() -> {
                    try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
                    try { getContainerController().kill(); }
                    catch (Exception e) { System.exit(0); }
                }).start();
            }
        }
    }

    // --- utility ---

    private int agIndex(String name) {
        switch (name) {
            case "r1": return 0;
            case "r2": return 1;
            case "r3": return 2;
            default: return -1;
        }
    }

    private boolean hasGarb(int x, int y) {
        return x >= 0 && x < GSize && y >= 0 && y < GSize && garb[x][y];
    }
}