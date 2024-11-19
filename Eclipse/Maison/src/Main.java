import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Maison maison = new Maison("Rue des fleurs", 44200, "Nantes");
		maison.setSurface(70);
		maison.setNbFenetres(6);
		maison.setNbPortes(2);
		
		System.out.println(maison.informations());
		System.out.println(Maison.compter());
		
		Habitant john = new Habitant("John", 18);
		Habitant boby = new Habitant("Boby", 38);
		Habitant bob = new Habitant("Bob", 28);
		
		maison.addHabitant(john);
		maison.addHabitant(boby);
		maison.addHabitant(bob);
		
		System.out.println(maison.getHabitants());
		
		Appartement appartement = new Appartement("rue lambda", 44200, "Nantes", 6);
		
		List<Logement> logements = new ArrayList<Logement>();
		
		logements.add(appartement);
		logements.add(maison);
		
		for(Logement logement : logements) {
			if(logement instanceof Appartement) {
				Appartement logementAppartement = (Appartement)logement;
				System.out.println(logementAppartement.getNumeroEtage());
			}
			if(logement instanceof Maison) {
				Maison logementMaison = (Maison)logement;
				if(logementMaison.getTerrain()) {
					System.out.println("La maison a un terrain");
				} else {
					System.out.println("La maison n'a pas de terrain");

				}
			}
			
			System.out.println(logement.getAdresseComplete());
		}

;
	}

}
