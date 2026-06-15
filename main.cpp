#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void genererTabTrieALenvers(int t[], int longueur) {
    for (int i = 0; i < longueur; i++) {
        t[i] = longueur - 1 - i;
    }
}
void triParInsertion(int t[], int longueur) {
    for (int i = 1; i < longueur; i++) {
        int pivot = t[i];
        int j = i;
        while (j > 0 && t[j - 1] > pivot) {
            t[j] = t[j - 1];
            j--;
        }
        t[j] = pivot;
    }
}
int main() {
    int taille = 100000;
    static int monTableau[100000];


    genererTabTrieALenvers(monTableau, taille);

    clock_t debut = clock();

    triParInsertion(monTableau, taille);

    clock_t fin = clock();


    double temps_sec = (double)(fin - debut) / CLOCKS_PER_SEC;

    printf("Temps d'execution : %.2f secondes", temps_sec);

    return 0;
}
