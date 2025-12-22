package controllers;
import views.PaginaInicialView;
import views.KanbansView;
import model.Model;
import model.Observer;
import java.util.*;

public class PaginaInicialController 
    implements Observer {
    
    private PaginaInicialView paginaInicialView;
    private Model model;
    private int kanbanAtualIndex;

    public int getIndexAtual(){
        return this.kanbanAtualIndex;
    }

    public void setIndexAtual(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void Iniciar(PaginaInicialView PaginaInicialView, Model Model, int KanbanAtualIndex){
        this.paginaInicialView = PaginaInicialView;
        this.model = Model;
        this.kanbanAtualIndex = KanbanAtualIndex;
        paginaInicialView.ExibirTela(); //Apos ter um controlador se mostra na tela!
    }

    public Scanner escolha = new Scanner(System.in);
    public void UsuarioEscolha(){
        String numeroString = escolha.nextLine(); //Pega o Scanner e cria uma variavel local para escolha o Usuario!
        switch (numeroString) {
            case "1": //Criar KanBan;
                KanbansView kanbansView = new KanbansView(this.kanbanAtualIndex, this.model); //Como e novo sempre sera o ultimo da lista!
                kanbansView.CriarController();            
                break;
            case "2":
                System.err.println("Dentro de 2");
                break;
            case "3":
                System.err.println("AQUI E PARA FECHAR O SOFTWARE");
                escolha.close();
                break;
            default:
                System.err.println("Apertou uma tecla errada!");
                break;
        }

    }

    public void update(){}

}
