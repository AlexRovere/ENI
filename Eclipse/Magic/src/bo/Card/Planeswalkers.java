package bo.Card;

import java.util.List;

public class Planeswalkers extends ACards {
	private int loyality;

	public Planeswalkers(String name, String description, String extension, List<Costs> costs, List<Formats> formats, int loyality) {
		super(name, description, extension, costs, formats);
		this.loyality = loyality;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Planeswalkers [loyality=");
		builder.append(loyality);
		builder.append("]");
		return builder.toString();
	}
	
	
}
