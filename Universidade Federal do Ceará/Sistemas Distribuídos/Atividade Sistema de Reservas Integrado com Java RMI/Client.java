import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        Service service = (Service) registry.lookup("service");

        System.out.println(service.buscar());
        System.out.println(service.reservar("Joao"));
        System.out.println(service.buscar());
    }
}
