package controllers;

public class NavigationController {
    private AnotacoesController anotacoesController;
    private PiscinaController piscinaController;
    private KanbansController kanbansController;
    private PaginaInicialController paginaInicialController;
    private int kanbanAtualIndex;

    public NavigationController(PaginaInicialController PaginaInicialController){
        this.paginaInicialController = PaginaInicialController;
    }

    public void setPaginaInicialController(PaginaInicialController PaginaInicialController) {
        this.paginaInicialController = PaginaInicialController;
    }

    public void setKanbansController(KanbansController KanbansController) {
        this.kanbansController = KanbansController;
    }

    public void setAnotacoesController(AnotacoesController AnotacoesController) {
        this.anotacoesController = AnotacoesController;
    }

    public void setPiscinaController(PiscinaController PiscinaController) {
        this.piscinaController = PiscinaController;
    }

    public AnotacoesController getAnotacoesController() {
        return this.anotacoesController;
    }
    
    public void setKanbanAtualIndex(int KanbanAtualIndex) {
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void navegarEscolherPiscinaAlterar(){
        this.anotacoesController.getAnotacoesView().escolherPiscinaAlterar(this.kanbanAtualIndex);
    }

    public void navegarEscolherPiscinaEditar(int KanbanAtualIndex){
        piscinaController.setKanbanAtualIndex(KanbanAtualIndex);
        this.piscinaController.getPiscinasView().escolherAlterarPiscina();
    }

    public void voltarPaginaInicial(){
        this.paginaInicialController.getPaginaInicialView().priorityKanban();
    }

    public void voltarCriarKanban(){
        this.kanbansController.getKanbansView().criarKanbanVazio(this.kanbanAtualIndex);
    }

    public void voltarEscolherAnotacoes(String PiscinaAtualIndex){
        this.anotacoesController.getAnotacoesView().escolherAnotacao(PiscinaAtualIndex);
    }

}
