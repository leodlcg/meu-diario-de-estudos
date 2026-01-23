package equailsTeste;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Ana", 20, 1500.0);
        Pessoa p2 = new Pessoa("Ana", 20, 1500.0);
        Pessoa p3 = new Pessoa("João", 25, 2000.0);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.equals(p3)); // false
    }
}