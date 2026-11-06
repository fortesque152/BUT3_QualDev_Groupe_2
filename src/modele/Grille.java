package modele;

import java.util.ArrayList;
import java.util.List;

public class Grille {

	private final int lignes;
	private final int colonnes;
	private final List<Case> cases = new ArrayList<>();

	public Grille(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		initGrille();
	}

	// Une grille 5 x 5 contient 36 cases (coordonnées de 0 à 5).
	public int getTaille() {
		return cases.size();
	}

	public Case getCase(int x, int y) {
		if (x < 0 || x > lignes || y < 0 || y > colonnes) {
			throw new IndexOutOfBoundsException("Hors grille : " + x + "," + y);
		}
		return cases.get(x * (colonnes + 1) + y);
	}

	private void initGrille() {
		for (int x = 0; x <= lignes; x++) {
			for (int y = 0; y <= colonnes; y++) {
				cases.add(new Case(x, y));
			}
		}
	}
}