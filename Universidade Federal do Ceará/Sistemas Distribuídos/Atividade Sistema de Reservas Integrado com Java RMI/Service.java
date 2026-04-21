import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    String buscar() throws RemoteException;
    String reservar(String nome) throws RemoteException;
}
