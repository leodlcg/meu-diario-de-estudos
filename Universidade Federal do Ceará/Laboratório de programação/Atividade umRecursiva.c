#include<stdio.h>


int main(){

    int resposta;

    int fibo(int n){

        if(n == 1){
            return(1);
        }
        if( n == 2){
            return(1);
        }

            return(fibo(n - 1) + fibo(n - 2));
    }


    resposta = fibo(40);
    printf("%d", resposta);
    //TotalMilliseconds : 1028.6153

    return 0;
}