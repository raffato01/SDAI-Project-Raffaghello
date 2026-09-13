import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class MainLauncher {

    public static void main(String[] args) {
        System.out.println("=== Mars Cleaning Robots (JadeScript) ===");
        System.out.println("Launching JADE platform...");

        Runtime rt = Runtime.instance();

        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.GUI, "false");
        profile.setParameter(Profile.MAIN_HOST, "localhost");

        ContainerController container = rt.createMainContainer(profile);

        try {
            AgentController envAgent = container.createNewAgent(
                    "environment",
                    "EnvironmentAgent",
                    new Object[] {}
            );
            envAgent.start();
            System.out.println("  -> EnvironmentAgent started (Java)");

            Thread.sleep(1000);

            AgentController r2 = container.createNewAgent(
                    "r2",
                    "mars_project.IncineratorAgent",
                    new Object[] {}
            );
            r2.start();
            System.out.println("  -> r2 (IncineratorAgent) started");

            Thread.sleep(500);

            AgentController r1 = container.createNewAgent(
                    "r1",
                    "mars_project.ScannerAgent",
                    new Object[] {}
            );
            r1.start();
            System.out.println("  -> r1 (ScannerAgent) started");

            AgentController r3 = container.createNewAgent(
                    "r3",
                    "mars_project.PatrolAgent",
                    new Object[] {}
            );
            r3.start();
            System.out.println("  -> r3 (PatrolAgent) started");

            System.out.println("\n=== All agents started! ===");

        } catch (Exception e) {
            System.err.println("Error launching agents: " + e.getMessage());
            e.printStackTrace();
        }
    }
}