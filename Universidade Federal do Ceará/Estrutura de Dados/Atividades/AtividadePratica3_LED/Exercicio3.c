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

void soluciona_questao(int n, Pilha *origem, Pilha *destino, Pilha *auxiliar) {
        if (n == 1) {
        int joia = remover(origem);
        add(joia, destino);
        return; // para a funcao :)
    };

    soluciona_questao(n - 1, origem, auxiliar, destino);

    soluciona_questao(1, origem, destino, auxiliar);

    soluciona_questao(n - 1, auxiliar, destino, origem);
}

int main() {
    Pilha *origem = inicializa_pilha();
    Pilha *auxiliar = inicializa_pilha();
    Pilha *destino = inicializa_pilha();

    add(30, origem);
    add(20, origem);
    add(10, origem);

    printf("Estado inicial:\n");
    printf("Origem:\n");
    imprimir(origem);
    printf("Destino:\n");
    imprimir(destino);

    soluciona_questao(origem->tam, origem, destino, auxiliar);

    printf("\nEstado final:\n");
    printf("Origem:\n");
    imprimir(origem);
    printf("Destino:\n");
    imprimir(destino);

    return 0;
}
