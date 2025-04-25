#include <stdio.h>


int main(){

int c, f;

printf("Me diga a temperatura em Celsius que lhe direi em Fahrenheit!\n");
scanf("%d", &c);

f = (((c * 9) / 5) + 32);
printf("Sua temperatura em Fahrenheit é: %d", f);
}