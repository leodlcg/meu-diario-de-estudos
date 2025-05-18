/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int main()

{
    
    //Variaveis para armazenar os dados.
    int quantidadeCompra = 0;
    float valorProduto = 0;
    float total = 0;
    float totalDesconto = 0; 
    
    

    printf("Quantos produtos deseja comprar?\n");
    printf("(Caso compre mais de 10 unidades recebe um desconto de 5 porcento no valor total da compra.)\n");
    scanf("%d", &quantidadeCompra); //Capta a quantidade escolhida pelo usuario.
    printf("Qual valor unitario do produto?(R$)\n");
    scanf("%f", &valorProduto); //Capta o valor escolhida pelo usuario.
    total = valorProduto * quantidadeCompra; //Calcula o total sem desconto.
     
    //Verifica se ele tem direito ao desconto ou não.
    if(quantidadeCompra > 10){
    totalDesconto = total - (total * 0.05);
    printf("O valor total de seu pedido sem desconto é: R$%f\n", total);
    printf("O valor total de seu pedido com desconto é: R$%f\n", totalDesconto);
    }else{
    printf("O valor total de seu pedido sem desconto é: R$%f\n", total);
    }
    
    return 0;
}