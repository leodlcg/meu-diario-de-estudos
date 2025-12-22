import model.*;
import view.*;

public class SistemaTesteMVC {

	public static void main(String[] args) {
		Model model = Model.getInstancia(); // Primeiro instancia-se o modelo
		MainView view = new MainView(); // Depois cria-se a primeira view
		view.init(model); // Por fim, inicializa a view passando o modelo
	}
}
