#include <stdio.h>

int main(){

float c, k;

printf("Me diga a temperatura em Celsius que lhe direi em Kelvin:\n");
scanf("%f", c);

k = c + 273.15;

printf("A temperatura em Kelvin é: %f", k);

}