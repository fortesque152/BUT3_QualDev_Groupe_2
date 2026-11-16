package strategie;

import enumerations.EDeplacement;
import exceptions.DeplacementException;
import interfaces.IRobot;

/** Contrat Strategy : exécute une commande sur le robot. */
public interface StrategieDeplacement {
    void deplacer(IRobot robot, EDeplacement commande) throws DeplacementException;
}
