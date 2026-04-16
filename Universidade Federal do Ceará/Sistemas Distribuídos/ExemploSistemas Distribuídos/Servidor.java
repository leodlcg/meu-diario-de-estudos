import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            AlunoImpl obj = new AlunoImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AlunoService", obj);
            System.out.println("Servidor RMI pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}