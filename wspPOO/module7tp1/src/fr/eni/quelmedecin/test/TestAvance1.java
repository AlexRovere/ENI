package fr.eni.quelmedecin.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.quelmedecin.bo.Adresse;
import fr.eni.quelmedecin.bo.Creneau;
import fr.eni.quelmedecin.bo.Medecin;
import fr.eni.quelmedecin.bo.MedecinGeneraliste;
import fr.eni.quelmedecin.bo.MedecinSpecialiste;
import fr.eni.quelmedecin.bo.Patient;
import fr.eni.quelmedecin.bo.Personne;
import fr.eni.quelmedecin.bo.RendezVous;
import fr.eni.quelmedecin.exception.ApplicationException;

public class TestAvance1 {

	public static void main(String[] args) {
		Adresse sh= null, nantes=null, brest=null, nio=null;
		Personne jean=null, paul=null, franck=null;
		Creneau c1=null;
		RendezVous rdv= null;
		
		System.out.println("__________________________ Adresses ______________________________");
		//cas avec erreurs
		sh = new Adresse("ZAC du Moulin Neuf", -2, "B", null, 800, null);
			
		System.out.println("__________________________ Patients ______________________________");
		
		//cas avec erreurs (adresse inexistante, sexe incorrect, num secu incorrect, date de naissance incorrecte)
		System.out.println("------- adresse inexistante, sexe incorrect, num secu incorrect, date de naissance incorrecte -----");
		try {
			paul = new Patient("Dupond", "Paul", "0753428619", 'a', 19211219202010l, LocalDate.now().plusDays(10L), null, brest);
			System.out.println(((Patient)paul));
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("==================================================");
		//cas avec erreurs (adresse incorrecte : numero, rue, cp, ville, date de naissance)
		System.out.println("------ adresse incorrecte : numero, rue, cp, ville, date de naissance ------");
		try {
			nio = new Adresse(0, null, null, 790000, null);
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.of(1900, 1, 1).minusDays(10L), null, nio);
			System.out.println(((Patient)jean));
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("==================================================");
		//cas avec erreurs (nom incorrect, prenom incorrect, num tel incorrect, sexe incorrect)
		System.out.println("------ nom incorrect, prenom incorect, num tel incorrect ------");
		try {
			nantes = new Adresse(null, 20, null, "rue de la Paix", 44000, "Nantes");
			franck = new Patient("D", "F", "07534286190", '1', 1921121920201l, LocalDate.of(1992, 11, 21), null, nantes);
			System.out.println(((Patient)franck));
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}

		//cas nominal
		System.out.println("==================================================");
		System.out.println("------ cas nominal -----");
		try {
			franck = new Patient("Duboulon", "Franck", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nantes);
			System.out.println(((Patient)franck));
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}


		sh = new Adresse("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
		nio = new Adresse(19, null, "avenue Léo Lagrange", 79000, "Niort");
		brest = new Adresse(null, 22, null, "rue de la Mer", 29000, "Brest");

		
		
		System.out.println("__________________________ Médecins géneralistes ______________________________");
		Medecin melanie = null;
		//test avec erreurs (medecin sans adresse, nom incorrect, prenom incorrect, num tel incorrect)
		System.out.println("------ medecin sans adresse, nom incorrect, prenom incorrect, num tel incorrect -----");
		try {
			melanie = new MedecinGeneraliste("M", "M", "022803172", null);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("==================================================");
		//test avec erreurs (medecin inexistant)
		System.out.println("----- medecin inexistant pour un creneau -----");
		try {
			melanie = new MedecinGeneraliste("Malalaniche", "Mélanie", "0228031728", sh);
			c1 = new Creneau(LocalTime.of(9, 0), 15, melanie);
			new Creneau(LocalTime.of(9, 15), 15, melanie);
			new Creneau(LocalTime.of(9, 30), 15, melanie);
			new Creneau(LocalTime.of(9, 45), 15, melanie);
			new Creneau(LocalTime.of(10, 30), 15, melanie);
			new Creneau(LocalTime.of(10, 45), 15, melanie);
			new Creneau(LocalTime.of(11, 15), 15, melanie);
			new Creneau(LocalTime.of(11, 30), 15, melanie);
			new Creneau(LocalTime.of(11, 45), 15, melanie);
			new Creneau(LocalTime.of(14, 0), 30, melanie);
			new Creneau(LocalTime.of(14, 30), 30, melanie);
			new Creneau(LocalTime.of(15, 0), 30, melanie);
			new Creneau(LocalTime.of(15, 30), 30, melanie);
			new Creneau(LocalTime.of(16, 0), 30, melanie);
			new Creneau(LocalTime.of(16, 30), 30, null); //instance inexistante
			System.out.println(melanie.toString());
			
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println("==================================================");
		//test avec erreurs (trop de creneau)
		System.out.println(("----- trop de creneaux -----"));
		try {
			new Creneau(LocalTime.of(16, 30), 30, melanie);
			new Creneau(LocalTime.of(17, 0), 30, melanie); // trop de creneaux pour ce medecin
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ Rendez-Vous ___________________________");

		//Test avec erreurs (creneau inexistant, patient inexistant, date de rendez-vous antérieur à la date du jour)
		System.out.println("------ creneau inexistant, patient inexistant, date de rendez-vous antérieur à la date du jour -----");
		try {
			rdv = new RendezVous(null, null, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}

		//Test cas nominal
		System.out.println("------ cas nominal -----");
		try {
			rdv = new RendezVous(c1, (Patient)franck, LocalDate.now().plusDays(10L));
			System.out.println(rdv.toString());
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		

		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//test avec erreurs (medecin sans adresse, sans spécialité et tarif inferieur à celui d'un medecin generaliste)
		Medecin edmond;
		try {
			edmond = new MedecinSpecialiste("Bosapin", "Edmond", "0228031724", null, null, 24);
			System.out.println(edmond);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("==================================================");
		//test avec erreurs (medecin inexistant)
		MedecinSpecialiste celine=null;
		Creneau c2= null;
		try {
			celine = new MedecinSpecialiste("OCENSEMAIME", "Céline", "0748159263", sh, "CARDIOLOGIE", 52);
			new Creneau(LocalTime.of(10, 0), 20, celine);
			new Creneau(LocalTime.of(10, 20), 20, celine);
			new Creneau(LocalTime.of(10, 40), 20, celine);
			new Creneau(LocalTime.of(11, 0), 20, celine);
			new Creneau(LocalTime.of(11, 20), 20, celine);
			new Creneau(LocalTime.of(11, 40), 20, celine);
			new Creneau(LocalTime.of(14, 0), 20, celine);
			new Creneau(LocalTime.of(14, 20), 20, celine);
			new Creneau(LocalTime.of(14, 40), 20, celine);
			new Creneau(LocalTime.of(15, 0), 20, celine);
			c2 = new Creneau(LocalTime.of(15, 20), 20, celine);
			new Creneau(LocalTime.of(15, 40), 20, celine);
			new Creneau(LocalTime.of(16, 0), 20, celine);
			new Creneau(LocalTime.of(16, 20), 20, celine);
			new Creneau(LocalTime.of(16, 40), 20, null);//instance inexistante
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("==================================================");
		//test avec erreurs (trop de creneau)
		try {
			new Creneau(LocalTime.of(16, 40), 20, celine);
			new Creneau(LocalTime.of(17, 0), 20, celine); // trop de creneaux pour ce medecin
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ rendez-vous __________________________");
		//Test avec erreurs (creneau inexistant, patient inexistant, date de rendez-vous antérieur à la date du jour)
		System.out.println("------ creneau inexistant, patient inexistant, date de rendez-vous antérieur à la date du jour -----");
		try {
			rdv = new RendezVous(null, null, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
		//Test cas nominal
		System.out.println("------ cas nominal -----");
		try {
			rdv = new RendezVous(c2, (Patient)franck, LocalDate.now().plusDays(10L));
			System.out.println(rdv.toString());
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
	}
}
