package bo.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class ACards {
	private int id;
	private String name;
	private String description;
	private String extension; // TODO ENUM

	private List<Costs> costs = new ArrayList<Costs>(); // 1..*
	private List<Formats> formats = new ArrayList<Formats>(); // 1..*


	public ACards(String name, String description, String extension, List<Costs> costs, List<Formats> formats) {
		super();
		this.name = name;
		this.description = description;
		this.extension = extension;
		this.addCost(costs);
		this.addFormats(formats);
	}



	public void addCost(List<Costs> costs) {
		if (costs != null) {
			 List<Costs> newCosts = new ArrayList<>();
			for (Costs cost : costs) {
				cost.setCardId(this.id);
				newCosts.add(cost);
			}
	        this.costs.addAll(newCosts);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ACards [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", extension=");
		builder.append(extension);
		builder.append(", costs=");
		for(Costs cost : costs) {
			builder.append(cost.getQuantity()).append(cost.getColor());
			builder.append(" ");
		}
		builder.append(", formats=");
		for(Formats format : formats) {
			builder.append(format.getName());
			builder.append(" ");
		}
		builder.append("]");
		return builder.toString();
	}



	public void addFormats(List<Formats> formats) {
		if (formats != null) {
			this.formats.addAll(formats);
		}
	}

}
