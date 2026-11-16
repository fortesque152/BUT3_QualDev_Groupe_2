package modele;

import enumerations.EModeDeplacement;
import exceptions.DeplacementException;
import org.junit.Test;
import service.RobotManager;
import strategie.DeplacementRapide;
import strategie.DeplacementStandard;

import static enumerations.EDeplacement.*;
import static enumerations.EDirection.*;
import static org.junit.Assert.*;

public class TestTondeuse {
    @Test
    public void testDeplacementTondeuse() throws DeplacementException {
        Tondeuse tondeuse = new Tondeuse(5, 5, 1, 2, NORTH);
        RobotManager manager = new RobotManager(tondeuse);
        for (enumerations.EDeplacement commande : new enumerations.EDeplacement[]{G,A,G,A,G,A,G,A,A}) {
            manager.deplacement(commande);
        }
        assertPosition(tondeuse, 1, 1, NORTH);
        assertEquals(EModeDeplacement.STANDARD, tondeuse.getModeDeplacement());
        assertTrue(tondeuse.getStrategieDeplacement() instanceof DeplacementStandard);
    }

    @Test
    public void testUnAutreDeplacementTondeuse() throws DeplacementException {
        Tondeuse tondeuse = new Tondeuse(5, 5, 3, 3, EAST);
        RobotManager manager = new RobotManager(tondeuse);
        for (enumerations.EDeplacement commande : new enumerations.EDeplacement[]{A,A,D,A,A,D,A,D,D,A}) {
            manager.deplacement(commande);
        }
        assertPosition(tondeuse, 5, 5, EAST);
    }

    @Test
    public void testStrategiesProduisentDesDistancesDifferentes() throws DeplacementException {
        Tondeuse standard = new Tondeuse(5, 5, 1, 3, EAST, EModeDeplacement.STANDARD);
        Tondeuse rapide = new Tondeuse(5, 5, 1, 3, EAST, EModeDeplacement.RAPIDE);
        new RobotManager(standard).deplacement(A);
        new RobotManager(rapide).deplacement(A);
        assertPosition(standard, 2, 3, EAST);
        assertPosition(rapide, 3, 3, EAST);
        assertTrue(rapide.getStrategieDeplacement() instanceof DeplacementRapide);
    }

    @Test
    public void testChangementStrategiePendantExecution() throws DeplacementException {
        Tondeuse tondeuse = new Tondeuse(5, 5, 0, 1, EAST);
        RobotManager manager = new RobotManager(tondeuse);
        manager.deplacement(A);
        assertPosition(tondeuse, 1, 1, EAST);
        tondeuse.setModeDeplacement(EModeDeplacement.RAPIDE);
        manager.deplacement(A);
        assertPosition(tondeuse, 3, 1, EAST);
        tondeuse.setModeDeplacement(EModeDeplacement.STANDARD);
        manager.deplacement(A);
        assertPosition(tondeuse, 4, 1, EAST);
    }

    @Test
    public void testRotationsIdentiquesPourDeuxStrategies() throws DeplacementException {
        for (EModeDeplacement mode : EModeDeplacement.values()) {
            Tondeuse tondeuse = new Tondeuse(5, 5, 2, 2, NORTH, mode);
            RobotManager manager = new RobotManager(tondeuse);
            manager.deplacement(D);
            assertEquals(EAST, tondeuse.getSens());
            manager.deplacement(G);
            assertEquals(NORTH, tondeuse.getSens());
            manager.deplacement(G);
            assertEquals(WEST, tondeuse.getSens());
            manager.deplacement(D);
            assertPosition(tondeuse, 2, 2, NORTH);
        }
    }

    @Test
    public void testSortieGrilleNeModifiePasPosition() throws DeplacementException {
        for (EModeDeplacement mode : EModeDeplacement.values()) {
            Tondeuse tondeuse = new Tondeuse(5, 5, 0, 0, WEST, mode);
            try {
                new RobotManager(tondeuse).deplacement(A);
                fail("Une exception était attendue pour " + mode);
            } catch (DeplacementException attendue) {
                assertPosition(tondeuse, 0, 0, WEST);
            }
        }
    }

    @Test
    public void testDepassementAvecModeRapideNeModifiePasPosition() {
        Tondeuse tondeuse = new Tondeuse(5, 5, 4, 2, EAST, EModeDeplacement.RAPIDE);
        try {
            new RobotManager(tondeuse).deplacement(A);
            fail("Le déplacement de deux cases devrait sortir de la grille");
        } catch (DeplacementException attendue) {
            assertPosition(tondeuse, 4, 2, EAST);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testModeNullInterdit() {
        new Tondeuse(5, 5, 1, 1, NORTH, null);
    }

    private static void assertPosition(Tondeuse robot, int x, int y, enumerations.EDirection direction) {
        assertEquals(x, robot.getCaseFinale().getX());
        assertEquals(y, robot.getCaseFinale().getY());
        assertEquals(direction, robot.getSens());
    }
}
