package controllers;
import views.PaginaInicialView;
import views.KanbansView;
import model.Model;
import model.Observer;
import util.Entrada;

public class PaginaInicialController 
    implements Observer {
    
    private PaginaInicialView paginaInicialView;
    private Model model;
    private NavigationController navigationController;
    private int kanbanAtualIndex;

    public PaginaInicialView getPaginaInicialView() {
        return paginaInicialView;
    }

    public int getIndexAtual(){
        return this.kanbanAtualIndex;
    }

    public void setIndexAtual(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public int getQuantidadeKanbans(){
        return model.getKanbans().size();
    }

    public String getKanbans(int index){
        return model.getNomeKanban(index);
    }

    public int getTamanhoNomeKanban(int KanbanIndex){
        return model.getTamanhoNomeKanban(KanbanIndex);
    }

    public void iniciar(PaginaInicialView PaginaInicialView, Model Model, int KanbanAtualIndex, NavigationController NavigationController){
        Model.setPriorityKanBanIniciado(true);
        this.paginaInicialView = PaginaInicialView;
        this.model = Model;
        this.navigationController = NavigationController;
        this.kanbanAtualIndex = KanbanAtualIndex;
        paginaInicialView.priorityKanban(); //Apos ter um controlador se mostra na tela!
    }

    public void usuarioEscolha(){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringEscolha = Entrada.Escolha(); //Pega o Scanner e cria uma variavel local para escolha o Usuario!
        model.validarEntrada(numeroStringEscolha);
        if(model.validarEntrada(numeroStringEscolha)){
            switch (numeroStringEscolha) {
                case "1": //Criar KanBan;
                    KanbansView kanbansView = new KanbansView(this.kanbanAtualIndex, this.model, this.navigationController); //Como e novo sempre sera o ultimo da lista!
                    kanbansView.criarController();            
                    break;
                case "2": //Meus KanBans;
                    if(model.getKanbans().size() == 0){
                        update("SemKanbans");
                    }
                    paginaInicialView.escolherKanbans();
                    break;
                case "3": //Sobre o app!
                    paginaInicialView.sobrePriorityKanBan();
                    break;
                case "4":
                    model.setPriorityKanBanIniciado(false);
                    paginaInicialView.fechando();
                    Entrada.fechar();
                    break;
                default:
                    update("OpcaoInexistente");
                    break;
            }
        }else{
            update("NaoNumero");
        }
    }
    }

    public void escolherKanbans(){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringKanbans = Entrada.Escolha();
        if(model.validarEntrada(numeroStringKanbans)){

            if("0".equals(numeroStringKanbans)){
            navigationController.voltarPaginaInicial();
            }

            if(model.getKanbans().size() >= Integer.parseInt(numeroStringKanbans)){
                this.kanbanAtualIndex = (Integer.parseInt(numeroStringKanbans) - 1); // -1 Para pegar o index correto!
                navigationController.setKanbanAtualIndex(Integer.parseInt(numeroStringKanbans) - 1);
                navigationController.voltarCriarKanban();
            }else{
            update("OpcaoInexistenteEscolherKanbans");
            }
        }else{
            update("NaoNumeroEscolherKanbans");
        }
    }
    }

    public void usuarioEscolhaSobre(){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringEscolhaSobre = Entrada.Escolha(); //Pega o Scanner e cria uma variavel local para escolha o Usuario!
        if(model.validarEntrada(numeroStringEscolhaSobre)){
            if("0".equals(numeroStringEscolhaSobre)){
                paginaInicialView.priorityKanban();   
            }else{
                update("OpcaoInexistenteSobre");
            }
        }else{
            update("NaoNumeroSobre");
        }
    }
    }
    
    public void update(String update){
        if(update.equals("SemKanbans")){
            paginaInicialView.errorSemKanbans();
            usuarioEscolha();
        }
        if(update.equals("NaoNumero")){
            paginaInicialView.errorNaoNumero();
            usuarioEscolha();
        }
        if(update.equals("OpcaoInexistente")){
            paginaInicialView.errorOpcaoInexistente();
            usuarioEscolha();
        }
        if(update.equals("NaoNumeroEscolherKanbans")){
            paginaInicialView.errorNaoNumero();
            escolherKanbans();
        }
        if(update.equals("OpcaoInexistenteEscolherKanbans")){
            paginaInicialView.errorOpcaoInexistente();
            escolherKanbans();
        }
        if(update.equals("OpcaoInexistenteSobre")){
            paginaInicialView.errorOpcaoInexistente();
            usuarioEscolhaSobre();
        }
        if(update.equals("NaoNumeroSobre")){
            paginaInicialView.errorNaoNumero();
            usuarioEscolhaSobre();
        }
    }
}
