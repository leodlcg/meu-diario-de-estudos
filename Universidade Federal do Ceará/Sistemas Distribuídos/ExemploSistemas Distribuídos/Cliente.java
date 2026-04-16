import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Aluno stub = (Aluno) registry.lookup("AlunoService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Cadastrar aluno\n2. Consultar aluno\n3. Listar alunos\n4. Sair");
                System.out.print("Escolha: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Matricula: ");
                    String matricula = scanner.nextLine();
                    stub.cadastrarAluno(nome, matricula);
                } else if (opcao == 2) {
                    System.out.print("Matricula: ");
                    String matricula = scanner.nextLine();
                    String resultado = stub.consultarAluno(matricula);
                    System.out.println(resultado);
                } else if (opcao == 3) {
                    List<String> alunos = stub.listarAlunos();
                    System.out.println("Alunos cadastrados:");
                    for (String a : alunos) {
                        System.out.println(a);
                    }
                } else if (opcao == 4) {
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}