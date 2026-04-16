import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Aluno extends Remote {
    void cadastrarAluno(String nome, String matricula) throws RemoteException;
    String consultarAluno(String matricula) throws RemoteException;
    List<String> listarAlunos() throws RemoteException;
}