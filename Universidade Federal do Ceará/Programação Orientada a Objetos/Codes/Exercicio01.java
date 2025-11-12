class Pessoa{

    String nome;
    int idade;


 public Pessoa(String nome, int idade){
    this.nome = nome;
    this.idade = idade;
 }


public void setNome(String nome){
    this.nome = nome;
}

public void setIdade(int idade){
    this.idade = idade;
}

public String getNome(){
    return this.nome;
}

public int getIdade(){
    return this.idade;
}

public String exibirDados(){
    return "O nome e: " + getNome() + " A idade e: " + getIdade();
}
}


public class Exercicio01 {
     public static void main(String[] args){ //Metodo main para iniciar o codigo com a classe tendo o mesmo nome do arquivo

        Pessoa p = new Pessoa("Maria", 20);
        p.idade = -10;
        System.out.println(p.exibirDados()); 

    }
}


