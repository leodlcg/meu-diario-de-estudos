/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int main()
{
    
    int numeros[4][4];
    int leitura,flag = 0;
    int acumulador = 0;
    
    
    printf("Qual numero deseja procurar na Matriz?\n");
    scanf("%d", &leitura);
    
    for (int i = 0; i < 4; i++){
        printf("\n");
        for(int j = 0; j < 4; j++){
            acumulador = acumulador + 1;
            numeros[i][j] = acumulador;
            printf("%d", numeros[i][j]);
                if(leitura == numeros[i][j]){
                    flag = 1;
                 }
                 if(i == 3 && j == 3){
                     if(flag){
                         printf("\nSeu numero esta na Matriz! :)");
                     }else{
                         printf("\nSeu numero nao esta na Matriz! :(");
                     }
                 }
    }}

    return 0;
}


