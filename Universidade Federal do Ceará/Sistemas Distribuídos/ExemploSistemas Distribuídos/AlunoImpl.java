import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class AlunoImpl extends UnicastRemoteObject implements Aluno {
    private Map<String, String> alunos;

    public AlunoImpl() throws RemoteException {
        alunos = new HashMap<>();
    }

    public void cadastrarAluno(String nome, String matricula) throws RemoteException {
        alunos.put(matricula, nome);
        System.out.println("Aluno cadastrado: " + nome + " (" + matricula + ")");
    }

    public String consultarAluno(String matricula) throws RemoteException {
        String nome = alunos.get(matricula);
        if (nome != null) {
            return "Aluno: " + nome + " (Matricula: " + matricula + ")";
        } else {
            return "Aluno nao encontrado.";
        }
    }

    public List<String> listarAlunos() throws RemoteException {
        List<String> lista = new ArrayList<>();
        for (Map.Entry<String, String> entry : alunos.entrySet()) {
            lista.add(entry.getValue() + " (" + entry.getKey() + ")");
        }
        return lista;
    }
}