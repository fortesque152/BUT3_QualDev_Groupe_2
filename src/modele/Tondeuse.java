package modele;

import enumerations.EDirection;

public class Tondeuse extends Robot {
    public Tondeuse(Grille g, int x, int y, EDirection sens) {
        super(g, x, y, sens);
    }
}