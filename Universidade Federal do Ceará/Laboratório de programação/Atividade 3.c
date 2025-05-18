/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <math.h>

int main()

{
    
    int loop = 1; //Variavel para fechar o loop corretamente!
    int escolhaUsuario = 0; 
        
        
        while(loop){  //Loop de repetição para manter sempre o menu ativo!
            printf("========= MENU =========\n");
            printf("1 - Verificar se um número é positivo, negativo ou zero\n");
            printf("2 - Verificar se um número é maior que outro\n");
            printf("3 - Calcular a média de dois números\n");
            printf("0 - Sair\n");
            printf("=======================\n");
            printf("Escolha uma opção:\n");
            scanf("%d", &escolhaUsuario);
            
            switch (escolhaUsuario){ //switch com os cases escolhidos pelo usuario.
                case 0: {
                    printf("Até mais tarde :)");
                    loop = 0;
                    break; //break para voltar ao menu.
                }
                case 1: {
                    int numero = 0;
                    printf("Escolha um número: \n");
                    scanf("%d", &numero);
                    if(numero == 0){
                    printf("Seu número é 0 :3: \n");
                    }else if(numero > 0){
                    printf("Seu número é positivo :3: \n");
                    }else{
                    printf("Seu número é negativo :3: \n");
                    }
                    break; //break para voltar ao menu.
                }
                case 2: {
                    int numero1, numero2;
                    printf("Digite o primeiro número: \n");
                    scanf("%d", &numero1);
                    printf("Digite o segundo número: \n");
                    scanf("%d", &numero2);
                    if(numero2 > numero1){
                    printf("O segundo número é maior que o primeiro: %d > %d.\n", numero2, numero1);
                    }else{
                    printf("O primeiro número é maior que o segundo: %d > %d.\n", numero1, numero2);
                    }
                    break; //break para voltar ao menu.
                }
                case 3: {
                    int numero1, numero2;
                    printf("Digite o primeiro número: \n");
                    scanf("%d", &numero1);
                    printf("Digite o segundo número: \n");
                    scanf("%d", &numero2);
                    printf("A média de %d e %d é: %d\n", numero1, numero2, ((numero1 + numero2) / 2));
                    break; //break para voltar ao menu.
                }
                default: {
                    printf("Opção invalida tente novamente :(\n");
                    break; //break para voltar ao menu.
                }
                    
            }
            
        }
             

    
    return 0;
}