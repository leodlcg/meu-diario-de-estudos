package controllers;
import views.PiscinasView;
import model.Model;
import model.Observer;
import java.util.*;

public class PiscinaController 
    implements Observer{
    
    private PiscinasView piscinasView;
    private Model model;
    private int kanbanAtualIndex;


    public void Iniciar(PiscinasView PiscinasView, Model Model, int KanbanAtualIndex){
        this.piscinasView = PiscinasView;
        this.model = Model;
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    Scanner escolha = new Scanner(System.in);
    public void CriarPiscina(){
        String nome = escolha.nextLine();
        if(nome != null){
            model.CriarPiscinaVazia(this.kanbanAtualIndex, nome);
        }

    }


    public void update(){}
}