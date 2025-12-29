package model;
import java.util.*;

public class Model implements Observer{

    private boolean priorityKanBanIniciado  = false;
    private ArrayList<Kanban> kanbans = new ArrayList<>();
    private int quantidadeErrosValidacao = 0;

    public void setPriorityKanBanIniciado(boolean PriorityKanBanIniciado){
        this.priorityKanBanIniciado = PriorityKanBanIniciado;
    }

    public boolean getPriorityKanBanIniciado(){
        return this.priorityKanBanIniciado;
    }

    public ArrayList<Kanban> getKanbans(){
        return kanbans;
    }

    public boolean validarEntrada(String numString){
        try{
            Integer.parseInt(numString);
            return true; //Validado;
        }catch(NumberFormatException exception){ // NumberFormatException ja vem na classe Exception padrao do Java.
            update("EscolhaInvalida");
            return false; //Error;
        }
    }

    public void criarKanbanVazio(){
        if(this.priorityKanBanIniciado == true){
            kanbans.add(new Kanban(getKanbans().size(), "KANBAN VAZIO")); //getKanbans().size() para criar no ultimo index
        }
    }

    public void alterarNomeKanban(int KanbanAtualIndex, String Nome){
        if(this.priorityKanBanIniciado == true){
            kanbans.get(KanbanAtualIndex).setNome(Nome);
        }
    }

    public void alterarNomePiscina(int KanbanAtualIndex, int PiscinaAtualIndex,  String Nome){
        if(this.priorityKanBanIniciado == true){
            kanbans.get(KanbanAtualIndex).getPiscinas().get(PiscinaAtualIndex).setNome(Nome);
        }
    }

    public void criarPiscinaVazia(int IndexAtual, String nome){
        if(this.priorityKanBanIniciado == true){
            kanbans.get(IndexAtual).piscinas.add(new Piscina(nome));
        }
    }

    public void criarAnotacao(int KanbanAtualIndex, String PiscinaAtualIndex, String Texto) {

        if(this.priorityKanBanIniciado == true){
        int limite = 20;
        StringBuilder resultado = new StringBuilder();

        String topoBase = "=".repeat(limite + 6);
        resultado.append(topoBase).append("\n");

        for (int i = 0; i < Texto.length(); i += limite) {
            int fim = Math.min(i + limite, Texto.length());
            String linha = Texto.substring(i, fim);
            linha = String.format("%-" + limite + "s", linha);
            resultado.append("|| ").append(linha).append(" ||\n");
        }
        resultado.append(topoBase);
        String TextoAlinhado = resultado.toString();

        kanbans.get(KanbanAtualIndex).piscinas.get(Integer.parseInt(PiscinaAtualIndex) - 1).getAnotacoes().add(TextoAlinhado);
        }
    }

    public String getNomeKanban(int KanbanAtualIndex){
        if(this.priorityKanBanIniciado == true){
            return (kanbans.get(KanbanAtualIndex).getNome());
        }else{
            return "";
        }
    }

    public int getTamanhoNomeKanBan(int KanbanAtualIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getNome().length();
        }else{
            return 0;
        }
    }

    public int getTamanhoNomePiscina(int KanbanAtualIndex, int PiscinaIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getPiscinas().get(PiscinaIndex).getNome().length();
        }else{
            return 0;
        }
    }

    public int getTamanhoNomeKanban(int KanbanAtualIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getNome().length();
        }else{
            return 0;
        }
    }

    public int getAnotacoesPiscinas(int KanbanAtualIndex, int PiscinaIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getPiscinas().get(PiscinaIndex).getAnotacoes().size();
        }else{
            return 0;
        }
    }

    public int getQuantidadePiscinas(int KanbanAtualIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getPiscinas().size();
        }else{
            return 0;
        }
    }

    public String getPiscinas(int KanbanAtualIndex, int PiscinaIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getPiscinas().get(PiscinaIndex).getNome();
        }else{
            return "";
        }
    }

    public int getQuantidadeAnotacoesPiscinas(int KanbanAtualIndex, int PiscinaIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getPiscinas().get(PiscinaIndex).getAnotacoes().size();
        }else{
            return 0;
        }
    }

    public String getAnotacoes(int KanbanAtualIndex, int PiscinaIndex, int AnotacoesIndex){
        if(this.priorityKanBanIniciado == true){
            return kanbans.get(KanbanAtualIndex).getPiscinas().get(PiscinaIndex).getAnotacoes().get(AnotacoesIndex);
        }else{
            return "";
        }
    }

    public void apagarAnotacao(int KanbanAtualIndex, int PiscinaIndex, int AnotacoesIndex){
        if(this.priorityKanBanIniciado == true){
            kanbans.get(KanbanAtualIndex).getPiscinas().get(PiscinaIndex).getAnotacoes().remove(AnotacoesIndex);
        }
    }

    public void apagarPiscina(int KanbanAtualIndex, int PiscinaIndex){
        if(this.priorityKanBanIniciado == true){
            kanbans.get(KanbanAtualIndex).getPiscinas().remove(PiscinaIndex);
        }
    }

    public void editarAnotacao(int KanbanAtualIndex, int PiscinaAtualIndex, int AnotacoesIndex, String Texto) {

        if(this.priorityKanBanIniciado == true){
        int limite = 20;
        StringBuilder resultado = new StringBuilder();

        String topoBase = "=".repeat(limite + 6);
        resultado.append(topoBase).append("\n");

        for (int i = 0; i < Texto.length(); i += limite) {
            int fim = Math.min(i + limite, Texto.length());
            String linha = Texto.substring(i, fim);
            linha = String.format("%-" + limite + "s", linha);
            resultado.append("|| ").append(linha).append(" ||\n");
        }
        resultado.append(topoBase);
        String TextoAlinhado = resultado.toString();

        kanbans.get(KanbanAtualIndex).piscinas.get(PiscinaAtualIndex).getAnotacoes().set(AnotacoesIndex, TextoAlinhado);
        }
    }

    public void update(String update){
        if(update.equals("EscolhaInvalida")){
            if (this.quantidadeErrosValidacao > 10) {
                //Travar o app para proteger os dados!
                this.quantidadeErrosValidacao = 0;
            }
            quantidadeErrosValidacao++;
        }
    }
}
