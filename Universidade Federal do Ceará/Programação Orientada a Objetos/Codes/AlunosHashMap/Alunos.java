package AlunosHashMap;
import java.util.*;


public class Alunos{

    HashMap<Integer,String> aluno = new HashMap<>();

    Alunos(){}

    public void setAluno(HashMap<Integer, String> aluno) {
        this.aluno = aluno;
    }

    public boolean adicionarAluno(String nome){

        if(aluno.size() == 0){
            aluno.put(1, nome);
            return true;
        }

        if(nome != null){
           aluno.put((aluno.size() + 1), nome);
           return true;
        }

        return false;

    }







}