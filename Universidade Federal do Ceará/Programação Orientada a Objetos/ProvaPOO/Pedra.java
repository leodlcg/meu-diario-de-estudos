package ProvaPOO;

public class Pedra {

    public boolean parteCima[][] = new boolean[3][3];
    public boolean parteBaixo[][] = new boolean[3][3];


    Pedra(int ParteBaixo, int ParteCima){
        
        if(ParteBaixo > 6 ||  ParteCima > 6){
            ParteBaixo = 0;
            ParteCima = 0;
        }

        switch (ParteBaixo) {
            case 1:
                this.parteBaixo = setUm();
                break;
            case 2:
                this.parteBaixo = setDois();
                break;
            case 3:
                this.parteBaixo = setTres();
                break;
            case 4:
                this.parteBaixo = setQuatro();
                break;
            case 5:
                this.parteBaixo = setCinco();
                break;
            case 6:
                this.parteBaixo = setSeis();
                break;
            default:
                this.parteCima = setZero();
                break;
        }

        switch (ParteCima) {
            case 1:
                this.parteCima = setUm();
                break;
            case 2:
                this.parteCima = setDois();
                break;
            case 3:
                this.parteCima = setTres();
                break;
            case 4:
                this.parteCima = setQuatro();
                break;
            case 5:
                this.parteCima = setCinco();
                break;
            case 6:
                this.parteCima = setSeis();
                break;
            default:
                this.parteCima = setZero();
                break;
        }

    }
    
    public boolean[][] setZero(){

        boolean zero[][] = new boolean[3][3];
        return zero;

    }


    public boolean[][] setUm(){

        boolean um[][] = new boolean[3][3];
        um[1][1] = true;
        return um;

    }

    public boolean[][] setDois(){

        boolean dois[][] = new boolean[3][3];
        dois[0][2] = true;
        dois[2][0] = true;
        return dois;

    }

    public boolean[][]  setTres(){

        boolean tres[][] = new boolean[3][3];
        tres[0][2] = true;
        tres[1][1] = true;
        tres[2][0] = true;
        return tres;
    }

    public boolean[][] setQuatro(){

        boolean quatro[][] = new boolean[3][3];
        quatro[0][0] = true;
        quatro[0][2] = true;
        quatro[2][0] = true;
        quatro[2][2] = true;
        return quatro;

    }

    public boolean[][] setCinco(){

        boolean cinco[][] = new boolean[3][3];
        cinco[0][0] = true;
        cinco[0][2] = true;
        cinco[1][1] = true;
        cinco[2][0] = true;
        cinco[2][2] = true;
        return cinco;

    }

    public boolean[][] setSeis(){

        boolean seis[][] = new boolean[3][3];
        seis[0][0] = true;
        seis[0][2] = true;
        seis[1][0] = true;
        seis[1][2] = true;
        seis[2][0] = true;
        seis[2][2] = true;
        return seis;

    }

    public int getValorParteCima(){

        int valor = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.parteCima[i][j] == true){
                    valor++;
                }
            }
        }

        return valor;

    }

    public int getValorParteBaixo(){

        int valor = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.parteBaixo[i][j] == true){
                    valor++;
                }
            }
        }

        return valor;

    }


    public String toString() {
        String pedra = "";

        pedra += "|---|\n";

        for (int i = 0; i < 3; i++) {
            pedra += "|";
            for (int j = 0; j < 3; j++) {
                pedra += parteCima[i][j] ? "o" : " ";
            }
            pedra += "|\n";
        }

        pedra += "|---|\n";

        for (int i = 0; i < 3; i++) {
            pedra += "|";
            for (int j = 0; j < 3; j++) {
                pedra += parteBaixo[i][j] ? "o" : " ";
            }
            pedra += "|\n";
        }

        pedra += "|---|\n";

        return pedra;
    }


}
