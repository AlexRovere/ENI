package fr.eni.quelmedecin.test;

import java.time.LocalDate;

import fr.eni.quelmedecin.bo.Adresse;
import fr.eni.quelmedecin.bo.Medecin;
import fr.eni.quelmedecin.bo.MedecinGeneraliste;
import fr.eni.quelmedecin.bo.MedecinSpecialiste;
import fr.eni.quelmedecin.bo.Patient;
import fr.eni.quelmedecin.bo.Personne;
import fr.eni.quelmedecin.exception.UtilisateurException;

public class TestEssentiel {

	public static void main(String[] args) {
		
		System.out.println("__________________________ Adresses ______________________________");
		//test numero de voie : negatif
		Adresse sh= null;
		try {
			sh = new Adresse("ZAC du Moulin Neuf", -10, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//test nom de la rue : null
		Adresse nantes= null;
		try {
			nantes = new Adresse(null, 20, null, null, 44000, "Nantes");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//test nom de la rue : non renseigné
		try {
			nantes = new Adresse(null, 20, null, "", 44000, "Nantes");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//test nom de la ville : null
		Adresse brest= null;
		try {
			brest = new Adresse(null, 22, null, "rue de la Mer", 29000, null);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		//test nom de la ville : non renseigné
		try {
			brest = new Adresse(null, 22, null, "rue de la Mer", 29000, "");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		//test code postal : inférieur à 1000
		Adresse nio= null;
		try {
			nio = new Adresse(19, null, "avenue Léo Lagrange", 999, "Niort");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//test code postal : supérieur à 99999
		Adresse lr= null;
		try {
			lr = new Adresse(null, 18, "B", "rue des Fleurs", 100000, "La Rochelle");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		

		//cas nominal
		try {
			sh = new Adresse("ZAC du Moulin Neuf", -10, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
			nantes = new Adresse(null, 20, null, "rue de la Paix", 44000, "Nantes");
			brest = new Adresse(null, 22, null, "rue de la Mer", 29000, "Brest");
			nio = new Adresse(19, null, "avenue Léo Lagrange", 79000, "Niort");
			lr = new Adresse(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Patients ______________________________");
		
		//test sexe : different de 'F' et 'M'
		try {
			Personne jean = new Patient("Dupond", "Jean", "0753428619",'G', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//test numsecu : different de 13 caractères
		try {
			Personne paul = new Patient("Dupond", "Paul", "0753428619", 'M', 19211219202014l, LocalDate.of(1992, 11, 21), null, nantes);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//test sexe : date de naissance non renseignée
		try {
			Personne franck = new Patient("Duboulon", "Franck", "0753428619", 'M', 1921121920201l, null, null, brest);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		try {
			Personne jean = new Patient("Dupond", "Jean", "0753428619",'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			Personne paul = new Patient("Dupond", "Paul", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nantes);
			Personne franck = new Patient("Duboulon", "Franck", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, brest);
			Personne adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, lr);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Médecins géneralistes ______________________________");
		//instanciation d'un medecin generaliste avec erreur
		Medecin melanie= null;
		try {
			melanie = new MedecinGeneraliste("", "Mélanie", "0228031728", sh);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		try {
			melanie = new MedecinGeneraliste("Malalaniche", "Mélanie", "0228031728", sh);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//instanciation des medecins specialistes avec erreur
		Medecin edmond;
		try {
			edmond = new MedecinSpecialiste("", "Edmond", "0228031724", sh, "CARDIOLOGIE", 52);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//test spécialité : null
		Medecin benoit;
		try {
			benoit = new MedecinSpecialiste("De Cajou", "Benoit", "0228031723", sh, null, 57);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		//test spécialité : non renseignée
		try {
			benoit = new MedecinSpecialiste("De Cajou", "Benoit", "0228031723", sh, "", 57);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		//test tarif superieur au tarif du medecin generaliste
		Medecin anne;
		try {
			anne = new MedecinSpecialiste("Aimone", "Anne", "0228031726", sh, "STOMATOLOGIE", 20);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		try {
			edmond = new MedecinSpecialiste("Bosapin", "Edmond", "0228031724", sh, "CARDIOLOGIE", 52);
			benoit = new MedecinSpecialiste("De Cajou", "Benoit", "0228031723", sh, "ANGIOLOGIE", 57);
			anne = new MedecinSpecialiste("Aimone", "Anne", "0228031726", sh, "STOMATOLOGIE", 55);
			Medecin sylvan = new MedecinSpecialiste("Tourne", "Sylvan", "0228031721", sh, "PEDIATRIE", 52);
			Medecin remy = new MedecinSpecialiste("Sion", "Remy", "0228031725", sh, "GYNECOLOGIE OBSTETRIQUE", 55);
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}
		

	}
}
