class Retangulo{

    int largura;
    int altura;


    public Retangulo(int largura, int altura){
        this.largura = largura;
        this.altura = altura;
    }


    public Retangulo(int x){
        this.largura = x;
        this.altura = x;
    }


    public int calcularArea(){
        return this.largura * this.altura;
    }

}

public class Exercicio03{

public static void main(String[] args){
Retangulo r = new Retangulo(10);
System.out.println(r.calcularArea());
Retangulo h = new Retangulo(5,10);
System.out.println(h.calcularArea());
}
}