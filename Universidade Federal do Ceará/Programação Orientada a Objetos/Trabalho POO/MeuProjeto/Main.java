import model.Model;
import views.PaginaInicialView;

public class Main {
    // Codigo vai inicar por aqui!
    public static void main(String args[]){
    Model model = new Model(); //Instanciando model!
    PaginaInicialView PaginaInicial = new PaginaInicialView(model, 0); //Instanciando PaginaInicial passando o model e index 0!
    PaginaInicial.CriarController(); 
    }
}