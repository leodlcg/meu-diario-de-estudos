#include<stdio.h>

int main(){


    char frase[30];
    printf("Digite uma frase:\n");
    scanf("%s", frase);

    char *PonteiroFrase;
    int TamanhoFrase = 0;

    PonteiroFrase = &frase[0];
    
    while (*PonteiroFrase != '\0')
    {
        PonteiroFrase = PonteiroFrase + 1;
        TamanhoFrase = TamanhoFrase + 1;
     }


        printf("Sua frase invertida e:\n");
     for(int i = 0; i < TamanhoFrase; i++){
         PonteiroFrase = PonteiroFrase - 1;
         printf("%c", *PonteiroFrase);
     }

        
    return 0;
}