package module3TP1;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Personnage Alex = new Personnage("Alex", 5, 2, 20, 5);
		Personnage Antoine = new Personnage("Antoine", 3, 3, 18, 3);
		
		Alex.bouleDeFeu(Antoine);
		
		Alex.afficherStatistiques();
		
		Random rand = new Random();
		int max = 5;
		int min = 0;
		
		System.out.println(rand.nextInt(max + 1 - min) + min);

	}

}
