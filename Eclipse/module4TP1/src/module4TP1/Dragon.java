package module4TP1;

public class Dragon {
	private String name;
	private int level;
	private float healthPoints;
	private int strength;
	private int agility;
	private int flySkill;
	private int fireSkill;
	
	public Dragon(String name, int level, float healthPoints, int strength, int agility, int flySkill, int fireSkill) {
		super();
		this.name = name;
		this.level = level;
		this.healthPoints = healthPoints;
		this.strength = strength;
		this.agility = agility;
		this.flySkill = flySkill;
		this.fireSkill = fireSkill;
	}

	public float attack() {
		return 1;
	};
	
	public float defend() {
		return 1;
	}
	
	public void fly() {
		
	}
	
	public void spitFire() {
		
	}
}
