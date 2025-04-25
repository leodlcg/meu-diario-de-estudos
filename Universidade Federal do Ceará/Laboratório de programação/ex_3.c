#include <stdio.h>

int main (){

int numero;
printf("Digite um número e lhe direi seu sucessor e seu antecessor! \n");

scanf("%d", &numero);

printf("Seu número é: %d\nSeu sucessor é: %d\nSeu antecessor é: %d", numero, numero + 1, numero - 1);

return 0;

};