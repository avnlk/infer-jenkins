#include <stdio.h>

void read_file() {
    FILE *f = fopen("data.txt", "r");
    if (!f) return;
    // forgot to fclose(f) — resource leak
    int x = fgetc(f);
}

int main() {
    read_file();
    // dummy comment for testing....
    return 0;
}
