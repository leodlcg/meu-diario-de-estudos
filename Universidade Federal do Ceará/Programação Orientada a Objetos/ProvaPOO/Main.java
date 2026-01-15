package ProvaPOO;

public class Main{


    public static void main(String args[]){

        Domino domino = new Domino();
        domino.montaDomino();
        domino.exibeDomino();
        System.out.println("Total de pedras: " + domino.getTotalPedras());

        try {
            domino.joga(domino.getPedra(28)); // A Pedra 6/6 deve ser a primeira a ser jogada!
            System.out.println("Jogada realizada com sucesso");
        } catch (SemEncaixeException Exception) {
            System.out.println("Jogada inválida");
        }

        System.out.println("Total de pedras: " + domino.getTotalPedras());

        domino.exibeJogo();

        try {
            domino.joga(domino.getPedra(22)); //Teste de uma jogada valida
            System.out.println("Jogada realizada com sucesso");
        } catch (SemEncaixeException Exception) {
            System.out.println("Jogada inválida");
        }

        System.out.println("Total de pedras: " + domino.getTotalPedras());

        try {
            domino.joga(domino.getPedra(16)); //Teste de uma jogada invalida
            System.out.println("Jogada realizada com sucesso");
        } catch (SemEncaixeException Exception) {
            System.out.println("Jogada inválida");
        }

        try {
            domino.joga(domino.getPedra(20)); //Teste de uma jogada invalida
            System.out.println("Jogada realizada com sucesso");
        } catch (SemEncaixeException Exception) {
            System.out.println("Jogada inválida");
        }

        System.out.println("Total de pedras: " + domino.getTotalPedras());

        domino.exibeJogo();

        try {
            domino.joga(domino.getPedra(1)); //Teste de uma jogada invalida
            System.out.println("Jogada realizada com sucesso");
        } catch (SemEncaixeException Exception) {
            System.out.println("Jogada inválida");
        }

        domino.exibeJogo();

    }

}