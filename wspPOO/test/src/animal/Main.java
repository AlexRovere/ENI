package animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Main {
	public static void main(String[] args) {
		
		
		Animal chien = new Chien();
		Animal chat = new Chat();

//		chien.manger(); // fonction de chien
//		chien.courrir(); // fonction d'animal
//		chien.sauter(); // fonction de chien
//		
		// chien.dormir();
		
		List<Animal> liste = new ArrayList<Animal>();
		
		liste.add(chien);
		liste.add(chat);
		
		for(Animal a : liste) {
			a.manger();
		}

		
//		Animal chien = new Chien();
//		chien.manger(); // fonction de chien
//		chien.courrir(); // fonction d'animal
//		chien.sauter(); // fonction de chien IMPOSSIBLE n'existe pas dans animal

	}
}
