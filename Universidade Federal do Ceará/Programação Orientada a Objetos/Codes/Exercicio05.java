class Funcionario{

    String nome;
    int salarioBase;
    Bonus bonus;


    public Funcionario(String nome, int salarioBase, Bonus x){
        
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.bonus = x;

    }


    public void calcularSalarioTotal(){
        System.out.println("Seu salario base e:R$" + salarioBase + " Seu bonus foi de R$" + bonus.exibirBonus() + " Seu salario total com bonus ficou R$" + (salarioBase + bonus.exibirBonus()));
    }
}

class Gerente extends Funcionario{


    public Gerente(String nome, int salarioBase, Bonus x){
        super(nome, salarioBase, x);
    }

}


class Bonus{

  int bonus = 10;
  public int exibirBonus(){
    return bonus;
  }
}


public class Exercicio05{
    public static void main(String[] args){
    Bonus BonusGerente = new Bonus();
    Gerente Gerente01 = new Gerente("Leonardo", 1200, BonusGerente) ;
    Gerente Gerente02 = new Gerente("Leonardo", 1200, BonusGerente);
    Gerente01.calcularSalarioTotal();
    Gerente02.calcularSalarioTotal();



    }
}