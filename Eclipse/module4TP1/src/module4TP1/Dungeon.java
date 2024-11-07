package module4TP1;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
	private int nbRoom;
	private int level;
	private Dragon dragon;
	private List<Monster> monsters = new ArrayList<>();
	
	public Dungeon(int nbRoom, int level, Dragon dragon, List<Monster> monsters) {
		this.nbRoom = nbRoom;
		this.level = level;
		this.monsters = monsters;
		
		// Agreggation
		// this.dragon = new Dragon(dragon);
		
		this.dragon = dragon;

	}
}
