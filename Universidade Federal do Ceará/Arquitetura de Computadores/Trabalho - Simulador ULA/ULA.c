#include "ULA.h"       
#include <stdio.h>      

// Uma função static só pode ser usada dentro do arquivo .c onde foi declarada

// Somador completo de 1 bit baseado no livro de William Stallings
static void somadorCompleto(uint8_t A, uint8_t B, uint8_t cin, uint8_t *s, uint8_t *cout) {
    *s = (~A & ~B & cin) | (~A & B & ~cin) | (A & ~B & ~cin) | (A & B & cin);
    *cout = (A & B) | (A & cin) | (B & cin);
}
static void somador8bits(uint8_t *regA, uint8_t *regB, uint8_t *Cin, uint8_t *soma, uint8_t *Cout, uint8_t *overflow) {
    *Cout = *Cin; 
    for(int i = 0; i <= 7; i++) { 
        *Cin = *Cout;
        somadorCompleto((*regA >> i) & 1, (*regB >> i) & 1, *Cin, soma, Cout);
        *regA = (*soma) ? (*regA | (1 << i)) : (*regA & ~(1 << i));
    }
    *overflow = *Cin ^ *Cout;
}
static void complementador(uint8_t *A) {
    uint8_t BAux = 1, cin = 0, s, cout, overflow;
    *A = ~(*A);
    somador8bits(A, &BAux, &cin, &s, &cout, &overflow);
}
void ULA_ADD(int8_t *regA, int8_t *regB, int8_t *overflow) {
    int8_t cin = 0, s, cout;
    somador8bits(regA, regB, &cin, &s, &cout, overflow);
}
void ULA_SUB(int8_t *regA, int8_t *regB, int8_t *overflow) {
    int8_t BAux, cin = 0, s, cout;
    BAux = *regB;        
    complementador(&BAux);
    somador8bits(regA, &BAux, &cin, &s, &cout, overflow);
}
void ULA_MUL(int8_t *A, int8_t *Q, int8_t *M, int8_t *overflow) {
    *A = 0;             
    int8_t Q_1 = 0;    
    *overflow = 0;  
    for (int i = 0; i < 8; i++) { 
        if (Q_1 == 1 && (*Q & 1) == 0) 
            ULA_ADD(A, M, overflow);  
        else if (Q_1 == 0 && (*Q & 1) == 1) 
            ULA_SUB(A, M, overflow);   
        Q_1 = *Q & 1;        
        *Q = (((uint8_t)*Q) >> 1) | ((*A & 1) << 7);
        *A = *A >> 1;                        
    }
}
void ULA_DIV(int8_t *A, int8_t *Q, int8_t *M, int8_t *overflow) {
    if (*M == 0) {
        *A = 0;
        *Q = 0;
        *overflow = 1; 
    } else {
        int8_t dividendo = *Q;
        int8_t divisor = *M;
        int8_t quociente = dividendo / divisor;
        int8_t resto = dividendo % divisor;
        *Q = quociente;   
        *A = resto;       
        *overflow = 0;  
    }
}
