#include <stdio.h>
/* 1-  EXEMPLO: Crie uma struct para representar uma pessoa que ira ser cadastrado em um sistema de academia.
Dados necessarios:  matricula, idade, peso, altura */
struct Pessoa {
    long matricula;
    int idade;
    float peso;
    float altura;
};
/* 2 - Crie uma struct para representar um produto que ira ser cadastrado em um sistema de supermecado.
Dados necessarios: codigo de barra, preco, dia, mes e ano de validade
Dica separe o dia, o mes e o ano em 3 variaveis*/
struct Produto {
    long ean;
    float preco;
    int diavalidade;
    int mesvalidade;
    int anovalidade;
};
/*3 - Crie uma struct para representar um aluno da disciplina de ED que ira ser cadastrado em um sistema no sigaa
Dados necessarios: matricula, nota da avaliacao teorica, nota do trabalho de ordenacao, nota dos exercicios praticos*/
struct AlunoED {
    int matricula;
    float notaavaliacateorica;
    float notatrabalhoordenacao;
    float notaexerciciospraticos;
};

int main() {

    struct Produto produto;

    produto.ean = 1234567890123; 
    produto.preco = 29.99;
    produto.diavalidade = 15;
    produto.mesvalidade = 10;
    produto.anovalidade = 2025;

    printf("========================================\n");
    printf("TESTE das Structs:\n");
    printf("========================================\n");
    printf("Struct Produto:\n");
    printf("EAN: %ld\n", produto.ean);
    printf("Preço: %.2f\n", produto.preco);
    printf("Data de Validade: %02d/%02d/%d\n", produto.diavalidade, produto.mesvalidade, produto.anovalidade);
    printf("========================================\n");
    printf("Struct Pessoa:\n");
    
    struct Pessoa pessoa;

    pessoa.matricula = 2324234;
    pessoa.idade = 23;
    pessoa.peso = 75.40;
    pessoa.altura = 1.70;

    printf("Matricula: %ld\n", pessoa.matricula); 
    printf("Idade: %d\n", pessoa.idade); 
    printf("Peso: %.2f\n", pessoa.peso);
    printf("Altura: %.2f\n", pessoa.altura);
    printf("========================================\n");
    printf("Struct Disciplina de ED:\n");

    struct AlunoED alunoed;

    alunoed.matricula = 52419;
    alunoed.notaavaliacateorica = 7.8;
    alunoed.notatrabalhoordenacao = 8.9;
    alunoed.notaexerciciospraticos = 3.1;

    printf("Matricula: %d\n", alunoed.matricula); 
    printf("Nota da avaliação teórica: %.2f\n", alunoed.notaavaliacateorica); 
    printf("Nota do trabalho de ordenação: %.2f\n", alunoed.notatrabalhoordenacao); 
    printf("Nota dos exercicios praticos: %.2f\n", alunoed.notaexerciciospraticos);
    printf("========================================\n");
    
    return 0;
}
