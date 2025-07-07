#include<stdio.h>

int main(){

    typedef struct Aluno{
    char nome[30];
    float mat;
    float fis;
    float media;
    }Aluno;

    Aluno aluno[5];

    for(int i = 0; i < 5; i++){
        printf("Digite o nome do Aluno %d\n", i + 1);
        scanf("%s", &aluno[i].nome);

        printf("Digite sua nota em Matematica:\n");
        scanf("%f", &aluno[i].mat);

        printf("Digite sua nota em Fisica:\n");
        scanf("%f", &aluno[i].fis);
        aluno[i].media = (aluno[i].mat + aluno[i].fis) / 2;

        printf("Aluno %d cadastrado!\n", i + 1);
    }

    for(int i = 0; i < 5; i++){
        printf("As notas de Aluno %d sao:\nMatematica: %.2f\nFisica: %.2f\nMedia: %.2f\n\n", i + 1, aluno[i].mat,aluno[i].fis,aluno[i].media);
    }

    return 1;
}