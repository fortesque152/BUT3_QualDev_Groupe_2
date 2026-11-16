package interfaces;

import enumerations.EDirection;
import modele.Case;
import modele.Grille;
import strategie.StrategieDeplacement;

/** Interface permettant de piloter le robot sans connaître son type concret. */
public interface IRobot {
    EDirection getSens();
    void setSens(EDirection sens);
    Case getCaseFinale();
    void setCaseFinale(Case caseFinale);
    Grille getGrille();
    StrategieDeplacement getStrategieDeplacement();
}
