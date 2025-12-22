package views;
import java.util.*;

public abstract class LayoutView {

public void limparConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}

public void TextError(){
    System.out.println("=============================");
    System.out.println("ERROR");
    System.out.println("=============================");
}


static List<String> AlinharTexto(String texto) {
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
