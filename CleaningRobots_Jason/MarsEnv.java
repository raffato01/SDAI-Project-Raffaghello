
import jason.asSyntax.*;
import jason.environment.Environment;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Logger;

public class MarsEnv extends Environment {

    public static final int GSize = 7; // grid size
    public static final int GARB = 16; // garbage code in grid model

    public static final int NAgents = 3;

    public static final Term ns = Literal.parseLiteral("next(slot)");
    public static final Term pg = Literal.parseLiteral("pick(garb)");
    public static final Term dg = Literal.parseLiteral("drop(garb)");
    public static final Term bg = Literal.parseLiteral("burn(garb)");
    public static final Literal g1 = Literal.parseLiteral("garbage(r1)");
    public static final Literal g2 = Literal.parseLiteral("garbage(r2)");
    public static final Literal g3 = Literal.parseLiteral("garbage(r3)");

    static Logger logger = Logger.getLogger(MarsEnv.class.getName());

    private MarsModel model;
    private MarsView view;

    int getAgIdByName(String ag) {
        if (ag.equals("r1"))
            return 0;
        if (ag.equals("r2"))
            return 1;
        if (ag.equals("r3"))
            return 2;
        return -1;
    }

    @Override
    public void init(String[] args) {
        model = new MarsModel();
        view = new MarsView(model);
        model.setView(view);
        updatePercepts();
    }

