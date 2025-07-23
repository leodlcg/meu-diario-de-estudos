#include <stdio.h>

int main() {

    int v[5] = {1,2,3,4,5};
    int *Ponteiroum = &v[0];
    int *Ponteirodois = &v[4];

for(int i = 0; i < 5; i++){
    if(*Ponteiroum > *Ponteirodois){
        printf("%d", *Ponteiroum);
        Ponteiroum++;
    }else{
        printf("%d", *Ponteirodois);
        Ponteirodois--;
    }
}

    return 0;
}
