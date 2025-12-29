package views;
import model.Model;
import model.Observer;
import controllers.AnotacoesController;
import controllers.NavigationController;

public class AnotacoesView 
    extends LayoutView
    implements Observer {

    private Model model;
    private AnotacoesController anotacoesController;
    private NavigationController navigationController;
    private int kanbanAtualIndex;

    public void setKanbanAtualIndex(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public AnotacoesView(Model Model, NavigationController NavigationController, int KanbanAtualIndex){
        this.model = Model;
        this.navigationController = NavigationController;
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void criarController(){
        AnotacoesController AnotacoesController = new AnotacoesController(); //Criando o controlador
        this.anotacoesController = AnotacoesController;
        navigationController.setAnotacoesController(AnotacoesController);
        navigationController.setKanbanAtualIndex(this.kanbanAtualIndex);
        anotacoesController.iniciar(this, model, this.kanbanAtualIndex, this.navigationController); //Iniciando o controlador
    }

    public void escolherPiscinaCriar() {
        limparConsole();
        System.out.println("=================Criar Anotação=================");
        System.out.println("Em qual Piscina deseja criar a Anotação?"+"      ||");
        System.out.println("================================================");
        int quantidadePiscinas = anotacoesController.getQuantidadePiscinas();
        for(int i = 0; quantidadePiscinas > i; i++){
            System.out.println("[" + (i + 1) + "] " + anotacoesController.getPiscinas(i) + " ".repeat(42 - anotacoesController.getTamanhoNomePiscina(i)) + "||");
        }
        System.out.println("================================================");
        System.out.println("[0] Voltar"+"                                    ||");
        System.out.println("================================================");
        System.out.println("Escolha a Piscina:");
        anotacoesController.escolherPiscinaCriar();
    }

    public void criarAnotacao(String piscinaAtualIndex) {
        limparConsole();
        System.out.println("=================Criar Anotação=================");
        System.out.println("Escreva o texto que deseja adicionar:"+"        ||");
        System.out.println("================================================");
        System.out.println("[0] Voltar"+"                                   ||");
        System.out.println("================================================");
        System.out.println("Escreva seu texto:");
        anotacoesController.criarAnotacao(piscinaAtualIndex);
    }

    public void escolherPiscinaAlterar(int KanbanAtualIndex){
        anotacoesController.setKanbanAtualIndex(KanbanAtualIndex);
        limparConsole();
        System.out.println("=================Alterar Anotação=================");
        System.out.println("Em qual Piscina deseja alterar uma Anotação?"+"    ||");
        System.out.println("==================================================");
        int quantidadePiscinas = anotacoesController.getQuantidadePiscinas();
        for(int i = 0; quantidadePiscinas > i; i++){
            System.out.println("[" + (i + 1) + "] " + anotacoesController.getPiscinas(i) + " ".repeat(44 - anotacoesController.getTamanhoNomePiscina(i)) + "||");
        }
        System.out.println("==================================================");
        System.out.println("[0] Voltar"+"                                      ||");
        System.out.println("==================================================");
        System.out.println("Escolha a Piscina:");
        anotacoesController.escolherPiscinaAlterar();
    }

    public void escolherAnotacao(String PiscinaAtualIndex) {
        limparConsole();
        System.out.print("=================Alterar Anotação=================");
        int quantidadeAnotacaoes = anotacoesController.getQuantidadeAnotacoes(Integer.parseInt(PiscinaAtualIndex) - 1);
        for(int i = 0; quantidadeAnotacaoes > i; i++){
            if(i == 0){
                System.out.print("\n");
            }
            System.out.println("[" + (i + 1) + "]");
            exibirAnotacoes(PiscinaAtualIndex, i);
        }
        System.out.println("==================================================");
        System.out.println("[0] Voltar"+"                                      ||");
        System.out.println("==================================================");
        System.out.println("Escolha a Anotação:");
        anotacoesController.escolherAnotacao(PiscinaAtualIndex);
    }

    public void alterarAnotacao(String PiscinaAtualIndex, String AnotacaoAtualIndex) {
        limparConsole();
        System.out.println("=================Alterar Anotação=================");   
        System.out.println("Anotação escolhida:");
            exibirAnotacoes(PiscinaAtualIndex, (Integer.parseInt(AnotacaoAtualIndex) - 1));
        System.out.println("============MENU============");
        System.out.println("[1] Alterar Texto         ||");
        System.out.println("[2] Apagar Anotação       ||");
        System.out.println("[0] Voltar                ||");
        System.out.println("============================");
        System.out.println("O que deseja fazer:");
        anotacoesController.alterarAnotacao(PiscinaAtualIndex, AnotacaoAtualIndex);
    }

    public void exibirAnotacoes(String piscinaAtualIndex, int AnotacaoIndex) {
              
        String Texto = anotacoesController.getAnotacoes((Integer.parseInt(piscinaAtualIndex) - 1), AnotacaoIndex);
        String[] linhas = Texto.split("\n");
        for (int k = 0; k < linhas.length; k++) {
            System.out.println(linhas[k]);
        }
    }

    public void alterarAnotacaoEscrever() {
        System.out.println("=================Alterar Anotação=================");   
        System.out.println("Escreva o novo texto que deseja adicionar:      ||");
        System.out.println("==================================================");
        System.out.println("Escreva seu texto:");
    }

    public void update(String update){};
}