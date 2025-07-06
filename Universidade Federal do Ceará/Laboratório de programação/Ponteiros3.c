#include<stdio.h>


int main(){

    char frase[30];
    printf("Digite sua frase:\n");
    scanf("%s", frase);

    char *PonteiroFrase;
    PonteiroFrase = &frase[0];
    int tamanhoFrase = 0;


    while (*PonteiroFrase != '\0')
    {
        PonteiroFrase = PonteiroFrase + 1;
        tamanhoFrase = tamanhoFrase + 1;
    }
    
    printf("Voce tem um string de %d caracteres!", tamanhoFrase);

    return 0;
}