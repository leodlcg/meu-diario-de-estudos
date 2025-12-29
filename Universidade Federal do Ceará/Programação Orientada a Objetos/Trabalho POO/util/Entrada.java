package util;
import java.util.Scanner;

public class Entrada {
    private static final Scanner escolha = new Scanner(System.in);

    public static String Escolha() {
        return escolha.nextLine();
    }

    public static void fechar() {
        escolha.close(); //Fecha todos os Scanners!
        System.exit(0); //Fecha de vez!
    }
}

