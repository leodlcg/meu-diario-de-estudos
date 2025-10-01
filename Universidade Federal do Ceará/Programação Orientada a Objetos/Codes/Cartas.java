public class Carta {
    private String naipe;
    private String valor;

    public Carta() {
        this.naipe = null;
        this.valor = null;
    }

    public Carta(String naipe, String valor) {
        setNaipe(naipe);
        setValor(valor);
    }

    public void setNaipe(String naipe) {
        if (this.naipe == null && naipe != null) {
            String teste = naipe.toUpperCase();
            if (teste.equals("OUROS") || 
                teste.equals("ESPADAS") || 
                teste.equals("COPAS") || 
                teste.equals("PAUS")) {
                this.naipe = teste;
            }
        }
    }

    public String getNaipe() {
        return this.naipe;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        if (this.valor == null && valor != null) {
            String teste = valor.toUpperCase();
            if (teste.equals("1") || 
                teste.equals("2") || 
                teste.equals("3") || 
                teste.equals("4") ||
                teste.equals("5") ||
                teste.equals("6") || 
                teste.equals("7") || 
                teste.equals("8") || 
                teste.equals("9") ||
                teste.equals("A") ||
                teste.equals("J") ||
                teste.equals("Q") ||
                teste.equals("K")) {
                this.valor = teste;
            }
        }
    }
    
            public String toString() {
                if (naipe == null && valor == null) {
                    System.out.println("Dados Nao Informados!");
                } else if (naipe == null) {
                    System.out.println("Naipe Nao Informado [" + valor + "]");
                } else if (valor == null) {
                    System.out.println(naipe + " - Valor Nao Informado!");
                } else {
                    System.out.println(naipe + " [" + valor + "]");
                }
                return ""; 
            }

}
