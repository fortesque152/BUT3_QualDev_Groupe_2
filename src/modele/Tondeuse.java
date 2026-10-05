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

	public Tondeuse(int lignes, int colonnes, int posX, int posY, EDirection sens) {
		this.pelouse = new Grille(lignes, colonnes);
		this.caseDepart = this.pelouse.getCase(posX, posY);
		this.caseFinale = this.pelouse.getCase(posX, posY);
		this.sens = sens;
	}

	public void deplacement(EDeplacement deplacement) throws DeplacementException {
		switch (deplacement) {
		case A:
			deplacerEnAvant();
			break;
		case D:
			deplacerADroite();
			break;
		case G:
			deplacerAGauche();
			break;
		default:
			break;
		}
	}

	private void deplacerADroite() {
		switch (sens) {
		case NORTH:
			sens = EAST;
			break;
		case EAST:
			sens = SOUTH;
			break;
		case WEST:
			sens = NORTH;
			break;
		case SOUTH:
			sens = WEST;
			break;
		default:
			break;
		}
	}

	private void deplacerAGauche() {
		switch (sens) {
		case NORTH:
			sens = WEST;
			break;
		case EAST:
			sens = NORTH;
			break;
		case WEST:
			sens = SOUTH;
			break;
		case SOUTH:
			sens = EAST;
			break;
		default:
			break;
		}
	}

	private void deplacerEnAvant() throws DeplacementException {
		int x = caseFinale.getX();
		int y = caseFinale.getY();
		switch (sens) {
		case NORTH:
			y = y + 2;
			break;
		case EAST:
			x = x + 1;
			break;
		case WEST:
			x = x - 1;
			break;
		case SOUTH:
			y = y - 2;
			break;
		default:
			break;
		}
		try {
			this.caseFinale = this.pelouse.getCase(x, y);
		} catch (Exception e) {
			throw new DeplacementException("Déplacement Impossible !");
		}
	}

	@Override
	public String toString() {
		return "Ma position finale est X = " + this.getCaseFinale().getX() + ", Y = " + this.getCaseFinale().getY()
				+ " et je suis orientée : " + this.sens;
	}
}
