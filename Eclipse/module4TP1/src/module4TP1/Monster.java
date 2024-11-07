package module4TP1;

public class Monster {
	private String name;
	private int level;
	private float healthPoints;
	private int strength;
	

	public Monster(String name, int level, float healthPoints, int strength) {
		this.name = name;
		this.level = level;
		this.healthPoints = healthPoints;
		this.strength = strength;
	}
	
	public float attack() {
		return 1;
	};
	
	public float defend() {
		return 1;
	}

}