    @Override
    public boolean executeAction(String ag, Structure action) {
        logger.info(ag + " doing: " + action);
        int agIdx = getAgIdByName(ag);
        try {
            if (action.equals(ns)) {
                model.nextSlot(agIdx);
            } else if (action.getFunctor().equals("move_towards")) {
                int x = (int) ((NumberTerm) action.getTerm(0)).solve();
                int y = (int) ((NumberTerm) action.getTerm(1)).solve();
                model.moveTowards(agIdx, x, y);
            } else if (action.equals(pg)) {
                model.pickGarb(agIdx);
            } else if (action.equals(dg)) {
                model.dropGarb(agIdx);
            } else if (action.equals(bg)) {
                model.isBurning = true;
                model.burnGarb();
                if (view != null) view.repaint();
                try { Thread.sleep(500); } catch (Exception e) {}
                model.isBurning = false;
                if (view != null) view.repaint();
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        updatePercepts();

        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }
        informAgsEnvironmentChanged();
        return true;
    }

    void updatePercepts() {
        clearPercepts();

        Location r1Loc = model.getAgPos(0);
        Location r2Loc = model.getAgPos(1);
        Location r3Loc = model.getAgPos(2);

        Literal pos1 = Literal.parseLiteral("pos(r1," + r1Loc.x + "," + r1Loc.y + ")");
        Literal pos2 = Literal.parseLiteral("pos(r2," + r2Loc.x + "," + r2Loc.y + ")");
        Literal pos3 = Literal.parseLiteral("pos(r3," + r3Loc.x + "," + r3Loc.y + ")");

        addPercept(pos1);
        addPercept(pos2);
        addPercept(pos3);

        if (model.hasObject(GARB, r1Loc)) {
            addPercept(g1);
        }
        if (model.hasObject(GARB, r2Loc)) {
            addPercept(g2);
        }
        if (model.hasObject(GARB, r3Loc)) {
            addPercept(g3);
        }

        if (model.scanComplete[0]) addPercept("r1", Literal.parseLiteral("scan_done"));
        if (model.scanComplete[2]) addPercept("r3", Literal.parseLiteral("scan_done"));
    }

    class MarsModel extends GridWorldModel {

        public static final int MErr = 2; // max error in pick garb
        int[] nerr = new int[NAgents]; // number of tries of pick garb
        boolean[] agHasGarb = new boolean[NAgents];
        boolean[] scanComplete = new boolean[NAgents];
        boolean isBurning = false;

        Random random = new Random(System.currentTimeMillis());

        private MarsModel() {
            super(GSize, GSize, NAgents);

            try {
                setAgPos(0, 0, 0);

                Location r2Loc = new Location(GSize / 2, GSize / 2);
                setAgPos(1, r2Loc);

                setAgPos(2, 0, GSize / 2 + 1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            add(GARB, 3, 0);
            add(GARB, GSize - 1, 0);
            add(GARB, 1, 2);
            add(GARB, 0, GSize - 2);
            add(GARB, GSize - 1, GSize - 2);
            add(GARB, 2, GSize - 1);
        }

        int scanLimitY(int agIdx) {
            return (agIdx == 0) ? GSize / 2 + 1 : getHeight();
        }

        void nextSlot(int agIdx) throws Exception {
            if (scanComplete[agIdx]) return;
            Location ag = getAgPos(agIdx);
            ag.x++;
            if (ag.x == getWidth()) {
                ag.x = 0;
                ag.y++;
            }
            if (ag.y >= scanLimitY(agIdx)) {
                scanComplete[agIdx] = true;
                return;
            }
            setAgPos(agIdx, ag);
            for (int i = 0; i < NAgents; i++) {
                setAgPos(i, getAgPos(i));
            }
        }

        void moveTowards(int agIdx, int x, int y) throws Exception {
            Location ag = getAgPos(agIdx);
            if (ag.x < x)
                ag.x++;
            else if (ag.x > x)
                ag.x--;
            if (ag.y < y)
                ag.y++;
            else if (ag.y > y)
                ag.y--;
            setAgPos(agIdx, ag);
            for (int i = 0; i < NAgents; i++) {
                setAgPos(i, getAgPos(i));
            }
        }

        void pickGarb(int agIdx) {
            if (model.hasObject(GARB, getAgPos(agIdx))) {
                if (random.nextBoolean() || nerr[agIdx] == MErr) {
                    remove(GARB, getAgPos(agIdx));
                    nerr[agIdx] = 0;
                    agHasGarb[agIdx] = true;
                    if (view != null) view.repaint();
                } else {
                    nerr[agIdx]++;
                }
            }
        }

        void dropGarb(int agIdx) {
            if (agHasGarb[agIdx]) {
                agHasGarb[agIdx] = false;
                add(GARB, getAgPos(agIdx));
                if (view != null) view.repaint();
            }
        }

        void burnGarb() {
            if (model.hasObject(GARB, getAgPos(1))) {
                remove(GARB, getAgPos(1));
                if (view != null) view.repaint();
            }
        }
    }

    class MarsView extends GridWorldView {

        public MarsView(MarsModel model) {
            super(model, "Mars World", 600);
            defaultFont = new Font("Arial", Font.BOLD, 18); // change default font
            setVisible(true);
            repaint();
        }

        @Override
        public void draw(Graphics g, int x, int y, int object) {
            switch (object) {
                case MarsEnv.GARB:
                    drawGarb(g, x, y);
                    break;
            }
        }

        @Override
        public void drawAgent(Graphics g, int x, int y, Color c, int id) {
            String label = "R" + (id + 1);
            if (id == 0) {
                c = Color.yellow;
                if (((MarsModel) model).agHasGarb[0]) {
                    label += " - G";
                    c = Color.orange;
                }
            } else if (id == 1) {
                if (((MarsModel) model).isBurning) {
                    c = Color.red;
                    label = "R2 - 🔥";
                } else {
                    c = Color.blue;
                }
            } else if (id == 2) {
                c = Color.green;
                if (((MarsModel) model).agHasGarb[2]) {
                    label += " - G";
                    c = Color.orange;
                }
            }
            super.drawAgent(g, x, y, c, -1);
            if (id == 1) {
                g.setColor(Color.white);
            } else {
                g.setColor(Color.black);
            }
            super.drawString(g, x, y, defaultFont, label);
        }

        public void drawGarb(Graphics g, int x, int y) {
            super.drawObstacle(g, x, y);
            g.setColor(Color.white);
            drawString(g, x, y, defaultFont, "G");
        }

    }
}
