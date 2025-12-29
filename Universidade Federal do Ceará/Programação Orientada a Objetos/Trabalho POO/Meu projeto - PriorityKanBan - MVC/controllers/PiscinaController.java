package controllers;
import views.PiscinasView;
import model.Model;
import model.Observer;
import util.Entrada;

public class PiscinaController 
    implements Observer{
    
    private PiscinasView piscinasView;
    private Model model;
    private NavigationController navigationController;
    private int kanbanAtualIndex;
     private int piscinaAtualIndex;

    public void iniciar(PiscinasView PiscinasView, Model Model, NavigationController NavigationController, int KanbanAtualIndex){
        this.piscinasView = PiscinasView;
        this.model = Model;
        this.navigationController = NavigationController;
        this.kanbanAtualIndex = KanbanAtualIndex;
        NavigationController.setPiscinaController(this);
    }

    public PiscinasView getPiscinasView(){
            return this.piscinasView;
    }

    public void setKanbanAtualIndex(int KanbanAtualIndex){
            this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void setPiscinaAtualIndex(int PiscinaAtualIndex){
            this.piscinaAtualIndex = PiscinaAtualIndex;
    }
    
    public void criarPiscina(){
    if(model.getPriorityKanBanIniciado()){
        String nome = Entrada.Escolha();
        if("0".equals(nome)){
            navigationController.voltarCriarKanban();
        }
        if(nome.length() > 30){
            update("NomeGrande");
        }
        if(nome.length() < 3){
            update("NomePequeno");
        }
        if(nome.length() < 30 && nome.length() > 3){
            model.criarPiscinaVazia(this.kanbanAtualIndex, nome);
        }
    }
    }

    public int getQuantidadePiscinas(){
        return model.getQuantidadePiscinas(this.kanbanAtualIndex);
    }

    public String getPiscinas(int PiscinaAtualIndex){
        return model.getPiscinas(this.kanbanAtualIndex, PiscinaAtualIndex);
    }

    public int getTamanhoNomePiscina(int PiscinaAtualIndex){
        return model.getTamanhoNomePiscina(this.kanbanAtualIndex, PiscinaAtualIndex);
    }

    public void escolherAlterarPiscina(){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringEscolherPiscina = Entrada.Escolha();
        if (model.validarEntrada(numeroStringEscolherPiscina)) {

            if("0".equals(numeroStringEscolherPiscina)){
            navigationController.voltarCriarKanban();
            }

            if((Integer.parseInt(numeroStringEscolherPiscina) -  1) < model.getQuantidadePiscinas(this.kanbanAtualIndex)){
                setPiscinaAtualIndex((Integer.parseInt(numeroStringEscolherPiscina) -  1));
                piscinasView.alterarPiscina(this.piscinaAtualIndex);
            }else{
                update("OpcaoInexistenteEscolherAlterarPiscina");
            }
        }else{
            update("NaoNumeroEscolherAlterarPiscina");
        }

    }
    }

    public void alterarPiscina(int PiscinaAtualIndex){ //index ja ajustado
    if(model.getPriorityKanBanIniciado()){
        String numeroStringAlterarPiscina = Entrada.Escolha();
        if (model.validarEntrada(numeroStringAlterarPiscina)) {

            if("0".equals(numeroStringAlterarPiscina)){
                piscinasView.escolherAlterarPiscina();
            }

            switch (numeroStringAlterarPiscina) {
                case "1": //Alterar nome
                update("RenomearPiscina");
                    piscinasView.alterarPiscinaEscrever();
                    navigationController.voltarCriarKanban();
                    break;
                case "2": //Apagar piscina
                    model.apagarPiscina(this.kanbanAtualIndex, PiscinaAtualIndex);
                    navigationController.voltarCriarKanban();
                default:
                    update("OpcaoInexistenteAlterarPiscina");
                    break;
            }
        }else{
            update("NaoNumeroAlterarPiscina");
        }
    }
    }

    public void renomearPiscina(int PiscinaAtualIndex){  //index ja ajustado
    if(model.getPriorityKanBanIniciado()){
        String nome = Entrada.Escolha();
        model.alterarNomePiscina(this.kanbanAtualIndex, PiscinaAtualIndex, nome);
    }
    }

    public void update(String update){
        if(update.equals("NomeGrande")){
            piscinasView.errorNomePiscinaGrande();
            criarPiscina();
        }
        if(update.equals("NomePequeno")){
            piscinasView.errorNomePiscinaPequeno();
            criarPiscina();
        }
        if(update.equals("NaoNumeroEscolherAlterarPiscina")){
            piscinasView.errorNaoNumero();
            escolherAlterarPiscina();
        }
        if(update.equals("OpcaoInexistenteEscolherAlterarPiscina")){
            piscinasView.errorOpcaoInexistente();
            escolherAlterarPiscina();
        }
        if(update.equals("NaoNumeroAlterarPiscina")){
            piscinasView.errorNaoNumero();
            alterarPiscina(this.piscinaAtualIndex);
        }
        if(update.equals("OpcaoInexistenteAlterarPiscina")){
            piscinasView.errorOpcaoInexistente();
            alterarPiscina(this.piscinaAtualIndex);
        }
        if(update.equals("RenomearPiscina")){
            piscinasView.alterarPiscinaEscrever();
            renomearPiscina(this.piscinaAtualIndex);
        }
    }
}