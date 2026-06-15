package janv2026;

import java.util.Arrays;
import java.util.Random;

public class SAé2 {


    public static void main(String[] args) {
        // int[] données = générerDonnéesEntreBornes(50, 0, 20);
        // System.out.println(Arrays.toString(données));
        int[] données1 = générerDonnées(100000);
        Arrays.sort(données1);
        int[] données2 = générerDonnées(1000000);
        Arrays.sort(données2);
        int[] données3 = générerDonnées(10000000);
        Arrays.sort(données3);

        Arrays.sort(données3);

        for (int i = 0; i < données3.length; i++) {
            données3[i] = données3.length - i;
        }

        Arrays.sort(données3);


        int[] tab = générerDonnées(500000);
        triParInsertion(tab);
        //System.out.println(Arrays.toString(données));


        int[] tabAlenvers = générerTabTrieALenvers(100000);
        triParInsertion(tabAlenvers);

        int tTrie[] = générerTabTrie(10000000);

        long tempsDébut = System.nanoTime();

        int valeur = RecherheDichotomiePlusProche(tTrie, 8); // trie le tableau en utilisant un algorithme de type Quicksort

        long tempsFin = System.nanoTime();

        System.out.println(valeur);
        System.out.println("Durée entre avant et après exécution de la méthode enregistrée (en millisecondes) : " + ((tempsFin - tempsDébut) / 1000000));


        long tmpDébut = System.nanoTime();

        int val = RecherchePlusProche(données3, 8); // tableau non trié

        long tmpFin = System.nanoTime();

        System.out.println(val);
        System.out.println("Durée entre avant et après exécution de la méthode enregistrée (en millisecondes) : " + ((tmpFin - tmpDébut) / 1000000));
    }
    /*
        Retourne un tableau de int de la longueur demandée rempli avec des valeurs aléatoires
        (valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */
    public static int[] générerDonnées(int longueur) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(); // tirage aléatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
        return t;
    }
    /*
        Retourne un tableau de int de la longueur demandée rempli avec des valeurs aléatoires comprises entre min et max inclus.
    */
    public static int[] générerDonnéesEntreBornes(int longueur, int min, int max) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(max-min+1)+min; // nextInt(borne) retourne un int compris entre 0 inclus et borne exclus.
        return t;
    }

    public static void triParInsertion(int[] t) {
        for (int i = 1; i < t.length; i++) {
            int pivot = t[i];
            int j = i;

            while (j > 0 && t[j - 1] > pivot) {
                t[j] = t[j - 1];
                j--;
            }
            t[j] = pivot;
        }
    }

    public static int[] générerTabTrie(int longueur) {
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = i;
        return t;
    }

    public static int[] générerTabTrieALenvers(int longueur) {
        int[] t = new int[longueur];

        for (int i = 0; i < longueur; i++) {
            t[i] = longueur - 1 - i;
        }

        return t;
    }

    public static int RecherchePlusProche(int[] t, int val) {
        int proche = t[0];

        for (int i = 1; i < t.length; i++) {
            int distance = t[i] - val;
            if (distance < 0) distance = -distance; // valeur absolue manuelle

            int distanceProche = proche - val;
            if (distanceProche < 0) distanceProche = -distanceProche;

            if (distance < distanceProche) {
                proche = t[i];
            } else if (distance == distanceProche && t[i] > proche) {
                proche = t[i];
            }
        }

        return proche;
    }

    public static int RecherheDichotomiePlusProche(int[] tab, int val) {
        int debut = 0;
        int fin = tab.length - 1;


        if (val <= tab[debut]) {
            return tab[debut];
        }
        if (val >= tab[fin]) {
            return tab[fin];
        }


        while (debut <= fin) {
            int milieu = (debut + fin) / 2;

            if (tab[milieu] == val) {
                return tab[milieu];
            } else if (tab[milieu] < val) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }


        int valFin = tab[fin];
        int valDebut = tab[debut];


        int distFin = valFin - val;
        if (distFin < 0) {
            distFin = -distFin;
        }

        int distDebut = valDebut - val;
        if (distDebut < 0) {
            distDebut = -distDebut;
        }


        if (distDebut < distFin) {
            return valDebut;
        } else if (distFin < distDebut) {
            return valFin;
        } else {

            if (valDebut > valFin) {
                return valDebut;
            } else {
                return valFin;
            }
        }
    }
}