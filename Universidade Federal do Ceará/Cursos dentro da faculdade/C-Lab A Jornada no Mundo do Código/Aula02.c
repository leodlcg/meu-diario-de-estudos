/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/
#include <stdio.h>

int main() {
    char prato[100];
    float valor[10];

    printf("Digite o nome do prato:\n");
    scanf("%99s", prato);  
    
    
    for(int i = 0; i < 3; i++){
        printf("Digite o %d valor para o prato %s: \n", i + 1, prato);
        scanf("%f", &valor[i]);
    }
    
    printf("Os valores para o prato %s são: \n Valor 1: %f \n Valor 2: %f \n Valor 3: %f", prato, valor[0],valor[1],valor[2]);

    return 0;
}