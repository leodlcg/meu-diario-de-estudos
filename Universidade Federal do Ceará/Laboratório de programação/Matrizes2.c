/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int main()
{
    
    int numeros[3][4];
    int acumulador = 0;
    
    
    for (int i = 0; i < 3; i++){
        printf("\n");
        for(int j = 0; j < 4; j++){
            acumulador = acumulador + 1;
            numeros[i][j] = acumulador;
            printf("%d", numeros[i][j]);
        }
    }
    
    return 0;
}