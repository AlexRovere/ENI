package bo.Card;

import java.util.List;

public class Skills {
	private int color_id;
	private String name;
	private String description;
	private String effect;
	private List<Costs> costs;
	private List<Card_skill> card_skill;
	
	public Skills(int color_id, String name, String description, String effect, List<Costs> costs,
			List<Card_skill> card_skill) {
		super();
		this.color_id = color_id;
		this.name = name;
		this.description = description;
		this.effect = effect;
		this.addCosts(costs);
		this.addCardSkill(card_skill);
	}
	
	public void addCosts(List<Costs> costs) {
		if (costs != null) {
			for (Costs cost : costs) {
				this.costs.add(cost);
			}
		}
	}
	
	public void addCardSkill(List<Card_skill> card_skills) {
		if (card_skills != null) {
			for (Card_skill card_skill : card_skills) {
				this.card_skill.add(card_skill);
			}
		}
	
	}
	
	
}
