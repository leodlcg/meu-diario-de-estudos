package model;
import java.util.*;

public class Kanban { //Os kanbans iram armazenar as colunos de acordo com o que o usuario quiser

    private int id;
    private String nome;
    List<Piscina> piscinas = new ArrayList<>();

    public Kanban(int Id, String Nome){
        this.id = Id;
        this.nome = Nome;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public List<Piscina> getPiscinas(){
        return this.piscinas;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}
