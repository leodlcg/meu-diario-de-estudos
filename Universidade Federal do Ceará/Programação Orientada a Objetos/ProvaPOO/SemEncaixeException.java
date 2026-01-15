package ProvaPOO;

public class SemEncaixeException extends RuntimeException {

    private int pontaA;
    private int pontaB;

    public SemEncaixeException(int pontaA, int pontaB) {
        super("Sem encaixe para a pedra jogada!");
        this.pontaA = pontaA;
        this.pontaB = pontaB;
    }

    public int getPontaA() {
        return pontaA;
    }

    public int getPontaB() {
        return pontaB;
    }

}
