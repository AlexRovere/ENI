package bo.Card;

import java.util.ArrayList;
import java.util.List;

public class Planeswalkers extends Cards {
	private int loyality;
	private List<PlaneswalkersSkills> planeswalkerSkill = new ArrayList<PlaneswalkersSkills>();

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
		builder.append("Skills :\n");
		for(PlaneswalkersSkills el : planeswalkerSkill) {
			builder.append("Cost : ").append(el.getCost()).append(" Description : ").append(el.getDescription());
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public void addPlaneswalkerSkill(PlaneswalkersSkills planeswalkerSkill) {
		this.planeswalkerSkill.add(planeswalkerSkill);
	}
	
	
}
