/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <math.h>

int main()

{
    
    //Variaveis para armazenar os dados.
    float peso = 0;
    float altura = 0;
    float IMC = 0;
    

    printf("Qual o seu peso em Quilogramas?\n");
    scanf("%f", &peso); //Capta o peso escolhido pelo usuario.
    printf("Qual a sua altura em Metros?\n");
    scanf("%f", &altura); //Capta a altura escolhida pelo usuario.
    IMC = (peso / pow(altura, 2)); //Calcula o IMC usando a biblioteca math.h e a potencia com o pow(x,y)

    //Verifica em qual tabela de IMC o usuario se encaixa.
    if(IMC < 18.5){
    printf("Está Abaixo do peso IMC: %.2f\n", IMC);
    }else if(IMC >= 18.5 && IMC <= 24.9){
    printf("Está com Peso normal IMC: %.2f\n", IMC);
    }else if(IMC >= 25 && IMC <= 29.9){
    printf("Está com Sobrepeso IMC: %.2f\n", IMC);
    }else if(IMC >= 30 && IMC <= 39.9){
    printf("Está com Obesidade I IMC: %.2f\n", IMC);
    }else if(IMC >= 40){
    printf("Está com Obesidade II IMC: %.2f\n", IMC);
    }else{
    printf("Os dados não estão corretos :(");   
    }
    
    return 0;
}