package bo.Card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
	private int id = 0;
	private String name;
	private String description;
	private String extension; // TODO ENUM

	private int attack;
	private int defense;
	private List<Costs> costs = new ArrayList<Costs>(); // 1..*
	private List<Formats> formats = new ArrayList<Formats>(); // 1..*
	private List<Card_type> card_types = new ArrayList<Card_type>(); // 1..*
	private List<Monster_type> monster_types = new ArrayList<Monster_type>(); // 0..*

	public Cards(String name, String description, int attack, int defense, String extension, List<Costs> costs,
			List<Formats> formats, List<Card_type> card_types) {
		this.id++;
		this.name = name;
		this.description = description;
		this.attack = attack;
		this.defense = defense;
		this.extension = extension;
		this.formats = formats;
		this.card_types = card_types;
		this.addCost(costs);
	}

	// Constructeur avec monster_types
	public Cards(String name, String description, int attack, int defense, String extension, List<Costs> costs,
			List<Formats> formats, List<Monster_type> monster_types, List<Card_type> card_types) {
		this(name, description, attack, defense, extension, costs, formats, card_types);
		this.addMonsterType(monster_types);
	}

	public void addCost(List<Costs> costs) {
		if (costs != null) {
			for (Costs cost : costs) {
				cost.setCardId(this.id);
				costs.add(cost);
			}
		}
	}

	public void addCost(Costs cost) {
		if (costs != null) {
			costs.add(cost);
		}
	}
	
	public void addMonsterType(List<Monster_type> monsters) {
		if (monsters != null) {
			for (Monster_type monster : monsters) {
				monster_types.add(monster);
			}
		}
	}

	public void addCost(Monster_type monster) {
		if (monster != null) {
			monster_types.add(monster);
		}
	}


}
