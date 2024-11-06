import bo.Chauffage;

public class Main {

	public static void main(String[] args) {
		
		Chauffage c1 = new Chauffage(10, "Cuisine", "En fonctionnement");
		Chauffage c2 = new Chauffage(15, "SDB", "En veille");
		Chauffage c3 = new Chauffage(-5, "Chambre", "Comble");


		
//		c1.afficherEtat();
//		c2.augmenterTemperature(10);
//		c2.afficherTemperature();
//
//		c3.augmenterTemperature(20);
//		c3.afficherTemperature();

		
		
		
		Chauffage.afficherNombreChauffages();
		
	}

}
