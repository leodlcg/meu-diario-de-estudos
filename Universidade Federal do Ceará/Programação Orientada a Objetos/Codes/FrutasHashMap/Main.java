package FrutasHashMap;

public class Main {
    
    public static void main(String[] args){


        Frutas frutas = new Frutas();

        frutas.adicionarFrutas("Pera", 20);

        frutas.adicionarFrutas("Uva", 15);

        frutas.adicionarFrutas("Maca", 40);

        frutas.adicionarFrutas("Melao", 2);

        frutas.adicionarFrutas("Abacate", 18);



        System.out.println("Quantidade da fruta: " +  frutas.frutas.get("Melao"));

        System.out.println("Quantidade da fruta: " +  frutas.frutas.get("Maca"));


    }

}
