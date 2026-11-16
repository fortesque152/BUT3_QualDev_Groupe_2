package service;

import enumerations.EDeplacement;
import exceptions.DeplacementException;
import interfaces.IRobot;

/** Contexte du pattern Strategy : délègue le déplacement au robot. */
public class RobotManager {
    private final IRobot robot;

    public RobotManager(IRobot robot) {
        if (robot == null) {
            throw new IllegalArgumentException("Un robot est obligatoire");
        }
        this.robot = robot;
    }

    public void deplacement(EDeplacement commande) throws DeplacementException {
        robot.getStrategieDeplacement().deplacer(robot, commande);
    }

}
