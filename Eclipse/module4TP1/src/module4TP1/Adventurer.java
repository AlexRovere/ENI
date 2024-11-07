package module4TP1;

import java.util.ArrayList;
import java.util.List;

public class Adventurer {
	private String name;
	private int level;
	private float healthPoints;
	private int strength;
	private int agility;
	private int intelligence;
	private List<Dungeon> dungeons = new ArrayList<>();
	
	
	public float attack() {
		return 1;
	};
	
	public Adventurer(String name, int level, float healthPoints, int strength, int agility, int intelligence,
			List<Dungeon> dungeons) {
		this.name = name;
		this.level = level;
		this.healthPoints = healthPoints;
		this.strength = strength;
		this.agility = agility;
		this.intelligence = intelligence;
		this.dungeons = dungeons;
	}

	public float defend() {
		return 1;
	}
	
	public float heal(float amount) {
		return 1;
	}
	
	public void levelUp() {
		
	}
}
