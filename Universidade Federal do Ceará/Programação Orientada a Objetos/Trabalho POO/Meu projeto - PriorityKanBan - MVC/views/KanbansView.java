package views;

import model.Model;
import model.Observer;
import controllers.KanbansController;
import controllers.NavigationController;

public class KanbansView 
    extends LayoutView 
    implements Observer{

    private Model model;
    private KanbansController kanbansController; 
    private NavigationController navigationController;
    private int kanbanAtualIndex;

    public KanbansView(int KanbanAtualIndex, Model Model, NavigationController navigationController){
        this.kanbanAtualIndex = KanbanAtualIndex;
        this.model = Model;
        this.navigationController = navigationController;
    }

    public int getIndexAtual(){
        return this.kanbanAtualIndex;
    }

    public void setIndexAtual(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void criarController(){
        KanbansController KanbansController = new KanbansController(this.kanbanAtualIndex); //Criando o controlador;
        this.kanbansController = KanbansController;
        navigationController.setKanbansController(KanbansController);
        navigationController.setKanbanAtualIndex(this.kanbanAtualIndex);
        kanbansController.iniciar(this, model, this.navigationController); //Iniciando o controlador
    }

    public void criarKanban(){
        limparConsole();
        System.out.println("==========Criar Kanban==========");
        System.out.println("[1] Criar Kanban Vazio"+"        ||");
        System.out.println("[0] Voltar"+"                    ||");
        System.out.println("================================");
        System.out.println("O que deseja fazer:");
        kanbansController.criarKanban();
    }
    
    public void criarKanbanVazio(int KanbanAtualIndex){
        limparConsole();
        kanbansController.setKanbanAtualIndex(KanbanAtualIndex);
        int QuantidadePiscinas = kanbansController.getQuantidadePiscinas();
        limparConsole();
        System.out.println("=".repeat(QuantidadePiscinas == 0 ? 15 : QuantidadePiscinas * 15) + kanbansController.getNomeKanban() + "=".repeat(QuantidadePiscinas == 0 ? 15 : QuantidadePiscinas * 15)); //Ao mexer no menu este kanban que esta sendo criado deve se atualizar automaticamente!
        exibirPiscinas();
        if(kanbansController.getQuantidadePiscinas() > 0){
           System.out.println(""); //Espacamento 
        }
        exibirAnotacoes();
        System.out.println("=".repeat(QuantidadePiscinas == 0 ? (30 + kanbansController.getTamanhoNomeKanBan()) : (QuantidadePiscinas * 30) + kanbansController.getTamanhoNomeKanBan()));
        System.out.println("============MENU============");
        System.out.println("[1] Alterar Nome          ||");
        System.out.println("[2] Criar Piscina         ||");
        System.out.println("[3] Editar Piscina        ||");
        System.out.println("[4] Criar Anotação        ||");
        System.out.println("[5] Editar Anotação       ||");
        System.out.println("[0] Voltar                ||");
        System.out.println("============================");
        System.out.println("O que deseja fazer:");
        kanbansController.criarKanbanVazio();
    }

    public void alterarNome() {
        limparConsole();
        System.out.println("===================Alterar Nome===================");
        System.out.println("Alterando o nome de: " + kanbansController.getNomeKanban() + " ".repeat((27 - kanbansController.getTamanhoNomeKanBan())) + "||");
        System.out.println("==================================================");
        System.out.println("[0] Voltar"+"                                      ||");
        System.out.println("==================================================");
        System.out.println("Escreva o novo nome:");
        kanbansController.alterarNome();
    }

    public void exibirPiscinas(){
        int quantidadePiscinas = kanbansController.getQuantidadePiscinas();
        if(quantidadePiscinas > 0){
            for(int i = 0; i < quantidadePiscinas;i++){
                int TamanhoNomePiscina = kanbansController.getTamanhoNomePiscina(i);
                System.out.print(kanbansController.getPiscinas(i)+ ":" + " ".repeat(28 - TamanhoNomePiscina));
            }
        }else{
            System.out.println("|| " + "==========================");
            System.out.println("|| " + "|| Nenhuma Piscina foi  ||");
            System.out.println("|| " + "|| criada neste Kanban  ||");
            System.out.println("|| " + "==========================");
        }
    }

    public void exibirAnotacoes() {
        int quantidadePiscinas = kanbansController.getQuantidadePiscinas();
        if (quantidadePiscinas > 0) {
            for (int i = 0; i < quantidadePiscinas; i++) {
                int quantidadeAnotacoes = kanbansController.getQuantidadeAnotacoesPiscinas(i);
                if (quantidadeAnotacoes > 0) {
                    for (int j = 0; j < quantidadeAnotacoes; j++) {
                        String Texto = kanbansController.getAnotacoes(i, j);
                        String[] linhas = Texto.split("\n");
                        for (int k = 0; k < linhas.length; k++) {
                            System.out.print(" ".repeat(i * 30) + linhas[k] + "\n");
                        }
                    }
                } else {
                    System.out.println(" ".repeat((i * 29)) + "========================== ");
                    System.out.println(" ".repeat((i * 29)) + "|| Nenhuma Anotação foi || ");
                    System.out.println(" ".repeat((i * 29)) + "|| criada nesta Piscina || ");
                    System.out.println(" ".repeat((i * 29)) + "========================== ");
                }
            }
        }
    }

    public void update(String update){};

}
