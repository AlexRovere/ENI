package bo.Card;

public enum EColors {
	BLACK("B", "Black"),
	RED("R", "Red"),
	WHITE("U", "White"),
	BLUE("B", "Blue"),
	GREEN("G", "Green"),
	COLORLESS("C", "Colorless");
	
	private final String code;
	private final String label;

	EColors(String code, String label) {
		this.code = code;
		this.label =  label;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}
	
}
