#include <stdio.h>


int main() {

FILE *p;
char frase[] = "Dados do Arquivo 01";
char dados[100];

 p = fopen("Arquivo01.txt", "w");
fprintf(p, "%s", frase);
fclose(p); 

p = fopen("Arquivo02.txt", "w");
fclose(p);

p = fopen("Arquivo01.txt", "r");
fgets(dados,100,p);
fclose(p); 

p = fopen("Arquivo02.txt", "r+");
fprintf(p, "%s", dados);
fclose(p); 
return 0;
}