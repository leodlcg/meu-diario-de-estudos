#include <stdio.h>

int main(){

int numero1, numero2;

printf("Me diga o primeiro número inteiro:\n");
scanf("%d", &numero1);
printf("Me diga o segundo número inteiro:\n");
scanf("%d", &numero2);

if (numero1 > numero2){
    printf("O maior número é: %d", numero1);
    return 0;
}else{
    printf("O maior número é: %d", numero2);
}

return 0;
}