/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>


int vetor[10];
int tamanho = 0;
int indice = 0;


 int funcaobuscavetor(){
    for(int i = 0; i < tamanho; i++){
        if (vetor[i] == 4){
            return i;
     }
    }
     
    return -1;
 }


int main()
{
    int x = 2;
    for(int i = 0; i < 10; i++){
        x = x + 2;
        vetor[i] = x;
        printf("%d", vetor[i]);
        tamanho =  tamanho + 1;
    }
    

    int resultado = funcaobuscavetor();
    printf("\nO indice do numero e %d", resultado);

    return 0;
    
}



