package start;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;
import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;

import modele.Tondeuse;

public class DemarreTondeuse {

	public static void main(String[] args) {
		// Attention n'est pas SOLID (SRP).
		// TODO : Faire une classe manager qui encapsule les concepts de SOLID.
		Tondeuse tondeuse1 = new Tondeuse(5, 5, 1, 2, NORTH);
		Tondeuse tondeuse2 = new Tondeuse(5, 5, 3, 3, EAST);
		try {
			// TODO : Lire un fichier qui contient la séquence et qui l'exécute.
			tondeuse1.deplacement(G);
			tondeuse1.deplacement(A);
			tondeuse1.deplacement(G);
			tondeuse1.deplacement(A);
			tondeuse1.deplacement(G);
			tondeuse1.deplacement(A);
			tondeuse1.deplacement(G);
			tondeuse1.deplacement(A);
			tondeuse1.deplacement(A);
			System.out.println(tondeuse1.toString());
			tondeuse2.deplacement(A);
			tondeuse2.deplacement(A);
			tondeuse2.deplacement(D);
			tondeuse2.deplacement(A);
			tondeuse2.deplacement(A);
			tondeuse2.deplacement(D);
			tondeuse2.deplacement(A);
			tondeuse2.deplacement(D);
			tondeuse2.deplacement(D);
			tondeuse2.deplacement(A);
			System.out.println(tondeuse2.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
