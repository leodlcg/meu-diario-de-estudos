#include<stdio.h>

    int fatorialrecursivo(int n){

        if(n <= 1){
            return 1;
        }

         return n * fatorialrecursivo(n - 1);
    }


int main()
{

    int n = 30, resposta;


    fatorialrecursivo(n);
    resposta = fatorialrecursivo(n);
    printf("%d", resposta);
    
    return 0;
}


