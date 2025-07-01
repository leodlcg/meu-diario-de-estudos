/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int main()
{
    
    int numeros[5][5];
    int acumulador = -1;
    
    
    for (int i = 0; i < 5; i++){
        acumulador = acumulador + 1;
        for(int j = 0; j < 5; j++){
            numeros[i][j] = acumulador;
        }
    }
    
    
    for (int i = 0; i < 5; i++){
        printf("\n");
        for(int j = 0; j < 5; j++){
            printf("%d", numeros[i][j]);
        }
    }
    
    

    return 0;
}