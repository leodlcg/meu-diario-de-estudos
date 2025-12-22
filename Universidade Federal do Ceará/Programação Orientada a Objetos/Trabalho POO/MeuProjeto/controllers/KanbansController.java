package controllers;
import views.KanbansView;
import views.PiscinasView;
import views.AnotacoesView;
import model.Model;
import model.Observer;
import java.util.*;

public class KanbansController 
    implements Observer {
    
    private KanbansView kanbansView;
    private Model model;
    private int kanbanAtualIndex;

    public KanbansController(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public int getIndexAtual(){
        return this.kanbanAtualIndex;
    }

    public void setIndexAtual(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void Iniciar(KanbansView KanbansView, Model Model){
        this.kanbansView = KanbansView;
        this.model = Model;
        kanbansView.CriarKanban(); //Apos ter um controlador se mostra na tela!
    }

    public Scanner escolha = new Scanner(System.in);
    public void CriarKanban(){
        String numeroString = escolha.nextLine(); //Pega o Scanner e cria uma variavel local para escolha o Usuario!

        switch (numeroString) {
            case "1": //Opcao para criar KanbanVazio;
                model.CriarKanbanVazio();
                kanbansView.CriarKanbanVazio(this.kanbanAtualIndex);
                break;
            case "2":
                break;
            case "3":
                System.err.println("Dentro de 3");
                break;
            case "4":
                System.err.println("Dentro de 4");
                break;
            default:
                System.err.println("Apertou uma tecla errada!");
                break;
        }

    }


    public void CriarKanbanVazio(){
        String numeroString = escolha.nextLine(); //Pega o Scanner e cria uma variavel local para escolha o Usuario!
        switch (numeroString) {
            case "1": //Alterar o nome;
                kanbansView.AlterarNome();
                model.AlterarNomeKanban((model.getKanbans().size() - 1), numeroString);
                AlterarNome(); //Como esta criando um novo o index sera sempre o ultimo da lista!
                break;
            case "2": //Criar Piscina:
                PiscinasView PiscinasView = new PiscinasView(this.model);
                PiscinasView.CriarController();
                PiscinasView.CriarPiscina();
                kanbansView.CriarKanbanVazio(this.kanbanAtualIndex);
                break;
            case "3": //Editar Piscina:
                System.err.println("Dentro de 3");
                break;
            case "4": //Criar Anotacao:
                AnotacoesView AnotacoesView = new AnotacoesView(this.model);
                AnotacoesView.CriarController();
                AnotacoesView.EscolherPiscina();
                kanbansView.CriarKanbanVazio(this.kanbanAtualIndex);
                //model.CriarAnotacao(texto);
                System.err.println("Dentro de 4");
                break;
            default:
                System.err.println("Apertou uma tecla errada!");
                break;
        }

    }

    public void AlterarNome(){
        String nome = escolha.nextLine();
        if(nome != null){
            int id = model.getKanbans().size() - 1; //Kanban novo entao sempre sera o ultimo da lista!
            model.AlterarNomeKanban(id, nome);
            kanbansView.CriarKanbanVazio(this.kanbanAtualIndex);
        }
        
    }

    public String ObterNome(){
         return (model.getKanbans().get((model.getKanbans().size()) - 1).getNome()); // -1 para pegarmos o índice correto;
    }

    public int getQuantidadePiscinas(){
        return model.getKanbans().get(this.kanbanAtualIndex).getPiscinas().size();
    }

    public String getPiscinas(int PiscinaIndex){
        return model.getKanbans().get(this.kanbanAtualIndex).getPiscinas().get(PiscinaIndex).getNome();
    }

    public int getAnotacoesPiscinas(int PiscinaIndex){
        return model.getKanbans().get(this.kanbanAtualIndex).getPiscinas().get(PiscinaIndex).getAnotacoes().size();
    }

    public String getAnotacoes(int PiscinaIndex, int AnotacoesIndex){
        return model.getKanbans().get(this.kanbanAtualIndex).getPiscinas().get(PiscinaIndex).getAnotacoes().get(AnotacoesIndex);
    }


    public void update(){}

}
