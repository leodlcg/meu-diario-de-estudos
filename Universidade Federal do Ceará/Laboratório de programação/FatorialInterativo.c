#include <stdio.h>

int FatorialInterativo(int n) {
    int resultado = 1; 
    for (int i = 1; i <= n; i++) {
        resultado *= i;
    }
    return resultado;
}

int main() {
    int n = 3;
    int resposta = FatorialInterativo(n); 
    printf("%d\n", resposta); 
    return 0;
}