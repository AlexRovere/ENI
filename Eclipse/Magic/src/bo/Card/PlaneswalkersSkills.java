package bo.Card;

public class PlaneswalkersSkills {
	private int id;
	private int cost;
	private String description;
	
	public PlaneswalkersSkills(int cost, String description) {
		this.id++;
		this.cost = cost;
		this.description = description;
	}
	
	public PlaneswalkersSkills(Planeswalkers planeswalker, int cost, String description) {
		this.id++;
		this.cost = cost;
		this.description = description;
		this.setPlaneswalker(planeswalker);
		
	}
	
	public void setPlaneswalker(Planeswalkers planeswalker) {
		planeswalker.addPlaneswalkerSkill(this);
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getCost() {
		return this.cost;
	}
	
}
