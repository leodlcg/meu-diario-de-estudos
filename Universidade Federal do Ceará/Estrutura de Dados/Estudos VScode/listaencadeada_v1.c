#include<stdio.h>
#include<stdlib.h>

typedef struct No{
    int valor;
    struct No * prox;
}No;

No *inicio = NULL;
No *fim = NULL;
int tam = 0;

void add(int valor, int pos){

   No * novo = malloc(sizeof(No));
   novo->valor = valor;
   novo->prox = NULL;

    //1 caso: lista vazia
    if(inicio == NULL){
        inicio = novo;
        fim = novo;
    // 2 caso: lista nao esta vazia e eu quero add no inicio
    }else if(pos == 0){
        novo->prox = inicio;
        inicio = novo;
    // 3 caso: lista nao esta vazia e eu quero add no fim
    }else if(pos == tam){

        fim->prox = novo;
        fim = novo;
        // 4 caso: lista nao esta vazia - "meio"
    }else{
        No *aux = inicio;
        for(int i = 0; i<pos-1; i++){
            aux= aux->prox;
        }
        novo->prox = aux->prox;
        aux->prox = novo;
    }

    tam++;
}


int remover(int pos){
    int valor;
    if(tam == 1){
        No *lixo = inicio;
        inicio = NULL;
        fim = NULL;
        valor = lixo->valor;
        free(lixo);
    }else if (tam > 1 && pos == 0){
        No *lixo = inicio;
        inicio = inicio->prox;
        valor = lixo->valor;
        free(lixo);
    }else if (tam > 1 && pos == tam){
        No *lixo = fim;
        No *aux = inicio;
        for (int i = 0; i<tam-2; i++){
            aux = aux->prox;
        }
        fim = aux;
        valor = lixo->valor;
        free(lixo);
    }else{
        No *aux = inicio;
        for (int i = 0; i<pos-1; i++){
            aux = aux->prox;
        }
        No *lixo = aux->prox;
        aux->prox = aux->prox->prox;
    }
    tam--;
    return valor;
}


int main(){
    add(10, 0);
    add(32, 0);
    add(10, 0);
    add(50, 3);
    add(40, 2);
    return 0;
}
