package modele;

import enumerations.EDirection;
import interfaces.IRobot;

/***
 * Attention n'est pas SOLID (SRP).
 * A créer une classe manager.
 * @author stephane.joyeux
 *
 */

public abstract class Robot implements IRobot {

	private final Grille pelouse;
	private final Case caseDepart;
	private Case caseFinale;
	private EDirection sens;

	protected Robot(Grille pelouse, int posX, int posY, EDirection sens) {
		this.pelouse = pelouse;
		this.caseDepart = pelouse.getCase(posX, posY);
		this.caseFinale = this.caseDepart;
		this.sens = sens;
	}

	public Grille getPelouse()      { return pelouse; }
	public Case getCaseDepart()     { return caseDepart; }
	public Case getCaseFinale()     { return caseFinale; }
	public EDirection getSens()     { return sens; }
	public void setSens(EDirection sens)        { this.sens = sens; }
	public void setCaseFinale(Case caseFinale)  { this.caseFinale = caseFinale; }

	@Override
	public String toString() {
		return "Position finale : X = " + caseFinale.getX()
				+ ", Y = " + caseFinale.getY() + ", orientation : " + sens;
	}
}