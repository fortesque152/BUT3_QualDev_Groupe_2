package modele;

import java.util.ArrayList;
import java.util.List;

public class Grille {

	// Une grille contient un ensemble de cases.
	private List<Case> cases;
	
	// Un tableau de 5 x 5 contient 36 éléments.
	public int getTaille( ) {
		return cases.size();
	}

	/*
	 * @return : La case de coordonnées x et y.
	 */
	public Case getCase(int x, int y) {
		return this.cases.get((x * cases.get(cases.size() - 1).getY()) + x + y);
	}

	public Grille(int lignes, int colonnes) {
		initGrille(lignes, colonnes);
	}

	/*
	 * Initialisation de la grille ...
	 */
	private void initGrille(int lignes, int colonnes) {
		cases = new ArrayList<>();
		for (int x = 0; x <= lignes; x++) {
			for (int y = 0; y <= colonnes; y++) {
				Case element = new Case(x, y);
				cases.add(element);
			}
		}
	}
}
