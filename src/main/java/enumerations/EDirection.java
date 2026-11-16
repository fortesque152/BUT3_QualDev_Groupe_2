package enumerations;

public enum EDirection {

	NORTH("N"), EAST("E"), WEST("W"), SOUTH("S");

	private String code;

	protected String getCode() {
		return code;
	}

	EDirection(String code) {
		this.code = code;
	}

}
