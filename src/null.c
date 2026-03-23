#include <stdlib.h>

int main() {
    int *p = malloc(sizeof(int));
    // free(p);
    return *p; // use-after-free
}
