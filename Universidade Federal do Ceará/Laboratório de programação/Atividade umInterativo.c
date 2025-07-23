#include <stdio.h>

int fibo(int n) {
    int num = 0, ndois = 1, acumulador;

    if (n == 0) {
        return num;
    } 
    if (n == 1) {
        return ndois;
    }

    for (int i = 2; i <= n; i++) {
        acumulador = num + ndois;
        num = ndois;
        ndois = acumulador;
    }

    return ndois;
}

int main() {
    int resposta = fibo(40);
    printf("%d", resposta);
    //TotalMilliseconds : 55.6501
    return 0;
    
}
