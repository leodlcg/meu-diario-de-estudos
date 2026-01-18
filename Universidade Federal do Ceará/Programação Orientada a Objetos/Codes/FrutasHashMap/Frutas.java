package FrutasHashMap;
import java.util.*;

public class Frutas {

    HashMap<String, Integer> frutas = new HashMap<>();
    
    Frutas(){

    }


    public boolean adicionarFrutas(String nome, int quandidade){

        frutas.put(nome, quandidade);

        return false;
    }




}
