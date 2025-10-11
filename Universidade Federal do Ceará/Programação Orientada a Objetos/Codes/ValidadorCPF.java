class CPF{
    String nome;
    String numero;
    int diaEmissao;
    int mesEmissao;
    int anoEmissao;
    static int flag;
    
    public void setNome(String nome){
                if(nome.matches(".*\\d.*") == true){
                     this.nome = null;
                }else{
                     this.nome = nome.toUpperCase();
                }
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNumero(String numero){
                if(numero == null){
                   this.numero = null; 
                }else{
                  this.numero = numero;  
                }
    }
    
    public String getNumero(){
        if(this.flag != 1){
            getEmissao();
            return this.numero;
        }else{
            return this.numero;
        }
    }
    
    
    public boolean validarNumero(String numero){
        if(numero.length() < 11){
            return false;
        }else{
            int somaum = 0;
            for(int i = 0; i < 9; i++){
                char digitos = numero.charAt(i);
                int x = Character.getNumericValue(digitos);
                somaum = somaum + (x * (10 - i));
            }
            int restoum = somaum % 11;
            if(restoum == 0 || restoum == 1){
                restoum = 0;
            }else{
                restoum = 11 - restoum;
            }
            
            int somadois = 0;
            for(int i = 0; i < 10; i++){
                char digitos = numero.charAt(i);
                int x = Character.getNumericValue(digitos);
                somadois += x * (11 - i);
            }
            int restodois = somadois % 11;
            if(restodois == 0 || restodois == 1){
                restodois = 0;
            }else{
                restodois = 11 - restodois;
            }
            
             char digitodez = numero.charAt(9);
             int validadordez = Character.getNumericValue(digitodez);
             char digitoonze = numero.charAt(10);
             int validadoronze = Character.getNumericValue(digitoonze);
            if(validadordez == restoum && validadoronze == restodois){
                 return true;
             }else{
                 return false;
             }
        }
        
    }

    public CPF() {
        this.numero = "";
    }
    
    public CPF(String numero){
        this.numero = numero;
        this.flag = 1;
    }
    
        public void setEmissao(int dia, int mes, int ano){
          if(dia != 0|| mes != 0 || ano != 0){
            this.diaEmissao = dia;
            this.mesEmissao = mes;
            this.anoEmissao = ano;  
          }
    }
    
        public String getEmissao(){
            if(diaEmissao == 0 || mesEmissao == 0 || anoEmissao == 0){
                String erro = "Para exibir a data de emissao, entre com data e numeracao validas!";
                setNumero(null);
                return erro;
            }else{
                return this.diaEmissao + "/" + this.mesEmissao + "/" + this.anoEmissao;
            }
    }
    
}