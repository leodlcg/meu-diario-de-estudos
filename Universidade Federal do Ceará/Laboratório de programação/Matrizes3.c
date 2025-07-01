/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int main()
{
    
    int numeros[3][3];
    int acumulador = 0;
    
    
    for (int i = 0; i < 3; i++){
        printf("\n");
        for(int j = 0; j < 3; j++){
            acumulador = acumulador + 1;
            numeros[i][j] = acumulador;
            printf("%d", numeros[i][j]);
                if(i == 2 && j == 2){
                    int linha1 = numeros[0][0] + numeros[0][1] + numeros[0][2];
                    int linha2 = numeros[1][0] + numeros[1][1] + numeros[1][2];
                    int linha3 = numeros[2][0] + numeros[2][1] + numeros[2][2];
                 printf("\n\nSoma linha 1 = %d\nSoma linha 2 = %d\nSoma linha 3 = %d", linha1, linha2, linha3);
                }
        }
    }
    
    return 0;
}