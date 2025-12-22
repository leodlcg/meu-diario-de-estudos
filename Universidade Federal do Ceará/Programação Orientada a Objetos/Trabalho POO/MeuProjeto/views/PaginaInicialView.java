package views;
import model.Model;
import model.Observer;
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

    public void CriarController(){
        PaginaInicialController paginaInicialController = new PaginaInicialController(); //Criando o controlador
        this.paginaInicialController = paginaInicialController;
        paginaInicialController.Iniciar(this, model, kanbanAtualIndex); //Iniciando o controlador
    }

    
    public void ExibirTela(){
        limparConsole();
        System.out.println("===================SimpleKanBan===================");
        System.out.println("[1] Criar KanBan");
        System.out.println("[2] Meus KanBans");
        System.out.println("[3] Fechar SimpleKanBan");
        System.out.println("==================================================");
        System.out.println("O que deseja fazer:");
        paginaInicialController.UsuarioEscolha();
    }


    public void update(){};

}
