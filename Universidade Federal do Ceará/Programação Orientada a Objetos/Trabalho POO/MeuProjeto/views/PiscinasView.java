package views;
import model.Observer;
import model.Model;
import controllers.PiscinaController;

public class PiscinasView 
    extends LayoutView
    implements Observer {

    private PiscinaController piscinaController;
    private Model model;
    private int kanbanAtualIndex;

    public PiscinasView(Model Model){
        this.model = Model;
    }

    public void CriarController(){
            PiscinaController PiscinaController = new PiscinaController(); //Criando o controlador
            this.piscinaController = PiscinaController;
            piscinaController.Iniciar(this, model, this.kanbanAtualIndex); //Iniciando o controlador
    }


    public void CriarPiscina() {
        limparConsole();
        System.out.println("=========================Criar Piscina=========================");
        System.out.println("Defina um nome para nova Piscina!");
        System.out.println("==============================================================");
        System.out.println("Escreva o nome:");
        piscinaController.CriarPiscina();
    }


    public void AlterarPiscina() {
        limparConsole();
        System.out.println("=========================Alterar Piscina=========================");
        System.out.println("==============================================================");
        System.out.println("Escreva o novo nome:");
    }

    public void update(){};
}