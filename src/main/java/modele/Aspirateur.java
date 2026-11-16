package modele;

import enumerations.EDirection;
import interfaces.IRobot;
import strategie.StrategieDeplacement;

/**
 * fdfsfdsf
 */
public class Aspirateur implements IRobot {
    @Override
    public EDirection getSens() {
        return null;
    }

    @Override
    public void setSens(EDirection sens) {

    }

    @Override
    public Case getCaseFinale() {
        return new Case(1,2);
    }

    @Override
    public void setCaseFinale(Case caseFinale) {

    }

    @Override
    public Grille getGrille() {
        return null;
    }

    @Override
    public StrategieDeplacement getStrategieDeplacement() {
        return null;
    }
}
