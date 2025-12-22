package views;
import model.Observer;
import model.Model;
import controllers.AnotacoesController;

public class AnotacoesView 
    extends LayoutView
    implements Observer {

    private AnotacoesController anotacoesController;
    private Model model;
    private int kanbanAtualIndex;

    public AnotacoesView(Model Model){
        this.model = Model;
    }

    public void CriarController(){
        AnotacoesController AnotacoesController = new AnotacoesController(); //Criando o controlador
        this.anotacoesController = AnotacoesController;
        anotacoesController.Iniciar(this, model, this.kanbanAtualIndex); //Iniciando o controlador
    }

    public void EscolherPiscina() {
        limparConsole();
        System.out.println("=========================Criar Anotação=========================");
        System.out.println("Em qual Piscina deseja criar a Anotação?");
        int quantidadePiscinas = anotacoesController.getQuantidadePiscinas();
        for(int i = 0; quantidadePiscinas > i; i++){
            System.out.println("[" + (i + 1) + "] " + anotacoesController.getPiscinas(i));
        }
        System.out.println("[0] Voltar");
        System.out.println("==============================================================");
        System.out.println("Escolha a Piscina:");
        anotacoesController.EscolherPiscina();
    }

    public void CriarAnotacao(String piscinaAtualIndex) {
        limparConsole();
        System.out.println("=========================Criar Anotação=========================");
        System.out.println("Escreva o texto que deseja adicionar:");
        System.out.println("==============================================================");
        System.out.println("Escreva seu texto:");
        anotacoesController.CriarAnotacao(piscinaAtualIndex);
    }

    public void AlterarAnotaca() {
        limparConsole();
        System.out.println("=========================Alterar Anotação=========================");
        System.out.println("==============================================================");
        System.out.println("Escreva o novo nome:");
    }

    public void update(){};
}