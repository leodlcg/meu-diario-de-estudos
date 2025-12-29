package views;
import model.Model;
import model.Observer;
import controllers.NavigationController;
import controllers.PaginaInicialController;

public class PaginaInicialView
    extends LayoutView 
    implements Observer{
    
    private Model model;
    private PaginaInicialController paginaInicialController;
    private int kanbanAtualIndex;


    public PaginaInicialView(Model Model, int KanbanAtualIndex){
            this.model = Model;
            this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void criarController(){
        PaginaInicialController paginaInicialController = new PaginaInicialController(); //Criando o controlador!
        this.paginaInicialController = paginaInicialController;
        NavigationController navigationController = new NavigationController(paginaInicialController); //Criando o navegador!
        paginaInicialController.iniciar(this, model, kanbanAtualIndex, navigationController); //Iniciando o controlador
    }

    
    public void priorityKanban(){
        limparConsole();
        System.out.println("===========PriorityKanBan===========");
        System.out.println("[1] Criar KanBan"+"                  ||");
        System.out.println("[2] Meus KanBans"+"                  ||");
        System.out.println("[3] Sobre o PriorityKanBan"+"        ||");
        System.out.println("[4] Fechar PriorityKanBan"+"         ||");
        System.out.println("====================================");
        System.out.println("O que deseja fazer:");
        paginaInicialController.usuarioEscolha();
    }

    public void escolherKanbans() {
        limparConsole();
        System.out.println("=================Meus KanBans================");
        System.out.println("Em qual KanBan deseja entrar?"+"              ||");
        System.out.println("=============================================");
        int quantidadeKanbans = paginaInicialController.getQuantidadeKanbans();
        for(int i = 0; quantidadeKanbans > i; i++){
            System.out.println("[" + (i + 1) + "] " + paginaInicialController.getKanbans(i) + " ".repeat(39 - paginaInicialController.getTamanhoNomeKanban(i)) + "||");
        }
        System.out.println("[0] Voltar"+"                                 ||");
        System.out.println("=============================================");
        System.out.println("Escolha o KanBan:");
        paginaInicialController.escolherKanbans();
    }

    public void sobrePriorityKanBan(){
        limparConsole();
        System.out.println("=============Sobre PriorityKanBan=============");
        System.out.println("Chega de deixar para depois o que precisa"+"  ||");
        System.out.println("ser feito hoje. Nosso aplicativo de Kanban"+" ||");
        System.out.println("de Prioridades foi criado para ajudar você"+" ||");
        System.out.println("a visualizar suas tarefa, definir o que"+"    ||");
        System.out.println("realmente importa e transformar seus planos"+"||");
        System.out.println("cotidianos em ações! Venha conosco!"+"        ||");
        System.out.println("==============================================");
        System.out.println("[0] Voltar"+"                                 ||");
        System.out.println("==============================================");
        System.out.println("O que deseja fazer:");
        paginaInicialController.usuarioEscolhaSobre();
    }


    public void fechando(){
        limparConsole();
        System.out.println("===========PriorityKanBan===========");
        System.out.println("Sentiremos sua falta :(           ||");;
        System.out.println("====================================");
    }


    public void update(String update){};

}
