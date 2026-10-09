package service;

import static enumerations.EDirection.*;

import enumerations.EDeplacement;
import exceptions.DeplacementException;
import modele.Case;
import modele.Tondeuse;

public class TondeuseManager {

    private Tondeuse tondeuse;

    public TondeuseManager(Tondeuse tondeuse) {
        this.tondeuse = tondeuse;
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

        switch (tondeuse.getSens()) {

            case NORTH:
                tondeuse.setSens(EAST);
                break;

            case EAST:
                tondeuse.setSens(SOUTH);
                break;

            case SOUTH:
                tondeuse.setSens(WEST);
                break;

            case WEST:
                tondeuse.setSens(NORTH);
                break;
        }
    }

    private void deplacerAGauche() {

        switch (tondeuse.getSens()) {

            case NORTH:
                tondeuse.setSens(WEST);
                break;

            case WEST:
                tondeuse.setSens(SOUTH);
                break;

            case SOUTH:
                tondeuse.setSens(EAST);
                break;

            case EAST:
                tondeuse.setSens(NORTH);
                break;
        }
    }

    private void deplacerEnAvant()
            throws DeplacementException {

        int x = tondeuse.getCaseFinale().getX();
        int y = tondeuse.getCaseFinale().getY();

        switch (tondeuse.getSens()) {

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
                    tondeuse.getPelouse().getCase(x, y);

            tondeuse.setCaseFinale(nouvelleCase);

        } catch (Exception e) {

            throw new DeplacementException(
                    "Déplacement Impossible !");
        }
    }
}

