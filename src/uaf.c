#include <stdlib.h>

int* create() {
    int *p = malloc(sizeof(int));
    return p;
}

void destroy(int *p) {
    free(p);
}

void use(int *p) {
    *p = 42;  // use after free if called after destroy
}

int main() {
    int *p = create();
    destroy(p);
    use(p);  // Infer catches this, SonarQube cannot
    return 0;
}
