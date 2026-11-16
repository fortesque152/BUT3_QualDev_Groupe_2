package modele;

import enumerations.EDirection;
import enumerations.EModeDeplacement;
import interfaces.IRobot;
import strategie.DeplacementRapide;
import strategie.DeplacementStandard;
import strategie.StrategieDeplacement;

/** Robot tondeuse : son mode détermine sa stratégie de déplacement. */
public class Tondeuse implements IRobot {
    private Grille pelouse;
    private Case caseDepart;
    private Case caseFinale;
    private EDirection sens;
    private EModeDeplacement modeDeplacement;
    private StrategieDeplacement strategieDeplacement;

    /** Compatibilité avec le constructeur existant : mode STANDARD par défaut. */
    public Tondeuse(int lignes, int colonnes, int posX, int posY, EDirection sens) {
        this(lignes, colonnes, posX, posY, sens, EModeDeplacement.STANDARD);
    }

    public Tondeuse(int lignes, int colonnes, int posX, int posY,
                    EDirection sens, EModeDeplacement modeDeplacement) {
        this.pelouse = new Grille(lignes, colonnes);
        this.caseDepart = pelouse.getCase(posX, posY);
        this.caseFinale = caseDepart;
        setSens(sens);
        setModeDeplacement(modeDeplacement);
    }

    public EModeDeplacement getModeDeplacement() {
        return modeDeplacement;
    }

    /** Changement de stratégie possible à tout moment pour chaque robot. */
    public void setModeDeplacement(EModeDeplacement modeDeplacement) {
        if (modeDeplacement == null) {
            throw new IllegalArgumentException("Le mode de déplacement ne peut pas être null");
        }
        this.modeDeplacement = modeDeplacement;
        switch (modeDeplacement) {
            case STANDARD:
                this.strategieDeplacement = new DeplacementStandard();
                break;
            case RAPIDE:
                this.strategieDeplacement = new DeplacementRapide();
                break;
            default:
                throw new IllegalArgumentException("Mode inconnu : " + modeDeplacement);
        }
    }

    @Override
    public StrategieDeplacement getStrategieDeplacement() {
        return strategieDeplacement;
    }

    @Override public Case getCaseFinale() { return caseFinale; }
    @Override public EDirection getSens() { return sens; }
    @Override public void setSens(EDirection sens) { this.sens = sens; }
    @Override public void setCaseFinale(Case caseFinale) { this.caseFinale = caseFinale; }
    @Override public Grille getGrille() { return pelouse; }
    public void setPelouse(Grille pelouse) { this.pelouse = pelouse; }
    public Case getCaseDepart() { return caseDepart; }

    @Override
    public String toString() {
        return "Ma position finale est X = " + caseFinale.getX()
                + ", Y = " + caseFinale.getY()
                + " et je suis orientée : " + sens;
    }
}
