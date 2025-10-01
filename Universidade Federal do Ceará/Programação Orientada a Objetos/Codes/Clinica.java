public class ConsultaVisao{
    
    String nome;
    int idade;
    float acuidadeDireito;
    float acuidadeEsquerdo;
 
 
 public void setNome(String x){
     
     this.nome = x;
 }
 
 
 public void setIdade(int x){
       if(x > 100 || x < 0){
           this.idade = 0;
       }else{
           this.idade = x;
       }
 }
 
  public void setAcuidadeOlhoDireito(float x){
     
        if(x > 1 || x < 0){
           this.acuidadeDireito = 0;
       }else{
           this.acuidadeDireito = x;
       }
    
 }
 
  public void setAcuidadeOlhoEsquerdo(float x){
     
        if(x > 1 || x < 0){
           this.acuidadeEsquerdo = 0;
       }else{
           this.acuidadeEsquerdo = x;
       }
 }
 
  public String getNome(){
      return nome;
     
 }
   public int getIdade(){
       return idade;
     
 }
   public float getAcuidadeOlhoEsquerdo(){
       return acuidadeEsquerdo;
     
 }
   public float getAcuidadeOlhoDireito(){
       return acuidadeDireito;
     
 }
 
 
 
 public float calcularMediaAcuidade(){
     float media = (acuidadeDireito + acuidadeEsquerdo) / 2;
     return media;
 }
 
 public String calcularClassificacao(){
     float media = calcularMediaAcuidade();
     String classificao;
     if(media >= 0.9){
         classificao = "Excelente";
     }else if(media >= 0.7 && media < 0.9){
         classificao = "Boa";
     }else if(media >= 0.5 && media < 0.7){
         classificao = "Moderada";
     }else if(media >= 0.3 && media < 0.5){
         classificao = "Ruim";
     }else{
         classificao ="Muito Ruim";
     }
            return classificao;
      }
 
public String gerarRelatorio() {
    if(nome == null || idade == 0 || acuidadeDireito == 0 || acuidadeEsquerdo == 0){
    String relatorio = "Entre com todos os dados do paciente!";
    return relatorio;
    }else{
    String relatorio = nome.toUpperCase() + ", " + idade + " anos\n" +
        "Acuidade Visual (OE): " + String.format("%.2f", acuidadeEsquerdo) + "\n" +
        "Acuidade Visual (OD): " + String.format("%.2f", acuidadeDireito) + "\n" +
        "Media da Acuidade Visual: " + String.format("%.2f", calcularMediaAcuidade()) + "\n" +
        "Classificacao: " + calcularClassificacao();
        return relatorio;
}
}



}