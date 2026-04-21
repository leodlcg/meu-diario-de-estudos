import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ServiceImpl extends UnicastRemoteObject implements Service {

    private int vagas = 5;

    protected ServiceImpl() throws RemoteException {
        super();
    }

    public synchronized String buscar() throws RemoteException {
        return "Vagas disponiveis: " + vagas;
    }

    public synchronized String reservar(String nome) throws RemoteException {
        if (vagas > 0) {
            vagas--;
            return "Reserva feita para " + nome;
        }
        return "Sem vagas";
    }
}
