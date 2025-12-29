package controllers;
import views.AnotacoesView;
import model.Model;
import model.Observer;
import util.Entrada;

public class AnotacoesController 
    implements Observer{
    
    private AnotacoesView anotacoesView;
    private Model model;
    private NavigationController navigationController;
    private int kanbanAtualIndex;
    private String piscinaAtualIndex;
    private String anotacaoAtualIndex;

    public void iniciar(AnotacoesView AnotacoesView, Model Model, int KanbanAtualIndex, NavigationController NavigationController){
        this.anotacoesView = AnotacoesView;
        this.model = Model;
        this.navigationController = NavigationController;
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public AnotacoesView getAnotacoesView(){
            return this.anotacoesView;
    }

    public void setAnotacaoAtualIndex(String AnotacaoAtualIndex){
        this.anotacaoAtualIndex = AnotacaoAtualIndex;
    }

    public void setKanbanAtualIndex(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
        anotacoesView.setKanbanAtualIndex(KanbanAtualIndex);
    }

    public void setPiscinaAtualIndex(String PiscinaAtualIndex){
        this.piscinaAtualIndex = PiscinaAtualIndex;
    }

    public void escolherPiscinaCriar(){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringPiscinaCriar = Entrada.Escolha();
        if(model.validarEntrada(numeroStringPiscinaCriar)){

            if("0".equals(numeroStringPiscinaCriar)){
                navigationController.voltarCriarKanban();
            }

            if(model.getQuantidadePiscinas(this.kanbanAtualIndex) >= (Integer.parseInt(numeroStringPiscinaCriar))){
                this.piscinaAtualIndex = numeroStringPiscinaCriar; //PODE DAR PROBLEMA AQUI
                anotacoesView.criarAnotacao(numeroStringPiscinaCriar);
            }else{
                update("OpcaoInexistenteEscolherPiscinaCriar");
            }
        }else{
            update("NaoNumeroEscolherPiscinaCriar");
        }
    }
    }

    public void criarAnotacao(String PiscinaAtualIndex){
    if(model.getPriorityKanBanIniciado()){
        String texto = Entrada.Escolha();
        if("0".equals(texto)){
            navigationController.voltarEscolherAnotacoes(PiscinaAtualIndex);
        }else{
            model.criarAnotacao(this.kanbanAtualIndex, this.piscinaAtualIndex, texto);
        }
    }
    }

    public void escolherPiscinaAlterar(){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringPiscinaAlterar = Entrada.Escolha();
        if(model.validarEntrada(numeroStringPiscinaAlterar)){

            if("0".equals(numeroStringPiscinaAlterar)){
                navigationController.voltarCriarKanban();
            }

            if(model.getQuantidadePiscinas(this.kanbanAtualIndex) > ((Integer.parseInt(numeroStringPiscinaAlterar) - 1))){

                if(model.getQuantidadeAnotacoesPiscinas(this.kanbanAtualIndex, (Integer.parseInt(numeroStringPiscinaAlterar)) - 1) > 0){
                    setPiscinaAtualIndex(numeroStringPiscinaAlterar);
                    anotacoesView.escolherAnotacao(numeroStringPiscinaAlterar);
                }else{
                    update("NaoHaAnotacoesEscolherPiscinaAlterar");
                }

            }else{
                update("OpcaoInexistenteEscolherPiscinaAlterar");
            }
        }else{
            update("NaoNumeroEscolherPiscinaAlterar");
        }
    }
    }

    public void escolherAnotacao(String PiscinaAtualIndex){
    if(model.getPriorityKanBanIniciado()){
        String numeroStringEscolherAnotacao = Entrada.Escolha();
        if(model.validarEntrada(numeroStringEscolherAnotacao)){
            if("0".equals(numeroStringEscolherAnotacao)){
                navigationController.voltarCriarKanban();
            }
            if(getQuantidadeAnotacoes(Integer.parseInt(PiscinaAtualIndex) - 1) >= (Integer.parseInt(numeroStringEscolherAnotacao) - 1)){
                anotacoesView.alterarAnotacao(PiscinaAtualIndex, numeroStringEscolherAnotacao);
            }else{
             update("OpcaoInexistenteEscolherAnotacao");
            }
        }else{
            update("NaoNumeroEscolherAnotacao");
        }
    }
    }

    public void alterarAnotacao(String PiscinaAtualIndex, String AnotacaoAtualIndex) {
    if(model.getPriorityKanBanIniciado()){
        String numeroStringAlterarAnotacao = Entrada.Escolha();
            if(model.validarEntrada(numeroStringAlterarAnotacao)){
                setAnotacaoAtualIndex(AnotacaoAtualIndex);
                switch (numeroStringAlterarAnotacao) {
                    case "1": //Alterar texto
                        update("AlterarAnotacao");
                        editarAnotacao(PiscinaAtualIndex, AnotacaoAtualIndex);
                        navigationController.voltarCriarKanban();
                        break;
                    case "2": //Apagar anotacao
                        model.apagarAnotacao(this.kanbanAtualIndex,(Integer.parseInt(PiscinaAtualIndex) - 1),(Integer.parseInt(AnotacaoAtualIndex) - 1));
                        navigationController.voltarCriarKanban();
                        break;
                    case "0": //Voltar
                        navigationController.voltarEscolherAnotacoes(PiscinaAtualIndex);
                        break;
                    default:
                        update("OpcaoInexistenteAlterarAnotacao");
                        break;
                }
        }else{
            update("NaoNumeroAlterarAnotacao");
        }

        
    }
    }

    public void editarAnotacao(String PiscinaAtualIndex, String AnotacaoAtualIndex){
    if(model.getPriorityKanBanIniciado()){
        String texto = Entrada.Escolha();
        model.editarAnotacao(this.kanbanAtualIndex, (Integer.parseInt(PiscinaAtualIndex) - 1), (Integer.parseInt(AnotacaoAtualIndex) - 1), texto);
    }
    }
    
    public String getPiscinas(int PiscinaIndex){
        return model.getPiscinas(this.kanbanAtualIndex, PiscinaIndex);
    }

    public String getAnotacoes(int PiscinaIndex, int AnotacaoIndex){
        return model.getAnotacoes(this.kanbanAtualIndex, PiscinaIndex, AnotacaoIndex);
    }

    public int getQuantidadePiscinas(){
        return model.getQuantidadePiscinas(this.kanbanAtualIndex);
    }

    public int getTamanhoNomePiscina(int PiscinaIndex){
        return model.getTamanhoNomePiscina(this.kanbanAtualIndex, PiscinaIndex);
    }

    public int getQuantidadeAnotacoes(int PiscinaIndex){
        return model.getQuantidadeAnotacoesPiscinas(this.kanbanAtualIndex, PiscinaIndex);
    }

    public void update(String update){
        switch (update) {
            case "NaoNumeroEscolherPiscinaCriar":
                anotacoesView.errorNaoNumero();
                escolherPiscinaCriar();
                break;
            case "OpcaoInexistenteEscolherPiscinaCriar":
                anotacoesView.errorOpcaoInexistente();
                escolherPiscinaCriar();
                break;
            case "NaoNumeroEscolherPiscinaAlterar":
                anotacoesView.errorNaoNumero();
                escolherPiscinaAlterar();
                break;
            case "OpcaoInexistenteEscolherPiscinaAlterar":
                anotacoesView.errorOpcaoInexistente();
                escolherPiscinaAlterar();
                break;
            case "NaoHaAnotacoesEscolherPiscinaAlterar":
                anotacoesView.errorSemAnotacoes();
                escolherPiscinaAlterar();
                break;
            case "NaoNumeroEscolherAnotacao":
                anotacoesView.errorNaoNumero();
                escolherAnotacao(this.piscinaAtualIndex);
                break;
            case "OpcaoInexistenteEscolherAnotacao":
                anotacoesView.errorOpcaoInexistente();
                escolherAnotacao(this.piscinaAtualIndex);
                break;
            case "NaoNumeroAlterarAnotacao":
                anotacoesView.errorNaoNumero();
                alterarAnotacao(this.piscinaAtualIndex, this.anotacaoAtualIndex);
                break;
            case "OpcaoInexistenteAlterarAnotacao":
                anotacoesView.errorOpcaoInexistente();
                alterarAnotacao(this.piscinaAtualIndex, this.anotacaoAtualIndex);
                break;
            case "AlterarAnotacao":
                anotacoesView.alterarAnotacaoEscrever();
                break;
            default:
                break;
        }
    }
}