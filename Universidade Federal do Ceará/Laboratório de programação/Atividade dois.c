#include<stdio.h>


int main(){

    int matriz[4][4];
    int somador = 0;

    for(int i = 0; i < 4; i++){

        for(int j = 0; j < 4; j++){
            matriz[i][j] = i + j;
            printf("%d", matriz[i][j]);
        }
         printf("\n");
    }

    printf("\n");

    for(int i = 0; i < 4; i++){

        for(int j = 0; j < 4; j++){
        somador = somador + matriz[j][i];
        }
        printf("Soma da coluna %d: %d \n", i, somador);
        somador = 0;
    }

    return 0;
}