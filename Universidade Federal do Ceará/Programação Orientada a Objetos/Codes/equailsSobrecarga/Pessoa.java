package equailsTeste;

import java.util.*;
class Pessoa {

    private String nome;
    private int idade;
    private double salario;


    public boolean equals(Object o) { //Recebe um objeto qualquer!
        if (this == o) return true; //Verifica se e o mesmo objeto que este!
        if (!(o instanceof Pessoa)) return false; //Verifica se e do mesmo tipo!
        Pessoa p = (Pessoa) o; //Fazendo cast porque recebemos em Object!

        //Todos precisam ser iguais para retornar true!
        return Objects.equals(idade, p.idade) &&
               Objects.equals(salario, p.salario) &&
               Objects.equals(nome, p.nome);
    }

    public int hashCode() { //Se sobrecarregamos o equals, precisamos sobrecarregar tambem o hashCode()!
        return Objects.hash(nome, idade, salario); //Passando as variaveis que temos!
    }
}
