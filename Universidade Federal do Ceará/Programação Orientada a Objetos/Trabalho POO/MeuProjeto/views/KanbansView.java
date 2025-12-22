package views;

import model.Model;
import model.Observer;
import controllers.KanbansController;

public class KanbansView 
    extends LayoutView 
    implements Observer{

    private Model model;
    private KanbansController kanbansController;
    private int kanbanAtualIndex;

    public KanbansView(int KanbanAtualIndex, Model Model){
        this.kanbanAtualIndex = KanbanAtualIndex;
        this.model = Model;
    }

    public int getIndexAtual(){
        return this.kanbanAtualIndex;
    }

    public void setIndexAtual(int KanbanAtualIndex){
        this.kanbanAtualIndex = KanbanAtualIndex;
    }

    public void CriarController(){
        KanbansController KanbansController = new KanbansController(this.kanbanAtualIndex); //Criando o controlador;
        this.kanbansController = KanbansController;
        kanbansController.Iniciar(this, model); //Iniciando o controlador
    }


    public void CriarKanban(){
        limparConsole();
        System.out.println("==============Criar Kanban==============");
        System.out.println("[1] Criar Kanban Vazio"); //Kanban completamente moldável de acordo com o que o usuarui quer!
        System.out.println("[2] Criar Kanban Clássico"); //Tres modelos padroes para facilitar para um usuario leigo!
        System.out.println("[3] Criar Kanban Pessoal");
        System.out.println("[4] Criar Kanban Estudos");
        System.out.println("========================================");
        System.out.println("O que deseja fazer:");
        kanbansController.CriarKanban();
    }
    
    public void CriarKanbanVazio(int indexAtual){
        kanbansController.setIndexAtual(indexAtual);
        limparConsole();
        System.out.println("=========================" + kanbansController.ObterNome() + "========================="); //Ao mexer no menu este kanban que esta sendo criado deve se atualizar automaticamente!
        ExibirPiscinas();
        ExibirAnotacoes();
        System.out.println("\n==============================================================");
        System.out.println("=============================MENU=============================");
        System.out.println("[1] Alterar Nome");
        System.out.println("[2] Criar Piscina");
        System.out.println("[3] Editar Piscina");
        System.out.println("[4] Criar Anotação");
        System.out.println("[5] Editar Anotação");
        System.out.println("[6] Voltar");
        System.out.println("==============================================================");
        System.out.println("O que deseja fazer:");
        kanbansController.CriarKanbanVazio();
    }

    public void AlterarNome() {
        limparConsole();
        System.out.println("=========================Alterar Nome=========================");
        System.out.println("Alterando o nome de: " + kanbansController.ObterNome());
        System.out.println("==============================================================");
        System.out.println("Escreva o novo nome:");
        kanbansController.AlterarNome();
    }

    public void ExibirPiscinas(){
        int quantidadePiscinas = kanbansController.getQuantidadePiscinas();
        if(quantidadePiscinas > 0){
            for(int i = 0; i < quantidadePiscinas;i++){
                System.out.print(kanbansController.getPiscinas(i));
            }
        }else{
            System.out.print("Nenhuma Piscina foi criada neste Kanban"); //Tratar este erro depois!
        }
    }

    public void ExibirAnotacoes(){
        int quantidadePiscinas = kanbansController.getQuantidadePiscinas();
        if(quantidadePiscinas > 0){
            for(int i = 0; i < quantidadePiscinas;i++){
                int quantidadeAnotacoes = kanbansController.getAnotacoesPiscinas(i);
                for(int j = 0; j < quantidadeAnotacoes; j++){
                    System.out.print(kanbansController.getAnotacoes(i, j));
                }
            }
        }else{
            System.out.print("Nenhuma Anotacao foi criada neste Kanban"); //Tratar este erro depois!
        }
    }


    public void update(){};

}
