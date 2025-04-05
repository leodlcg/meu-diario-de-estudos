#include<stdio.h>
#include<stdlib.h>

typedef struct No{
    int valor;
    struct No * prox;
    struct No * ant;
}No;

No *inicio = NULL;
No *fim = NULL;
int tam = 0;

void add(int valor, int pos){
    
    if(pos >= 0 && pos <= tam){

        No * novo = malloc(sizeof(No));
        novo->valor = valor;
        novo->prox = NULL;
        novo->ant = NULL;

        //1 caso: lista vazia
        if(inicio == NULL){
            inicio = novo;
            fim = novo;
        // 2 caso: lista nao esta vazia e eu quero add no inicio
        }else if(pos == 0){
            novo->prox = inicio;
            inicio->ant = novo;
            inicio = novo;
        // 3 caso: lista nao esta vazia e eu quero add no fim
        }else if(pos == tam){

            fim->prox = novo;
            novo->ant = fim;
            fim = novo;
            // 4 caso: lista nao esta vazia - "meio"
        }else{
            No *aux = inicio;
            for(int i = 0; i<pos-1; i++){
                aux= aux->prox;
            }
            novo->prox = aux->prox;
            novo->ant = aux;
            aux->prox = novo;
            novo->prox->ant = novo;
        }
        tam++;
    }else{
        printf("Posicao invalida - insercao nao realizada!\n");
    }   
}

int remover_maior(){
    int valor;
    if(tam == 1){
        No *lixo = inicio;
        inicio = NULL;
        fim = NULL;
        valor = lixo->valor;
        free(lixo);
        tam--;
    }else if (tam >1){
        //pelo menos 2 elementos
        No *maior = inicio;
        No *aux = inicio->prox;
        while(aux != NULL){
            if(aux->valor > maior->valor){
                maior = aux;
            }
            aux = aux->prox;
        }
        //eu tenho que o ponteior maior esta armazenando
        //o endereco o maior elemento
        if (inicio->valor == maior->valor){
            No *lixo = inicio;
            inicio = inicio->prox;
            inicio->ant = NULL;
            valor = lixo->valor;
            free(lixo);
        }else if (fim->valor == maior->valor){
            No *lixo = fim;
            fim = fim->ant;
            fim->prox = NULL;
            valor = lixo->valor;
            free(lixo);
        }else{
            maior->ant->prox = maior->prox;
            maior->prox->ant = maior->ant;
            valor = maior->valor;
            free(maior);
        }
        tam--;
        
    }else{
        printf("Lista Vazia! :/");
        valor = -1;
    } 
    return valor;
}

void imprimir(){
    No *aux = inicio;
        for (int i = 0; i<tam; i++){
            printf("Valor:%d\n", aux->valor);
            aux = aux->prox;
        }
}

int main(){
    add(15, 0);
    add(32, 0);
    add(10, 0);
    add(50, 2);
    add(40, 4);
    remover_maior();
    imprimir();
    return 0;
}
