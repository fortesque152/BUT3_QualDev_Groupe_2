package strategie;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;
import interfaces.IRobot;

/** Déplacement historique : avancer d'une case, pivoter de 90 degrés. */
public class DeplacementStandard implements StrategieDeplacement {

    @Override
    public void deplacer(IRobot robot, EDeplacement commande) throws DeplacementException {
        if (robot == null || commande == null) {
            throw new IllegalArgumentException("Le robot et la commande sont obligatoires");
        }
        switch (commande) {
            case A:
                avancer(robot, nombreCasesParAvance());
                break;
            case D:
                tourner(robot, 1);
                break;
            case G:
                tourner(robot, -1);
                break;
            default:
                throw new IllegalArgumentException("Commande inconnue : " + commande);
        }
    }

    /** Point d'extension permettant à une stratégie de changer la distance. */
    protected int nombreCasesParAvance() {
        return 1;
    }

    private void tourner(IRobot robot, int sensRotation) {
        // Ordre horaire : N, E, S, W.
        EDirection[] directions = {EDirection.NORTH, EDirection.EAST,
                EDirection.SOUTH, EDirection.WEST};
        int index = -1;
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == robot.getSens()) {
                index = i;
                break;
            }
        }
        if (index < 0) {
            throw new IllegalArgumentException("Orientation du robot invalide");
        }
        robot.setSens(directions[(index + sensRotation + directions.length) % directions.length]);
    }

    private void avancer(IRobot robot, int distance) throws DeplacementException {
        int x = robot.getCaseFinale().getX();
        int y = robot.getCaseFinale().getY();
        if (robot.getSens() == null) {
            throw new IllegalArgumentException("Orientation du robot absente");
        }
        switch (robot.getSens()) {
            case NORTH: y -= distance; break;
            case EAST:  x += distance; break;
            case WEST:  x -= distance; break;
            case SOUTH: y += distance; break;
            default: throw new IllegalArgumentException("Orientation inconnue");
        }
        try {
            // Si la destination est hors grille, la position reste inchangée.
            robot.setCaseFinale(robot.getGrille().getCase(x, y));
        } catch (IndexOutOfBoundsException e) {
            throw new DeplacementException("Déplacement Impossible !");
        }
    }
}
