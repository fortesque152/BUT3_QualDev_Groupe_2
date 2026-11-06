package enumerations;

public enum EDirection {

	NORTH(0,-1), EAST(-1,0), WEST(1,0), SOUTH(0,1);

	private int x;
	private int y;

	EDirection(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public EDirection droite() { return values()[(ordinal() + 1) % 4]; }
	public EDirection gauche() { return values()[(ordinal() + 3) % 4]; }
}
