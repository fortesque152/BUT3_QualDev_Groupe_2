package service;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;
import modele.Robot;

public class RobotManager {

    private final Robot robot;

    public RobotManager(Robot robot) {
        this.robot = robot;
    }

    public void deplacement(EDeplacement deplacement) throws DeplacementException {
        switch (deplacement) {
            case A -> deplacerEnAvant();
            case D -> robot.setSens(robot.getSens().droite());
            case G -> robot.setSens(robot.getSens().gauche());
        }
    }

    private void deplacerEnAvant() throws DeplacementException {
        EDirection sens = robot.getSens();
        int x = robot.getCaseFinale().getX() + sens.getX();
        int y = robot.getCaseFinale().getY() + sens.getY();

        try {
            robot.setCaseFinale(robot.getPelouse().getCase(x, y));
        } catch (IndexOutOfBoundsException e) {
            throw new DeplacementException("Déplacement Impossible !");
        }
    }
}