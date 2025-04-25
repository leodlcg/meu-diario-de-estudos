#include <stdio.h>


int main(){

int numero;
printf("Digite um número inteiro:\n");
scanf("%d", &numero);

if(numero > 0){
printf("Seu número é positivo!");
return 0;
}else if(numero == 0){
printf("Seu número é 0");
return 0;
}else{
    printf("Seu número é negativo!");
}

    return 0;

}