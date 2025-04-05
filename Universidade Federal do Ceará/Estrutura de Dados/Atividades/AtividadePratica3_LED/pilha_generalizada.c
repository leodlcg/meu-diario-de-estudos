#include<stdio.h>
#include<stdlib.h>

typedef struct No{
    int valor;
    struct No * prox;
}No;


typedef struct pilha{
    No * topo;
    int tam;
}Pilha;

void add(int valor, Pilha *p){

        No * novo = malloc(sizeof(No));
        novo->valor = valor;
        novo->prox = NULL;

        //1 caso: pilha vazia
        if(p->topo == NULL){
            p->topo = novo;
        // 2 caso: pilha nao esta vazia e eu quero add no topo
        }else{
            novo->prox = p->topo;
            p->topo = novo;
        }
        p->tam++;
}

int remover(Pilha *p){
    int valor;
    if(p->tam > 0){
        No *lixo = p->topo;
        p->topo = p->topo->prox;
        valor = lixo->valor;
        free(lixo);
        p->tam--;
        return valor;
    }else{
        printf("Pilha esta vazia!");
        return -1;
    }   
}

void imprimir(Pilha *p){
    No *aux = p->topo;
        for (int i = 0; i<p->tam; i++){
            printf("Valor:%d\n", aux->valor);
            aux = aux->prox;
        }
}

Pilha * inicializa_pilha(){

    Pilha *p = malloc(sizeof(Pilha));
    p->topo = NULL;
    p->tam = 0;
    return p;
}

void soluciona_questao(...){
    ... //add e remover..
}



int main(){

    Pilha *A = inicializa_pilha();
    Pilha *B = inicializa_pilha();
    Pilha *C = inicializa_pilha();
    add(10, A);
    add(32, B);
    add(10, C);
    add(50, A);
    add(40, C);
    printf("Imprimindo pilha A:\n");
    imprimir(A);
    printf("Imprimindo pilha B:\n");
    imprimir(B);
    printf("Imprimindo pilha C:\n");
    imprimir(C);
    return 0;
}
