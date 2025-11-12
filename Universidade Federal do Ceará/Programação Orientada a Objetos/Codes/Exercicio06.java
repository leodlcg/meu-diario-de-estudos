class ContaBancaria{

    int numeroConta;
    double saldoInical;

    ContaBancaria(int numeroConta, double saldoInical){
        
        this.numeroConta = numeroConta;
        this.saldoInical = saldoInical;

    }

    public void depositar(double valor){
        this.saldoInical = valor + saldoInical;
        System.out.println("Deposito realizado com sucesso!");
    }

    public void sacar(double valor){
        this.saldoInical = saldoInical  - valor;
        System.out.println("Saque realizado com sucesso!");
    }



    public void mostrarSaldo(){
        System.out.println("Seu saldo atual e R$"+saldoInical);
    }

}

public class Exercicio06 {
    public static void main(String[] args){

        ContaBancaria leonardo = new ContaBancaria(232323, 100);
        leonardo.depositar(40);
        leonardo.mostrarSaldo();
        leonardo.sacar(10);
        leonardo.mostrarSaldo();
        leonardo.depositar(100);
        leonardo.mostrarSaldo();
    }



}
