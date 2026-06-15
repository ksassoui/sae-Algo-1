package janv2026;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class SAé2Test {

    @Test
    public void testTriParInsertionCasDivers() {
        // Cas 1 : tableau déjà trié
        int[] tabTrie = SAé2.générerTabTrie(10);
        int[] attenduTrie = {0,1,2,3,4,5,6,7,8,9};
        SAé2.triParInsertion(tabTrie);
        assertArrayEquals(attenduTrie, tabTrie);

        // Cas 2 : tableau vide
        int[] tabVide = SAé2.générerTabTrie(0);
        int[] attenduVide = {};
        SAé2.triParInsertion(tabVide);
        assertArrayEquals(attenduVide, tabVide);

        // Cas 3 : tableau en désordre partiel
        int[] tabDesordre = {5, -1, 3, 0, 2, 7, 6, 9, 1, 4};
        int[] attenduDesordre = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 9 };
        SAé2.triParInsertion(tabDesordre);
        assertArrayEquals(attenduDesordre, tabDesordre);

        // Cas 4 : tableau trié à l’envers
        int[] tabInverse = SAé2.générerTabTrieALenvers(10);
        int[] attenduInverse = {0,1,2,3,4,5,6,7,8,9};
        SAé2.triParInsertion(tabInverse);
        assertArrayEquals(attenduInverse, tabInverse);

        // Cas 5 : tableau aléatoire
        int[] tabAleatoire = SAé2.générerDonnées(10);
        int[] attendu = Arrays.copyOf(tabAleatoire, tabAleatoire.length);
        Arrays.sort(attendu); // version correcte
        SAé2.triParInsertion(tabAleatoire);
        assertArrayEquals(attendu, tabAleatoire);

    }

    @Test
    public void testTableauRecherchePlusProche() {
        int[] t = {12, 1, 8, 6, 18, 9};

        assertEquals(8, SAé2.RecherchePlusProche(t, 8));
        assertEquals(8, SAé2.RecherchePlusProche(t, 7));   // égalité : 6 et 8 → on prend 8
        assertEquals(12, SAé2.RecherchePlusProche(t, 14));
        assertEquals(1, SAé2.RecherchePlusProche(t, -999));
        assertEquals(18, SAé2.RecherchePlusProche(t, 999));
    }

    @Test
    public void testRecherheDichotomiePlusProche() {
        int[] tTri = {1, 6, 8, 9, 12, 18};

        assertEquals(8, SAé2.RecherheDichotomiePlusProche(tTri, 8));
        assertEquals(8, SAé2.RecherheDichotomiePlusProche(tTri, 7));
        assertEquals(12, SAé2.RecherheDichotomiePlusProche(tTri, 14));
        assertEquals(1, SAé2.RecherheDichotomiePlusProche(tTri, -999));
        assertEquals(18, SAé2.RecherheDichotomiePlusProche(tTri, 999));
    }


}
