#include <stdio.h>

void read_file() {
    FILE *f = fopen("data.txt", "r");
    if (!f) return;
    int x = fgetc(f);
    fclose(f);
}

int main() {
    read_file();
    // dummy comment for testing..............
    return 0;
}
