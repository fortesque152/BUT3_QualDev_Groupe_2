package start;

import enumerations.EModeDeplacement;
import exceptions.DeplacementException;
import modele.Tondeuse;
import service.RobotManager;

import static enumerations.EDeplacement.*;
import static enumerations.EDirection.*;

/** Démonstration de deux stratégies sur une même interface RobotManager. */
public class DemarreTondeuse {
    public static void main(String[] args) throws DeplacementException {
        Tondeuse standard = new Tondeuse(5, 5, 1, 2, NORTH);
        Tondeuse rapide = new Tondeuse(5, 5, 1, 2, NORTH, EModeDeplacement.RAPIDE);
        RobotManager managerStandard = new RobotManager(standard);
        RobotManager managerRapide = new RobotManager(rapide);

        managerStandard.deplacement(A);
        managerRapide.deplacement(A);
        System.out.println("Standard : " + standard);
        System.out.println("Rapide   : " + rapide);

        rapide.setModeDeplacement(EModeDeplacement.STANDARD);
        managerRapide.deplacement(D);
        managerRapide.deplacement(A);
        System.out.println("Rapide après changement de stratégie : " + rapide);
    }
}
