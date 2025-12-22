package controllers;
import views.AnotacoesView;
import model.Kanban;
import model.Model;
import model.Observer;
import java.util.*;

public class AnotacoesController 
    implements Observer{
    
    private AnotacoesView anotacoesView;
    private Model model;
    private int kanbanAtualIndex;
    private int piscinaAtualIndex;


    public void Iniciar(AnotacoesView AnotacoesView, Model Model, int KanbanAtualIndex){
        this.anotacoesView = AnotacoesView;
        this.model = Model;
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    Scanner escolha = new Scanner(System.in);
    public void EscolherPiscina(){
    String numeroString = escolha.nextLine();
    if(numeroString == "0"){
        return;
    }

    this.piscinaAtualIndex = Integer.parseInt(numeroString);
    anotacoesView.CriarAnotacao(numeroString);

    }

    public void CriarAnotacao(String numeroString){
        String texto = escolha.nextLine();
        model.CriarAnotacao(this.kanbanAtualIndex, this.piscinaAtualIndex, texto);
    }

    public String getPiscinas(int i){
        return model.getKanbans().get(kanbanAtualIndex).getPiscinas().get(i).getNome();
    }

    public int getQuantidadePiscinas(){
        return model.getKanbans().get(kanbanAtualIndex).getPiscinas().size();
    }

    public int getAnotacoesPiscinas(int PiscinaIndex){
        return model.getKanbans().get(kanbanAtualIndex).getPiscinas().get(PiscinaIndex).getAnotacoes().size();
    }

    public void update(){}
}