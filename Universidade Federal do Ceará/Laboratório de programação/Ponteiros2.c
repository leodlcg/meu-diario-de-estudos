#include<stdio.h>

      void numeros(int *vetor){

         for(int i = 0; i < 5; i++){
           int valor;
           printf("Digite o %d numero:\n", i + 1);
           scanf("%d", &valor);
           *vetor = valor;
           vetor = vetor + 1;
        }
      };


int main(){

    int vetor[5];
    numeros(&vetor[0]);

    for(int i = 0; i < 5; i++){
        printf("Valor: %d\n", vetor[i]);
    }

    return 0;
}