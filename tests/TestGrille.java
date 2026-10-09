import modele.Grille;
import modele.Tondeuse;
import service.TondeuseManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static enumerations.EDirection.NORTH;
import static enumerations.EDirection.EAST;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;

import exceptions.DeplacementException;

public class TestGrille {

    private Grille grille;

    @Before
    public void setUp() {
        this.grille = new Grille(5, 5);
    }

    @Test
    public void testVerifieNbCase() {
        Assert.assertEquals(36, grille.getTaille());
    }

    @Test
    public void testDeplacement() {

        Tondeuse tondeuse1 =
                new Tondeuse(5, 5, 1, 2, NORTH);

        TondeuseManager manager1 =
                new TondeuseManager(tondeuse1);

        Tondeuse tondeuse2 =
                new Tondeuse(5, 5, 3, 3, EAST);

        TondeuseManager manager2 =
                new TondeuseManager(tondeuse2);

        try {

            // Tondeuse 1

            manager1.deplacement(G);
            manager1.deplacement(A);

            Assert.assertEquals(
                    0,
                    tondeuse1.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    2,
                    tondeuse1.getCaseFinale().getY()
            );

            manager1.deplacement(G);
            manager1.deplacement(A);

            Assert.assertEquals(
                    0,
                    tondeuse1.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    3,
                    tondeuse1.getCaseFinale().getY()
            );

            manager1.deplacement(G);
            manager1.deplacement(A);

            Assert.assertEquals(
                    1,
                    tondeuse1.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    3,
                    tondeuse1.getCaseFinale().getY()
            );

            manager1.deplacement(G);
            manager1.deplacement(A);

            Assert.assertEquals(
                    1,
                    tondeuse1.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    2,
                    tondeuse1.getCaseFinale().getY()
            );

            manager1.deplacement(A);

            Assert.assertEquals(
                    1,
                    tondeuse1.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    1,
                    tondeuse1.getCaseFinale().getY()
            );


            // Tondeuse 2

            manager2.deplacement(A);

            Assert.assertEquals(
                    4,
                    tondeuse2.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    3,
                    tondeuse2.getCaseFinale().getY()
            );

            manager2.deplacement(A);

            Assert.assertEquals(
                    5,
                    tondeuse2.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    3,
                    tondeuse2.getCaseFinale().getY()
            );

            manager2.deplacement(D);
            manager2.deplacement(A);

            Assert.assertEquals(
                    5,
                    tondeuse2.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    4,
                    tondeuse2.getCaseFinale().getY()
            );

            manager2.deplacement(A);

            Assert.assertEquals(
                    5,
                    tondeuse2.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    5,
                    tondeuse2.getCaseFinale().getY()
            );

            manager2.deplacement(D);
            manager2.deplacement(A);

            Assert.assertEquals(
                    4,
                    tondeuse2.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    5,
                    tondeuse2.getCaseFinale().getY()
            );

            manager2.deplacement(D);
            manager2.deplacement(D);
            manager2.deplacement(A);

            Assert.assertEquals(
                    5,
                    tondeuse2.getCaseFinale().getX()
            );

            Assert.assertEquals(
                    5,
                    tondeuse2.getCaseFinale().getY()
            );

        } catch (DeplacementException e) {
            throw new RuntimeException(e);
        }
    }
}
