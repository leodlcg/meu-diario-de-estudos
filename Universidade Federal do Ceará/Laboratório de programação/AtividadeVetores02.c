/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int vetorDesordenado[6], vetorPar[6], vetorImpar[6];


int main (){
    
 for (int i = 0; i < 6; i++){
     printf("Escreva o %d° numero \n", i + 1);
     scanf("%d", &vetorDesordenado[i]);
 } 
    
    for (int i = 0; i < 6; i++){
        if ((vetorDesordenado[i]%2) == 0){
            vetorPar[i] = vetorDesordenado[i];
        }else{
            vetorImpar[i] = vetorDesordenado[i];
        }
    }
    
    printf("O vetor par: ");
    for(int i = 0; i < 6; i++){
        printf("%d - ", vetorPar[i]);
    }
    
    printf("\nO vetor impar: ");
    for(int i = 0; i < 6; i++){
        printf("%d - ", vetorImpar[i]);
    }
    
}



