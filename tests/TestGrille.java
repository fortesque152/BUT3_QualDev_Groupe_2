import modele.Grille;
import modele.Robot;
import modele.Tondeuse;
import service.RobotManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;

import exceptions.DeplacementException;

public class TestGrille {

    private Grille grille;

    @Before
    public void setUp() {
        grille = new Grille(5, 5);
    }

    private void assertPosition(Robot r, int x, int y) {
        Assert.assertEquals(x, r.getCaseFinale().getX());
        Assert.assertEquals(y, r.getCaseFinale().getY());
    }

    @Test
    public void testNbCases() {
        Assert.assertEquals(36, grille.getTaille());
    }

    @Test
    public void testRobot1() throws DeplacementException {
        Robot robot = new Tondeuse(grille, 1, 2, NORTH);
        RobotManager manager = new RobotManager(robot);

        manager.deplacement(G);
        manager.deplacement(A);
        assertPosition(robot, 0, 2);

        manager.deplacement(G);
        manager.deplacement(A);
        assertPosition(robot, 0, 3);

        manager.deplacement(G);
        manager.deplacement(A);
        assertPosition(robot, 1, 3);

        manager.deplacement(G);
        manager.deplacement(A);
        assertPosition(robot, 1, 2);

        manager.deplacement(A);
        assertPosition(robot, 1, 1);
    }

    @Test
    public void testRobot2() throws DeplacementException {
        Robot robot = new Tondeuse(grille, 3, 3, EAST);
        RobotManager manager = new RobotManager(robot);

        manager.deplacement(A);
        assertPosition(robot, 4, 3);

        manager.deplacement(A);
        assertPosition(robot, 5, 3);

        manager.deplacement(D);
        manager.deplacement(A);
        assertPosition(robot, 5, 4);

        manager.deplacement(A);
        assertPosition(robot, 5, 5);

        manager.deplacement(D);
        manager.deplacement(A);
        assertPosition(robot, 4, 5);

        manager.deplacement(D);
        manager.deplacement(D);
        manager.deplacement(A);
        assertPosition(robot, 5, 5);
    }

    @Test(expected = DeplacementException.class)
    public void testSortieDeGrille() throws DeplacementException {
        Robot robot = new Tondeuse(grille, 1, 0, NORTH);
        new RobotManager(robot).deplacement(A); // y = -1
    }
}