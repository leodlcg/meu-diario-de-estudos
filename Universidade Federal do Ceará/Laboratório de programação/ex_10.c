#include<stdio.h>
#include<math.h>

int main(){

    float a, b, c, delta, x1, x2;

    printf("Digite o valor de a:");
    scanf("%f" ,&a);
    printf("Digite o valor de b:");
    scanf("%f" ,&b);
    printf("Digite o valor de c:");
    scanf("%f" ,&c);


    if(a == 0){
        printf("Nao e uma equacao de 2 grau :(");
        return 1;
    }

    delta = pow(b, 2) - 4 * a * c;
    
    if(delta > 0){
        x1 = (((b * -1) + sqrt(delta))/ 2 * a);
        x2 = (((b * -1) - sqrt(delta))/ 2 * a);
         printf("O valor de x1 e %f, e o valor de x2 e %f", x1, x2);
    }else if (delta == 0){
        x1 = (((b * -1) + sqrt(delta))/ 2 * a);
        printf("O valor de x1 e: %f", x1);
    }else{
        printf("Nao a raizes reais pois o delta e negativo :(");
    }



    return 0;
}