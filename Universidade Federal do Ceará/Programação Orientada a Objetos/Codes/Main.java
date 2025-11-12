import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    String nome;

    Cliente(String nome) {
        this.nome = nome;
    }

    void mostrar() {
        System.out.println("Cliente: " + nome);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        System.out.print("Quantos clientes deseja cadastrar? ");
        int qtd = sc.nextInt();
        sc.nextLine(); // consome o '\n'

        for (int i = 0; i < qtd; i++) {
            System.out.print("Nome do cliente " + (i + 1) + ": ");
            String nome = sc.nextLine();
            clientes.add(new Cliente(nome)); // cria e guarda o objeto
        }

        System.out.println("\nLista de clientes cadastrados:");
        for (Cliente c : clientes) {
            c.mostrar();
        }

        sc.close();
    }
}
