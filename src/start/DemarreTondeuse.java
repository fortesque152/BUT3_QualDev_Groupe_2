package start;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;
import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;

import exceptions.DeplacementException;
import modele.Grille;
import modele.Robot;
import modele.Tondeuse;
import service.RobotManager;

public class DemarreTondeuse {

	public static void main(String[] args) {

		Grille grille = new Grille(5, 5);

		Robot robot1 = new Tondeuse(grille, 1, 2, NORTH);
		Robot robot2 = new Tondeuse(grille, 3, 3, EAST);

		RobotManager manager1 = new RobotManager(robot1);
		RobotManager manager2 = new RobotManager(robot2);

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

			System.out.println(robot1);

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

			System.out.println(robot2);

		} catch (DeplacementException e) {
			System.out.println(e.getMessage());
		}
	}
}