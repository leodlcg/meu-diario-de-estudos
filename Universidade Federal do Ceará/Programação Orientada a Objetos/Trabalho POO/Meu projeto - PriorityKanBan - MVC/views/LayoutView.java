package views;

public abstract class LayoutView {

    public void limparConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ignored){}
    }

    public void errorNaoNumero() {
        System.err.println("======================ERROR=====================");
        System.err.println("||         Você não digitou um número!        ||");
        System.err.println("||               tente novamente              ||");
        System.err.println("================================================");
        System.out.println("O que deseja fazer:");
    }

    public void errorOpcaoInexistente() {
        System.err.println("======================ERROR=====================");
        System.err.println("||       Você digitou uma opção inválida!     ||");
        System.err.println("||               tente novamente              ||");
        System.err.println("================================================");
        System.out.println("Escolha uma opção válida:");
    }

    public void errorSemKanbans() {
        System.err.println("======================ERROR=====================");
        System.err.println("||     Você não tem nenhum Kanban criado!     ||");
        System.err.println("||          Crie um primeiro: Digite 1        ||");
        System.err.println("================================================");
        System.out.println("O que deseja fazer:");
    }

    public void errorSemPiscinas() {
        System.err.println("======================ERROR=====================");
        System.err.println("||  O Kanban não tem nenhuma Piscina criada!  ||");
        System.err.println("||         Crie uma primeiro: Digite 2        ||");
        System.err.println("================================================");
        System.out.println("O que deseja fazer:");
    }

    public void errorSemAnotacoes() {
        System.err.println("======================ERROR=====================");
        System.err.println("||   Você não tem nenhuma anotação criada!    ||");
        System.err.println("||              Crie uma primeiro             ||");
        System.err.println("================================================");
        System.out.println("O que deseja fazer:");
    }

    public void errorNomeGrande() {
        System.err.println("======================ERROR=====================");
        System.err.println("||     Nome muito grande para o Kanban!       ||");
        System.err.println("||               Tente novamente              ||");
        System.err.println("================================================");
        System.out.println("Escreva um nome menor:");
    }

    public void errorNomePequeno() {
        System.err.println("======================ERROR=====================");
        System.err.println("||     Nome muito pequeno para o Kanban!      ||");
        System.err.println("||              Tente novamente               ||");
        System.err.println("================================================");
        System.out.println("Escreva um nome maior:");
    }

    public void errorNomePiscinaGrande() {
        System.err.println("======================ERROR=====================");
        System.err.println("||     Nome muito grande para a Piscina!      ||");
        System.err.println("||               Tente novamente              ||");
        System.err.println("================================================");
        System.out.println("Escreva um nome menor:");
    }

    public void errorNomePiscinaPequeno() {
        System.err.println("======================ERROR=====================");
        System.err.println("||     Nome muito pequeno para a Piscina!      ||");
        System.err.println("||               Tente novamente               ||");
        System.err.println("================================================");
        System.out.println("Escreva um nome maior:");
    }

}
