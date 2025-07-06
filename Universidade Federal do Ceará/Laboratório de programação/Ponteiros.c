#include <stdio.h>
#include <string.h>

void TiposPonteiros(int *PonteiroInt, float *PonteiroFloat,  char *PonteiroChar){
    int inteiros;
    float real;
    char frase[6];
    int *inteirosPonteiro;
    float *floatPonteiro;
    char *charPonteiro;
    inteirosPonteiro = &inteiros;
    floatPonteiro = &real;
    charPonteiro = &frase[0];

    *inteirosPonteiro = 10;
    *floatPonteiro = 4.2;
    strcpy(charPonteiro, "frase");

    *PonteiroInt = *inteirosPonteiro;
    *PonteiroFloat = *floatPonteiro;
    strcpy(PonteiroChar, charPonteiro);


};

int inteirosGlobal;
float realGlobal;
char fraseGlobal[6];

int main() {


TiposPonteiros(&inteirosGlobal, &realGlobal, fraseGlobal);

    printf("Int: %d\n", inteirosGlobal);
    printf("Float: %f\n", realGlobal);
    printf("Char: %s\n", fraseGlobal);


return 0;
}