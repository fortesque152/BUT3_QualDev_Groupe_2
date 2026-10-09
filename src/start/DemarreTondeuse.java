package start;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;
import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;

import exceptions.DeplacementException;
import modele.Tondeuse;
import service.TondeuseManager;

public class DemarreTondeuse {

	public static void main(String[] args) {

		Tondeuse tondeuse1 =
				new Tondeuse(5, 5, 1, 2, NORTH);

		Tondeuse tondeuse2 =
				new Tondeuse(5, 5, 3, 3, EAST);

		TondeuseManager manager1 =
				new TondeuseManager(tondeuse1);

		TondeuseManager manager2 =
				new TondeuseManager(tondeuse2);

		try {

			// Déplacement de la tondeuse 1
			manager1.deplacement(G);
			manager1.deplacement(A);
			manager1.deplacement(G);
			manager1.deplacement(A);
			manager1.deplacement(G);
			manager1.deplacement(A);
			manager1.deplacement(G);
			manager1.deplacement(A);
			manager1.deplacement(A);

			System.out.println(tondeuse1);


			// Déplacement de la tondeuse 2
			manager2.deplacement(A);
			manager2.deplacement(A);
			manager2.deplacement(D);
			manager2.deplacement(A);
			manager2.deplacement(A);
			manager2.deplacement(D);
			manager2.deplacement(A);
			manager2.deplacement(D);
			manager2.deplacement(D);
			manager2.deplacement(A);

			System.out.println(tondeuse2);

		} catch (DeplacementException e) {
			System.out.println(e.getMessage());
		}
	}
}
