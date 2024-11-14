package fr.eni.quelmedecin.test;


import fr.eni.quelmedecin.bo.Adresse;
import fr.eni.quelmedecin.bo.Medecin;
import fr.eni.quelmedecin.bo.MedecinSpecialiste;
import fr.eni.quelmedecin.exception.ApplicationException;

public class TestAvance2 {

	public static void main(String[] args) {
		Adresse sh= null;
		sh = new Adresse("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");

		Medecin edmond = null;

		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//test spécialité incorrecte
		System.out.println("------ spécialité incorrecte -----");
		try {
			edmond = new MedecinSpecialiste("Bosapin", "Edmond", "0228031724", sh, "CARDIO", 52);
			System.out.println((MedecinSpecialiste)edmond);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
		//test cas nominal
		System.out.println("------ cas nominal -----");
		try {
			edmond = new MedecinSpecialiste("Bosapin", "Edmond", "0228031724", sh, "CARDIOLOGIE", 52);
			System.out.println((MedecinSpecialiste)edmond);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
	}
}
