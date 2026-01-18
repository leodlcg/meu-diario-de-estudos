package AlunosHashMap;
public class Main {

    public static void main(String[] args){

        Alunos alunos = new Alunos();

        alunos.adicionarAluno("Joao");
        alunos.adicionarAluno("Vitor");
        alunos.adicionarAluno("Carlos");

        for(int i = 1; i <= alunos.aluno.size(); i++){
            System.out.println(alunos.aluno.get(i));
        }

    }

    
}
