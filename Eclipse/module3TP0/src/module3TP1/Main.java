package module3TP1;

import module3TP1.bo.Eleve;
import module3TP1.bo.Personne;

public class Main {

	public static void main(String[] args) {
		Personne alex = new Personne("Alex", 34, "bompas", "alex@gmail.com");
		
		Eleve elly = new Eleve("Elly", 8, "bompas", "elly@gmail.com", "CE2", "ARAGO");
		
		elly.afficherInfos();
	}

}
