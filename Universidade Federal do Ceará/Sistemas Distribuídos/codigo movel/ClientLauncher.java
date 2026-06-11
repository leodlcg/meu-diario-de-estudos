import java.util.List;

public class ClientLauncher {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Uso: java ClientLauncher <hostInicial> <portaInicial>");
            System.out.println("Exemplo: java ClientLauncher localhost 5000");
            return;
        }

        String initialHost = args[0];
        int initialPort = Integer.parseInt(args[1]);
        String signature = "TOKEN-UNIVERSIDADE-2026";

        List<HostStep> route = List.of(
                new HostStep("localhost", 5000),
                new HostStep("localhost", 5001)
        );

        SumAgent agent = new SumAgent("AgenteSomador", route, signature);
        MobileUtils.migrate(agent, signature, initialHost, initialPort);

        System.out.println("Agente enviado para o host inicial " + initialHost + ":" + initialPort);
    }
}