package model;
import java.util.*;

public class Piscina { //As piscinas sao "Topicos" o usuario para inserir uma ou mais piscinas;
    private String nome;
    private List<String> anotacoes = new ArrayList<>(); //Lista para as anotações!

    public Piscina(String Nome){
        this.nome = Nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String Nome){
        this.nome = Nome;
    }

    public List<String> getAnotacoes(){
        return this.anotacoes;
    }
}
