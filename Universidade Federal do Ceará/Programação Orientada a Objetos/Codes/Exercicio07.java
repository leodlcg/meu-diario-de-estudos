class Animal{
    String som;

    public Animal(String som){
        this.som = som;
    }


    public String emitirSom(){
        return som;
    }
}


class Cachorro extends Animal{
    public Cachorro(String som){
        super(som);
    }

}

class Gato extends Animal{
    public Gato(String som){
        super(som);
    }


}


public class Exercicio07{

    public static void main(String[] args){
    Cachorro marley = new Cachorro("AuAuAu");
    Gato mingau = new Gato("Miauuuuuuuuuuu");

     System.out.println(mingau.emitirSom());
     System.out.println(marley.emitirSom());

    }


}