import modele.Grille;
import modele.Tondeuse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;
import static enumerations.EDirection.SOUTH;
import static enumerations.EDirection.WEST;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;



public class TestGrille {
    private Grille grille;

    @Before
    public void setUp() {
        //Initialise une grille
        this.grille = new Grille (5, 5);


    }

    @Test
    public void testVerifieNbCase(){
        Assert.assertEquals(36,grille.getTaille());
    }

    @Test
    public void testDeplacement(){
        Tondeuse tondeuse1 = new Tondeuse(5, 5, 1, 2, NORTH);
        try {
            tondeuse1.deplacement(G);
            tondeuse1.deplacement(A);
            Assert.assertEquals(0, tondeuse1.getCaseFinale().getX());
            Assert.assertEquals(2, tondeuse1.getCaseFinale().getY());
            tondeuse1.deplacement(G);
            tondeuse1.deplacement(A);
            Assert.assertEquals(0, tondeuse1.getCaseFinale().getX());
            Assert.assertEquals(3, tondeuse1.getCaseFinale().getY());
            tondeuse1.deplacement(G);
            tondeuse1.deplacement(A);
            Assert.assertEquals(1, tondeuse1.getCaseFinale().getX());
            Assert.assertEquals(3, tondeuse1.getCaseFinale().getY());
            tondeuse1.deplacement(G);
            tondeuse1.deplacement(A);
            Assert.assertEquals(1, tondeuse1.getCaseFinale().getX());
            Assert.assertEquals(2, tondeuse1.getCaseFinale().getY());
            tondeuse1.deplacement(A);
            Assert.assertEquals(1, tondeuse1.getCaseFinale().getX());
            Assert.assertEquals(1, tondeuse1.getCaseFinale().getY());

        } catch (DeplacementException e) {
            throw new RuntimeException(e);
        }

    }

}
