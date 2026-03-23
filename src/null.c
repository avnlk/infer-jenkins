#include <stdlib.h>

int main() {
    int *p = malloc(sizeof(int));
    p = 7;
    // free(p);
    return *p; // use-after-free
}
