#include <stdio.h>

void process(int condition) {
    FILE *f = fopen("data.txt", "r");
    if (!f) return;
    if (condition) {
        return;  // leak! forgot to close
    }
    fclose(f);
}

int main() {
    process(1);
    return 0;
}
