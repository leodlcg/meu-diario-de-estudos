#include<stdio.h>

int main(){

    typedef struct Produto{
    int codigo;
    char nome[30];
    int quantidade;
    float valorCompra;
    float valorVenda;
    }Produto;

    Produto produto;

    printf("Digite o codigo do produto(Apenas inteiros):\n");
    scanf("%d", &produto.codigo);

    printf("Digite o nome do produto:\n");
    scanf("%s", &produto.nome[0]);

    printf("Digite a quantidade do produto(Apenas inteiros):\n");
    scanf("%d", &produto.quantidade);

    printf("Digite o Valor da compra do produto(Em R$):\n");
    scanf("%f", &produto.valorCompra);

    printf("Digite o Valor da venda do produto(Em R$):\n");
    scanf("%f", &produto.valorVenda);

    printf("Os valores da struct sao:\n%d\n%s\n%d\n%f\n%f",produto.codigo,produto.nome,produto.quantidade,produto.valorCompra,produto.valorVenda);


    return 1;
}