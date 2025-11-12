class Pessoa{
    String nome;
    int idade;
    Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Endereço: " + endereco.exibirEndereco());
    }

}

class Endereco{
     String rua;
     String cidade;
     int cep;

    public Endereco(String rua, String cidade, int cep){

        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }


    String exibirEndereco() {
        return rua + ", " + cidade + " - CEP: " + cep;
    }


}

public class Exercicio04 {
    public static void main(String[] args){

    Endereco x= new Endereco("RiodeJaneiro", "BeloHorizonte", 20345);
    Pessoa leo = new Pessoa("Leonardo", 23, x);
    leo.exibirDados();

    }

}
