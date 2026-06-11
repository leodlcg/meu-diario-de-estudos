import java.io.ObjectOutputStream;
import java.net.Socket;

public class MobileUtils {
    public static void migrate(Agent agent, String signature, String host, int port) throws Exception {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            out.writeObject(new SignedAgent(agent, signature));
            out.flush();
        }
    }
}