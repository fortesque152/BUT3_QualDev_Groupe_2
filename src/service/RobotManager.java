package service;

import static enumerations.EDirection.*;

import enumerations.EDeplacement;
import exceptions.DeplacementException;
import modele.Case;
import modele.Robot;

public class RobotManager {

    private Robot robot;

    public RobotManager(Robot robot) {
        this.robot = robot;
    }

    public void deplacement(EDeplacement deplacement)
            throws DeplacementException {

        switch (deplacement) {

            case A:
                deplacerEnAvant();
                break;

            case D:
                deplacerADroite();
                break;

            case G:
                deplacerAGauche();
                break;

            default:
                break;
        }
    }

    private void deplacerADroite() {

        switch (robot.getSens()) {

            case NORTH:
                robot.setSens(EAST);
                break;

            case EAST:
                robot.setSens(SOUTH);
                break;

            case SOUTH:
                robot.setSens(WEST);
                break;

            case WEST:
                robot.setSens(NORTH);
                break;
        }
    }

    private void deplacerAGauche() {

        switch (robot.getSens()) {

            case NORTH:
                robot.setSens(WEST);
                break;

            case WEST:
                robot.setSens(SOUTH);
                break;

            case SOUTH:
                robot.setSens(EAST);
                break;

            case EAST:
                robot.setSens(NORTH);
                break;
        }
    }

    private void deplacerEnAvant()
            throws DeplacementException {

        int x = robot.getCaseFinale().getX();
        int y = robot.getCaseFinale().getY();

        switch (robot.getSens()) {

            case NORTH:
                y--;
                break;

            case EAST:
                x++;
                break;

            case SOUTH:
                y++;
                break;

            case WEST:
                x--;
                break;
        }

        try {

            Case nouvelleCase =
                    robot.getPelouse().getCase(x, y);

            robot.setCaseFinale(nouvelleCase);

        } catch (Exception e) {

            throw new DeplacementException(
                    "Déplacement Impossible !");
        }
    }
}

