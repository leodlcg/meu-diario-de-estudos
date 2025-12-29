package views;
import model.Observer;
import model.Model;
import controllers.NavigationController;
import controllers.PiscinaController;

public class PiscinasView 
    extends LayoutView
    implements Observer {

    private Model model;
    private PiscinaController piscinaController;
    private NavigationController navigationController;
    private int kanbanAtualIndex;

    public PiscinasView(Model Model, NavigationController NavigationController, int KanbanAtualIndex){
        this.model = Model;
        this.navigationController = NavigationController;
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void criarController(){
            PiscinaController PiscinaController = new PiscinaController(); //Criando o controlador
            this.piscinaController = PiscinaController;
            piscinaController.iniciar(this, this.model, this.navigationController, this.kanbanAtualIndex); //Iniciando o controlador
    }


    public void criarPiscina() {
        limparConsole();
        System.out.println("================Criar Piscina================");
        System.out.println("Defina um nome para nova Piscina!"+"          ||");
        System.out.println("=============================================");
        System.out.println("[0] Voltar"+"                                 ||");
        System.out.println("=============================================");
        System.out.println("Escreva o nome:");
        piscinaController.criarPiscina();
    }


    public void escolherAlterarPiscina(){
        limparConsole();
        System.out.println("================Alterar Piscina================");
        System.out.println("Qual Piscina deseja editar?                  ||");
        int quantidadePiscinas = piscinaController.getQuantidadePiscinas();
        for(int i = 0; quantidadePiscinas > i; i++){
            System.out.println("[" + (i + 1) + "] " + piscinaController.getPiscinas(i) + " ".repeat(41 - piscinaController.getTamanhoNomePiscina(i)) + "||");
        }
        System.out.println("===============================================");
        System.out.println("[0] Voltar"+"                                   ||");
        System.out.println("===============================================");
        System.out.println("Escolha a Piscina:");
        piscinaController.escolherAlterarPiscina();
    }

    public void alterarPiscina(int PiscinaAtualIndex) { //Index ja ajustado!
        limparConsole();
        System.out.println("=================Alterar Piscina =================");   
        System.out.println("Piscina escolhida:");
        System.out.println(piscinaController.getPiscinas(PiscinaAtualIndex));
        System.out.println("============MENU============");
        System.out.println("[1] Alterar Nome          ||");
        System.out.println("[2] Apagar Piscina       ||");
        System.out.println("[0] Voltar                ||");
        System.out.println("============================");
        System.out.println("O que deseja fazer:");
        piscinaController.alterarPiscina(PiscinaAtualIndex);
    }

    public void alterarPiscinaEscrever() {
        System.out.println("=================Alterar Piscina=================");   
        System.out.println("Escreva o novo nome que deseja adicionar:     ||");
        System.out.println("=================================================");
        System.out.println("Escreva o nome:");
    }

    public void update(String update){};
}