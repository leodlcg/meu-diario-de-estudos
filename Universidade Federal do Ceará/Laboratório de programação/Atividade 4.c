/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <math.h>

int main()

{
    
    int numero; //Armazena número.
    
    printf("DIga um número inteiro entre 1 e 10\n");
    scanf("%d", &numero);  //Pede o número ao usuario.
    
    
    for(int i = 0; i < numero; i++){ //Inicia o loop para as quebras de linha.
        for(int o = 0; o < numero; o++){ //Inicia o loop para os numeros.
            if(i == o){
                printf("1 ");
            }else if(o > i){
                printf("2 ");
            }else {
                printf("3 ");
            }
        }
        printf("\n");
    }
    
    
    return 0;
}