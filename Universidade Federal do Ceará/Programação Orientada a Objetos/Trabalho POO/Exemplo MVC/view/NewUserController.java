package view;

import model.Model;
import model.Usuario;

public class NewUserController implements Observer{
	private Model model;
	private NewUserView view;
	
	public void init(Model model, NewUserView view) {
		this.model = model;
		this.view = view;
		model.attachObserver(this);
	}
	public void handleEvent(String event) {
		switch (event) {
		case "OK" :			
			model.setUsuario(view.getNome(), view.getLogin(),view.getSenha());
			model.detachObserver(this);
			break;			
		}
	}

	public void update() {
	}
}
