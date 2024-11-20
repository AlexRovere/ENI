package bo.Card;

import java.util.ArrayList;
import java.util.List;

public class Monsters extends Cards {
	private List<Monster_type> monster_types = new ArrayList<Monster_type>(); // 0..*
	private int attack;
	private int defense;

	public Monsters(String name, String description, String extension, List<Costs> costs, List<Formats> formats, List<Monster_type> monster_types, int attack, int defense) {
		super(name, description, extension, costs, formats);
		this.addMonsterType(monster_types);
		this.attack = attack;
		this.defense = defense;
	}

	public void addMonsterType(List<Monster_type> monster_types) {
		if (monster_types != null) {
			for (Monster_type monster_type : monster_types) {
				monster_types.add(monster_type);
			}
		}
	}
}
