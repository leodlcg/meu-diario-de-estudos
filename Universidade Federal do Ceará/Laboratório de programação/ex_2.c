#include <stdio.h>

int main (){

float dolar, real, converter;

printf("Quantos Reais deseja converter? \n");
scanf("%f", &real);

printf("Qual o valor atual do Dolar em Reais? \n");
scanf("%f", &dolar);

converter = real / dolar;

printf("De acordo com a cotação atual de R$%f - $1. \n R$%f convertidos são $%f.", dolar, real, converter);

    return 0;
}