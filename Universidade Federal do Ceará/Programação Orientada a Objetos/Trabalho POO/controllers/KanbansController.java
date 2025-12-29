package controllers;
import views.KanbansView;
import views.PiscinasView;
import views.AnotacoesView;
import model.Model;
import model.Observer;
import util.Entrada;

public class KanbansController 
    implements Observer {
    
    private KanbansView kanbansView;
    private Model model;
    private NavigationController navigationController;
    private int kanbanAtualIndex;

    public KanbansController(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }
    
    public KanbansView getKanbansView(){
        return this.kanbansView;
    }

    public int getKanbanAtualIndex(){
        return this.kanbanAtualIndex;
    }

    public void setKanbanAtualIndex(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void iniciar(KanbansView KanbansView, Model Model, NavigationController NavigationController){
        this.kanbansView = KanbansView;
        this.model = Model;
        this.navigationController = NavigationController;
        kanbansView.criarKanban(); //Apos ter um controlador se mostra na tela!
    }
    
    public void criarKanban(){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringKanban = Entrada.Escolha(); //Pega o Scanner e cria uma variavel local para escolha o Usuario!

        if(model.validarEntrada(numeroStringKanban)){
            switch (numeroStringKanban) {
            case "1": //Opcao para criar KanbanVazio;
                model.criarKanbanVazio();
                this.kanbanAtualIndex = model.getKanbans().size() - 1; //Para pegar o index correto!
                this.navigationController.setKanbanAtualIndex(this.kanbanAtualIndex);
                kanbansView.criarKanbanVazio(this.kanbanAtualIndex);
                break;
            case "0": //Opcao para voltar;
                navigationController.voltarPaginaInicial();
                break;
            default:
                update("OpcaoInexistenteCriarKanban");
                break;
        }
        }else{
            update("NaoNumeroCriarKanban");
        }
    }
    }

    public void criarKanbanVazio(){
    if(model.getPriorityKanBanIniciado()){
        navigationController.setKanbanAtualIndex(this.kanbanAtualIndex);
        String numeroStringKanbanVazio = Entrada.Escolha(); //Pega o Scanner e cria uma variavel local para escolha o Usuario!
        if(model.validarEntrada(numeroStringKanbanVazio)){
            switch (numeroStringKanbanVazio) {
                case "1": //Alterar o nome;
                    kanbansView.alterarNome();
                    alterarNome();
                    model.alterarNomeKanban(this.kanbanAtualIndex, numeroStringKanbanVazio);
                    break;
                case "2": //Criar Piscina:
                    PiscinasView PiscinasView = new PiscinasView(this.model, this.navigationController, this.kanbanAtualIndex);
                    PiscinasView.criarController();
                    PiscinasView.criarPiscina();
                    kanbansView.criarKanbanVazio(this.kanbanAtualIndex);
                    break;
                case "3": //Editar Piscina:
                    if(model.getQuantidadePiscinas(this.kanbanAtualIndex) == 0){
                        update("SemPiscinas");
                    }                   
                    navigationController.navegarEscolherPiscinaEditar(this.kanbanAtualIndex);
                    System.err.println("Dentro de 3");
                    break;
                case "4": //Criar Anotacao:
                    if(model.getQuantidadePiscinas(this.kanbanAtualIndex) == 0){
                        update("SemPiscinas");
                    }
                    AnotacoesView AnotacoesView = new AnotacoesView(this.model, this.navigationController, this.kanbanAtualIndex);
                    AnotacoesView.criarController();
                    AnotacoesView.escolherPiscinaCriar();
                    kanbansView.criarKanbanVazio(this.kanbanAtualIndex);
                    break;
                case "5": //Editar Anotacao:
                    if(model.getQuantidadePiscinas(this.kanbanAtualIndex) == 0){
                        update("SemPiscinas");
                    }
                    if(navigationController.getAnotacoesController() == null){
                        update("SemAnotacoes");
                    }
                    navigationController.navegarEscolherPiscinaAlterar();
                    break;
                case "0": //Voltar;
                    navigationController.voltarPaginaInicial();
                    break;
                default:
                    update("OpcaoInexistenteCriarKanbanVazio");
                    break;
            }
        }else{
            update("NaoNumerocriarKanbanVazio");
        }
    }
    }

    public void alterarNome(){
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
        if(nome != null){
            model.alterarNomeKanban(this.kanbanAtualIndex, nome);
            kanbansView.criarKanbanVazio(this.kanbanAtualIndex);
        }
    }
    }

    public String getNomeKanban(){
         return (model.getNomeKanban(this.kanbanAtualIndex));
    }

    public int getQuantidadePiscinas(){
        return model.getQuantidadePiscinas(this.kanbanAtualIndex);
    }

    public String getPiscinas(int PiscinaIndex){
        return model.getPiscinas(this.kanbanAtualIndex, PiscinaIndex);
    }

    public int getTamanhoNomeKanBan(){
        return model.getTamanhoNomeKanBan(this.kanbanAtualIndex);
    }

    public int getTamanhoNomePiscina(int PiscinaIndex){
        return model.getTamanhoNomePiscina(this.kanbanAtualIndex, PiscinaIndex);
    }

    public int getQuantidadeAnotacoesPiscinas(int PiscinaIndex){
        return model.getQuantidadeAnotacoesPiscinas(this.kanbanAtualIndex, PiscinaIndex);
    }

    public String getAnotacoes(int PiscinaIndex, int AnotacoesIndex){
        return model.getAnotacoes(this.kanbanAtualIndex, PiscinaIndex, AnotacoesIndex);
    }

    public void update(String update){
        if(update.equals("NaoNumeroCriarKanban")){
            kanbansView.errorNaoNumero();
            criarKanban();
        }
        if(update.equals("OpcaoInexistenteCriarKanban")){
            kanbansView.errorOpcaoInexistente();
            criarKanban();
        }
        if(update.equals("NaoNumerocriarKanbanVazio")){
            kanbansView.errorNaoNumero();
            criarKanbanVazio();
        }
        if(update.equals("OpcaoInexistenteCriarKanbanVazio")){
            kanbansView.errorOpcaoInexistente();
            criarKanbanVazio();
        }
        if(update.equals("SemPiscinas")){
            kanbansView.errorSemPiscinas();
            criarKanbanVazio();
        }
        if(update.equals("SemAnotacoes")){
            kanbansView.errorSemAnotacoes();
            criarKanbanVazio();
        }
        if(update.equals("NomeGrande")){
            kanbansView.errorNomeGrande();
            alterarNome();
        }
        if(update.equals("NomePequeno")){
            kanbansView.errorNomePequeno();
            alterarNome();
        }
    }
}
