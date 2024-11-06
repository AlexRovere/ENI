package bo;

public class Chauffage {
		public double temperature;
		public String lieu;
		public String etat;
		
		private static int nombreChauffages;
		
		public Chauffage(double temperature, String lieu, String etat) {
			this.temperature = temperature;
			this.lieu = lieu;
			this.etat = etat;
			Chauffage.nombreChauffages++;
		}
		
		public void augmenterTemperature(double increment) {
			this.temperature += increment;
			System.out.println("Le chauffage a été augmenté de : " + increment + "°C");
		};
		
		public void afficherTemperature() {
			System.out.println("Le chauffage est réglé sur : " + this.temperature + "°C");
		};
		
		public void afficherEtat() {
			System.out.println("Le chauffage est sur l'état : " + this.etat);
		};
		
		public void afficherLieu() {
			System.out.println("Le chauffage est localisé : " + this.lieu);
		};
		
		
		 public static void afficherNombreChauffages() {
			System.out.println("Le nombre total de chauffage est de : " + Chauffage.nombreChauffages);
		}
	}
