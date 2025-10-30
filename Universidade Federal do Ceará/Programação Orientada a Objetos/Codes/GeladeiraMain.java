public class GeladeiraMain {
    public static void main(String[] args) {
        Geladeira g = new Geladeira("Inox", "Brastemp", 220, 7.4, true);
        System.out.println(g.getMarca() + ", " + g.getCor() + ", " + g.getVoltagem() + ", " + g.getTemperaturaAtual() + ", " + g.isPortaAberta());
    }
}


class Geladeira {
    public String cor;
    public String marca;
    public int voltagem;
    public double temperaturaAtual;
    public boolean portaAberta;

public Geladeira() {
    this.cor = "Desconhecida";
    this.marca = "Desconhecida";
    this.voltagem = 0;
    this.temperaturaAtual = 0.0;
    this.portaAberta = false;
}

public Geladeira(String cor, String marca, int voltagem, double temperaturaAtual, boolean portaAberta) {
        this.cor = cor;
        this.marca = marca;
        this.voltagem = voltagem;
        this.temperaturaAtual = temperaturaAtual;
        this.portaAberta = portaAberta;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public double getTemperaturaAtual() {
        return temperaturaAtual;
    }

    public boolean isPortaAberta() {
        return portaAberta;
    }
}
