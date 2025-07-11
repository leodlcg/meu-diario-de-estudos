#include<stdio.h>
#include<string.h>

int main(){

    typedef struct Voo{
    char codigoVoo[30];
    char codigoAeroportoDestino[30];
    char codigoAeroportoOrigem[30];
    }Voo;

    typedef struct Aeroporto{
        char codigoAeroporto[30];
        int quantidadeVoosChegada;
        int quantidadeVoosSaida;
    }Aeroporto;
    
    Aeroporto aeroportos[5];
    Voo voos[100];

    int totalVoos = 0;
    int totalAeroportos = 0;

        char codigoAeroportoDestino[30];
        char codigoAeroportoOrigem[30];
        char codigoVoo[30];
        char codigoAeroporto[30];
        char fecharApp = 'a';

        Aeroporto *Ponteiro;
        char *PonteiroAux;


    while (1)
    {

        printf("============Menu============\n");
        printf("[1] - Cadastrar Aeroporto\n");
        printf("[2] - Cadastrar Voo\n");
        printf("[3] - Acessar Aeroporto\n");
        printf("[4] - Sair\n");
        printf("============================\n");
        printf("O que deseja realizar?\n");
        int decisaoUsuario;
        scanf("%d", &decisaoUsuario);
        
        switch (decisaoUsuario){

            case 1: //Cadastro de Aeroportos
                for(int i = 0; i < 100; i++) printf("\n"); //"Limpa o console"
                printf("======Cadastro Aeroporto %d======\n", totalAeroportos + 1);
                printf("Qual o codigo do Aeroporto?:\n");
                scanf("%s", &codigoAeroporto[0]);
                for(int i = 0; i < 100; i++) printf("\n"); //"Limpa o console"
                if(totalAeroportos == 0){
                    strcpy(aeroportos[0].codigoAeroporto, codigoAeroporto);
                    totalAeroportos++;
                    printf("Aeroporto criado corretamente!  Voltando ao Menu...\n");
                    continue;
                }
                    for(int i = 0; i < totalAeroportos; i++){
                        if(strcmp(aeroportos[i].codigoAeroporto, codigoAeroporto) == 0){
                            printf("Voce esta criando codigos repetidos! Voltando ao Menu...\n");
                            break;        
                        }else if (i == (totalAeroportos - 1)){
                            strcpy(aeroportos[i + 1].codigoAeroporto, codigoAeroporto);
                            totalAeroportos++;
                            printf("Aeroporto criado corretamente!  Voltando ao Menu...\n");
                            break; 
                        }else{
                            continue;
                        }
                    }

            break;

            case 2: //Cadastro de Voos
                if(totalAeroportos == 0 || totalAeroportos == 1){
                    printf("\n\n======Cadastro Voo======\n");
                    if(totalAeroportos == 0){
                        printf("Nenhum Aeroporto Cadastrado!\n");
                    }else{
                        printf("Apenas 1 Aeroporto Cadastrado!\n");
                    }   
                    printf("Voltando ao menu...\n");
                    continue;
                }
                printf("\n\n======Cadastro Voo %d======\n", totalVoos + 1);
                printf("Qual o codigo do voo?\n");
                scanf("%s", &codigoVoo[0]);

                printf("Qual o codigo do Aeroporto de Destino?\n");
                scanf("%s", &codigoAeroportoDestino[0]);

                for(int i = 0; i < totalAeroportos; i++){
                    if(strcmp(aeroportos[i].codigoAeroporto, codigoAeroportoDestino) == 0){
                        printf("Aeroporto encontrado!\n");
                        printf("Qual o codigo do Aeroporto de Origem?\n");
                        scanf("%s", &codigoAeroportoOrigem[0]);
                        for(int i = 0; i < totalAeroportos; i++){
                            if(strcmp(aeroportos[i].codigoAeroporto, codigoAeroportoOrigem) == 0){
                                strcpy(voos[totalVoos].codigoVoo, codigoVoo);
                                strcpy(voos[totalVoos].codigoAeroportoDestino, codigoAeroportoDestino);
                                strcpy(voos[totalVoos].codigoAeroportoOrigem, codigoAeroportoOrigem);
                                totalVoos++;
                                printf("Voo %s criado com sucesso!\n", codigoVoo);
                                printf("Voltando ao Menu...!\n", codigoVoo);
                                break;
                            }else if((i == (totalAeroportos - 1))){
                                break;
                            }else{
                                continue;
                            }
                        }
                    }else if(i == (totalAeroportos - 1)){
                        break;
                    }else{
                        continue;
                    }
                }
                if(strcmp(voos[totalVoos - 1].codigoAeroportoOrigem, codigoAeroportoOrigem) == 0){
                    break;
                }else{
                printf("Nenhum Aeroporto Encontrado!\n");
                printf("Voltando ao Menu...!\n");
                break;
                }
            case 3: //Acessar de Aeroportos
                for(int i = 0; i < 100; i++) printf("\n"); //"Limpa o console"
                printf("\n\n======Aeroportos Cadastrados======\n");
                if(totalAeroportos == 0){
                    printf("Nenhum Aeroporto Cadastrado!\n");
                    printf("Voltando ao menu...\n");
                    continue;
                }else{
                    for(int i = 0; i < totalAeroportos; i++){
                    printf("Aeroporto %d Codigo: %s\n", i + 1, aeroportos[i].codigoAeroporto);
                    }
                } 
                printf("==================================\n");
                printf("Qual Aeroporto deseja acessar?\n");
                printf("(Digite o codigo do Aeroporto)\n");
                scanf("%s", &codigoAeroporto[0]);
                for(int i = 0; i < totalAeroportos; i++){ //Verifica se o codigo do aeroporto existe!
                    if(strcmp(aeroportos[i].codigoAeroporto, codigoAeroporto) == 0){
                        printf("\n\n======Aeroporto %s======\n", codigoAeroporto);
                            for(int i = 0; i < totalVoos; i++) {
                                if(strcmp(codigoAeroporto, voos[i].codigoAeroportoOrigem) == 0 ||
                                    strcmp(codigoAeroporto, voos[i].codigoAeroportoDestino) == 0) {
                                    printf("Voo: %s\n", voos[i].codigoVoo);
                                    printf("Origem: %s\n", voos[i].codigoAeroportoOrigem);
                                    printf("Destino: %s\n", voos[i].codigoAeroportoDestino);
                                    printf("=========================\n");
                                    }
                                }
                                    printf("Dados exibidos!\n");
                                    printf("Voltando ao menu...");
                                    break;
                    }else if(i == (totalAeroportos - 1)){
                        printf("\n\n======Aeroportos Cadastrados======\n");
                        printf("Codigo do Aeroporto nao existe!\n");
                        printf("Voltando ao menu...\n");
                        break;
                    }else{
                        continue;
                    }
                }
                break;              

            case 4:
            fecharApp = 'f';
            for(int i = 0; i < 100; i++) printf("\n"); //"Limpa o console"
            printf("\n\nAte mais :)");
            break;

            default:{
            fecharApp = 'f';
            printf("\n\n=================ERROR=================\n");
            printf("Escolha invalida! Fechando o programa!\n");
            printf("=================ERROR=================\n\n\n");
            break;
            }

        }
        if(fecharApp == 'a'){
          continue;
        }else{
          break;
        }
    }
    
    return 1;
}