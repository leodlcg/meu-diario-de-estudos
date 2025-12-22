package model;
import java.util.*;

public class Model {

private ArrayList<Kanban> kanbans = new ArrayList<>();

public ArrayList<Kanban> getKanbans(){
    return kanbans;
}

public void CriarKanbanVazio(){
    kanbans.add(new Kanban(getKanbans().size(), "KANBAN VAZIO")); //getKanbans().size() para criar no ultimo index
}

public void AlterarNomeKanban(int id, String nome){
    kanbans.get((id)).setNome(nome);
}

public void CriarPiscinaVazia(int IndexAtual, String nome){
    kanbans.get(IndexAtual).piscinas.add(new Piscina(nome));
}

public void VerificarCriacaoKanbans(){ //Metodo apenas para test
    System.err.println(kanbans.get(0)); //Escolher o index para test
}

public String VerificarCriacaoPiscinas(){ //Metodo apenas para test
    return kanbans.get(0).piscinas.get(0).getNome(); //Escolher o index para test
}


public void CriarAnotacao(int KanbanAtualIndex, int PiscinaAtualIndex, String Texto) {
    //PARTE PARA ARMAZENAR OS PostIts
    //FALTA TERMINAR AJUSTAS!

    // String texto = "O usuario escreve um texto bem grande e quando passar do limite ele quebra automaticamente a linha";
    // String texto2 = "ahhhhhhhhhhhhhhhhh hhhhhhhhhhhhhhhhhhhhhhhhh hhhhhhhhhhhhhhhhhhhhhhhhhhh hhhhhhhhhhhhhhhhhhhhh hhhhhhhhhhhhhhhhhhhhhhhhhhhh";
    // String texto3 = "OHHHHHHHHHHHHHHHHHH OHHHHHHHHHHHHHHHHHH OHHHHHHHHHHHHHHHHH";
    // String texto4 = "OHHHHHHHHHHHHHHHHHH OHHHHHHHHHHHHHHHHH testestestesteste";
    // String texto5 = "sdwadawdwa dwadwadawd dwadwadwadwa";

    kanbans.get(KanbanAtualIndex).piscinas.get(PiscinaAtualIndex).getAnotacoes().addAll(AlinharTexto(Texto));

    // List<String> pagina01 = new ArrayList<>();
    // pagina01.addAll(AlinharTexto(texto2));
    // pagina01.addAll(AlinharTexto(texto3));
    // pagina01.addAll(AlinharTexto(texto4));
    // pagina01.addAll(AlinharTexto(texto5));
    // List<String> pagina02 = AlinharTexto(texto);

    //======================================================
    //PARTE PARA IMPRIMIR AS PICISNAS LADO A LADO:
    //FALTA TERMINAR AJUSTAS!
    // int linhas = Math.max(pagina01.size(), pagina02.size());

    // for (int i = 0; i < linhas; i++) {
    //     String l1 = i < pagina01.size() ? pagina01.get(i) : " ".repeat(pagina01.get(0).length());
    //     String l2 = i < pagina02.size() ? pagina02.get(i) : " ".repeat(pagina02.get(0).length());

    //     System.out.println(l1 + " " + l2);
    // }
    //======================================================
}

static List<String> AlinharTexto(String texto) {
    //FALTA TERMINAR AJUSTAS!
    int limite = 20;
    List<String> linhas = new ArrayList<>();

    String topoBase = "=".repeat(limite + 6);
    linhas.add(topoBase);

    for (int i = 0; i < texto.length(); i += limite) {
        int fim = Math.min(i + limite, texto.length());
        String linha = texto.substring(i, fim);
        linha = String.format("%-" + limite + "s", linha);

        linhas.add("|| " + linha + " ||");
    }

    linhas.add(topoBase);
    return linhas;
}

}
