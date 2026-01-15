package ProvaPOO;

import java.util.ArrayList;

public class Domino{
    
    private Pedra pedras[] = new Pedra[28];
    private ArrayList<Pedra> jogo = new ArrayList<>();
    
    Domino(){
        
    }
    
    public void montaDomino(){
        int indice = 0;

        for (int i = 0; i <= 6; i++) { // I Representa sempre a parte de baixo!

            for (int j = 0; j <= i; j++) { // J Representa sempre a parte de cima!
                pedras[indice++] = new Pedra(i, j); 
            }
        }
    }
    
    public void exibeDomino(){
        if (getTotalPedras() == 0) {
            throw new SemPedrasException("Sem pedras no Domino!");
        }
    
        for (int i = 0; i < 28; i++) {
            if (pedras[i] != null) {
                System.out.println(pedras[i]);
            }
        }
    }
    
    public void exibeJogo(){
        if (jogo.isEmpty()) {
            throw new SemPedrasException("Sem pedras no Domino!");
        }
    
        for (int i = 0; i < jogo.size(); i++) {
            if (jogo.get(i) != null) {
                System.out.println(jogo.get(i));
            }
        }
        
    
    }
    
    private void removePedra(Pedra pedra){
        for (int i = 0; i < pedras.length; i++) {
            if (this.pedras[i] == pedra) {
                this.pedras[i] = null;
            }
        }
    }
    
    public Pedra getPedra(int index){
        if (index < 1 || index > 28 || pedras[index - 1] == null) {
            throw new SemPedrasException("Sem pedras no Domino!");
        }
        Pedra aux = pedras[index - 1];
        removePedra(pedras[index - 1]);
        return aux;
        
    }
    
    public int getTotalPedras(){
        int acumulador = 0;
        for (int i = 0; i < 28; i++){
            if (this.pedras[i] != null){
                acumulador++;
            }
        }
        return acumulador;
    }
    
    public void joga(Pedra pedra){

    if (jogo.isEmpty()) {

        if (pedra.getValorParteCima() == 6 && pedra.getValorParteBaixo() == 6) {
            jogo.add(pedra);
            removePedra(pedra);
            return;
        }

        throw new SemEncaixeException(6, 6);
    }

    int pontaA = jogo.get(0).getValorParteCima();
    int pontaB = jogo.get(jogo.size() - 1).getValorParteBaixo();

    if (pedra.getValorParteBaixo() == pontaA) {
        jogo.add(0, pedra);
        removePedra(pedra);
        return;
    }

    if (pedra.getValorParteCima() == pontaB) {
        jogo.add(pedra);
        removePedra(pedra);
        return;
    }

    throw new SemEncaixeException(pontaA, pontaB);
}


    
    
}
