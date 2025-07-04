#include <stdio.h>


int main() {

FILE *p;
char nome[50];
int mat,fis,qui;

p = fopen("Notas.txt", "w");
if (p == NULL){
    printf("Erro ao criar o arquivo :(");
    system("pause");
    exit(1);
}else{

    printf("Escreva o nome do aluno:");
    scanf("%s", &nome);

    printf("Escreva a nota de Matematica:");
    scanf("%d", &mat);

    printf("Escreva a nota de Fisica:");
    scanf("%d", &fis);

    printf("Escreva a nota de Quimica:");
    scanf("%d", &qui);

    fprintf(p, "Nome do aluno: %s\nMatematica: %d\nFisica: %d\nQuimica: %d\nA media das notas e: %d", nome, mat, fis, qui, ((mat + fis + qui)/3));
    fclose(p); 

    printf("\nAs notas ja estao prontas no arquivo Notas.txt :)");
}

return 0;
}