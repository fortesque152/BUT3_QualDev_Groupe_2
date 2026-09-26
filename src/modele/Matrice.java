package modele;

import java.util.ArrayList;
import java.util.List;

public class Matrice {
    private int nb_lignes;
    private int nb_colonnes;

    private List<Case> cases;

    public Matrice(int nb_lignes, int nb_colonnes) {
        this.nb_lignes = nb_lignes;
        this.nb_colonnes = nb_colonnes;
        this.cases = new ArrayList<>();
        initialiserCases();
    }

    private void initialiserCases() {
        cases.clear();

        for (int x = 0; x < nb_lignes; x++) {
            for (int y = 0; y < nb_colonnes; y++) {
                cases.add(new Case(x, y));
            }
        }
    }

    // Méthode pour vérifier que la matrice est correctement initialisée
    public boolean verifierMatrice() {
        // Vérifie que le nombre de cases est correct
        // et que chaque case a les bonnes coordonnées
        if (cases.size() != nb_lignes * nb_colonnes) {
            return false;
        }

        for (int x = 0; x < nb_lignes; x++) {
            for (int y = 0; y < nb_colonnes; y++) {
                boolean caseTrouvee = false;
                for (Case c : cases) {
                    if (c.getX() == x && c.getY() == y) {
                        caseTrouvee = true;
                        break;
                    }
                }
                if (!caseTrouvee) {
                    return false;
                }
            }
        }
        return true;
    }

}
