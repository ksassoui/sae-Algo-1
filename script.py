import time

def TriparInsertion(t):
    for i in range(1, len(t)):
        pivot = t[i]
        j = i
        while j > 0 and t[j - 1] > pivot:
            t[j] = t[j - 1]
            j -= 1
        t[j] = pivot

def GenererTabTrie(longueur):
    t = []
    for i in range(longueur):
        t.append(longueur - 1 - i)
    return t

439808400



if __name__ == "__main__":
    longueur = 100000
    donnees = GenererTabTrie(longueur)

    start = time.time()
    TriparInsertion(donnees)
    end = time.time()

    print("Temps d'exécution :", (end - start), "secondes")