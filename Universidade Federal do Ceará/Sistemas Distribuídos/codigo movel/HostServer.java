import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HostServer {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Uso: java HostServer <nomeHost> <porta> <listaNumerosCSV>");
            System.out.println("Exemplo: java HostServer HostA 5000 1,2,3,4");
            return;
        }

        String hostName = args[0];
        int port = Integer.parseInt(args[1]);

        List<Integer> numbers = Arrays.stream(args[2].split(","))
                                      .map(String::trim)
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        HostContext context = new HostContext(hostName, numbers);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[" + hostName + "] Escutando na porta " + port + "...");

            while (true) {
                try (Socket client = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(client.getInputStream())) {

                    Object obj = in.readObject();

                    if (!(obj instanceof SignedAgent signedAgent)) {
                        System.out.println("[" + hostName + "] Objeto recebido nao eh um agente assinado.");
                        continue;
                    }

                    if (!SimpleSecurity.isTrusted(signedAgent)) {
                        System.out.println("[" + hostName + "] Agente rejeitado por falha de assinatura.");
                        continue;
                    }

                    Agent agent = signedAgent.getAgent();
                    System.out.println("[" + hostName + "] Agente recebido: " + agent.getName());
                    agent.execute(context);

                } catch (Exception e) {
                    System.out.println("[" + hostName + "] Erro ao processar agente: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}