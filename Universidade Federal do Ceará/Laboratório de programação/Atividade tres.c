#include <stdio.h>

int main() {

    int n = 7;
    int *ponteiro = &n;


    printf("%p\n", &n);
    printf("%d\n", n);
    printf("%p\n", &ponteiro);
    printf("%d\n", *ponteiro);
    printf("%p\n", &*ponteiro);



    return 0;
}
