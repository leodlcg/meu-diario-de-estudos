class CNPJ{
    
    String numero;
    String nomeFantasia;
    int diaEmissao;
    int mesEmissao;
    int anoEmissao;

    
    public boolean validarNumero(String numero){
        
        if (numero.length() != 14) return false;
        int[] numeros = new int[14];
        for(int i = 0; i < numero.length(); i++){
            numeros[i] = Character.getNumericValue(numero.charAt(i));
        }
        int somaA1 = numeros[0] * 5 + numeros[1] * 4 + numeros[2] * 3 + numeros[3] * 2 + numeros[4] * 9 + numeros[5] * 8 + numeros[6] * 7 + numeros[7] * 6 + numeros[8] * 5 + numeros[9] * 4 + numeros[10] * 3 + numeros[11] * 2;

        int somaA2 = numeros[0] * 6 + numeros[1] * 5 + numeros[2] * 4 + numeros[3] * 3 + numeros[4] * 2 + numeros[5] * 9 + numeros[6] * 8 + numeros[7] * 7 + numeros[8] * 6 + numeros[9] * 5 + numeros[10] * 4 + numeros[11] * 3 + numeros[12] * 2;
        
        if(somaA1 % 11 == 0 || somaA1 % 11 == 1){
            somaA1 = 0;
        }else{
            somaA1 = 11 - (somaA1 % 11);
        }
        
        if(somaA2 % 11 == 0 || somaA2 % 11 == 1){
            somaA2 = 0;
        }else{
            somaA2 = 11 - (somaA2 % 11);
        }
        
        if(numeros[13] == somaA2 && numeros[12] == somaA1){
            return true; 
        }else{
            return false;
        }
    
    }
    
    public void setNumero(String numero){
            if(validarNumero(numero) == true && numero.length() == 14){
                this.numero = numero;
            }else{
                this.numero = null;
            }
    }
    
    public String getNumero(){
            return this.numero;        

    }
    
    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia.toUpperCase();
    }
    
    public String getNomeFantasia(){
        return this.nomeFantasia;
    }
    
    public void setEmissao(int diaEmissao, int mesEmissao, int anoEmissao){
    
        if(diaEmissao <= 0 || mesEmissao <= 0 || anoEmissao <= 0){
            this.diaEmissao = 0;
            this.mesEmissao = 0;
            this.anoEmissao = 0;
            this.numero = null;
        }else{
            this.diaEmissao = diaEmissao;
            this.mesEmissao = mesEmissao;
            this.anoEmissao = anoEmissao;
        }
    }
    
    
    
   public String getEmissao(){
       if(diaEmissao <= 0 || mesEmissao <= 0 || anoEmissao <= 0){
           return "Para exibir a data de emissao, entre com data e numeracao validas!";
       }else{
       String data = this.diaEmissao + "/" + this.mesEmissao + "/" + this.anoEmissao;
       return data;
       }
   }
    
    
public CNPJ(){
    this.numero = "";
}

public CNPJ(String numero){
    
    this.numero = numero;
    
    
}

}