package modele;

import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;
import static enumerations.EDirection.SOUTH;
import static enumerations.EDirection.WEST;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;

/***
 * Attention n'est pas SOLID (SRP).
 * A créer une classe manager.
 * @author stephane.joyeux
 *
 */
public class Tondeuse {

	// Une tondeuse se déplace sur une pelouse.
	private Grille pelouse;

	// Départ de la tondeuse :
	private Case caseDepart;

	// Arrivée :
	private Case caseFinale;

	// Sens de la tondeuse :
	private EDirection sens;

	public Case getCaseFinale() {
		return caseFinale;
	}

	public Case getCaseDepart() {
		return caseDepart;
	}

	public EDirection getSens() {
		return sens;
	}

	public void setSens(EDirection sens) { this.sens = sens; } public void setCaseFinale(Case caseFinale) { this.caseFinale = caseFinale; } public Grille getPelouse() { return pelouse; }

	public Tondeuse(int lignes, int colonnes, int posX, int posY, EDirection sens) {
		this.pelouse = new Grille(lignes, colonnes);
		this.caseDepart = this.pelouse.getCase(posX, posY);
		this.caseFinale = this.pelouse.getCase(posX, posY);
		this.sens = sens;
	}



	@Override
	public String toString() {
		return "Ma position finale est X = " + this.getCaseFinale().getX() + ", Y = " + this.getCaseFinale().getY()
				+ " et je suis orientée : " + this.sens;
	}
}
