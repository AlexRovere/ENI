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
import fr.eni.quelmedecin.exception.ProgrammeurException;
import fr.eni.quelmedecin.exception.UtilisateurException;

public class TestAttendu {

	public static void main(String[] args) {
		Adresse sh= null, nio=null, lr=null;
		Personne jean=null, adhemar=null;
		Creneau c1=null;
		RendezVous rdv= null;
		
		System.out.println("__________________________ Adresses ______________________________");
		//cas nominal
		try {
			sh = new Adresse("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
			nio = new Adresse(19, null, "avenue Léo Lagrange", 79000, "Niort");
			lr = new Adresse(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Patients ______________________________");
		
		//test sexe : different de 'F' et 'M'
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			System.out.println(((Patient)jean).getSexe());
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		//test date de naissance : inferieur à date du jour
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.now().plusDays(10L), null, nio);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		//test date de naissance : superieur au 01/01/1900
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.of(1900, 1, 1).minusDays(10L), null, nio);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		//test patient sans adresse
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.of(1992, 11, 21), null, null);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		//cas nominal
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, lr);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Médecins géneralistes ______________________________");
		Medecin melanie = null;
		//test medecin sans adresse
		try {
			melanie = new MedecinGeneraliste("Malalaniche", "Mélanie", "0228031728", null);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		//cas nominal
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
			
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			new Creneau(LocalTime.of(16, 30), 30, melanie);
			new Creneau(LocalTime.of(17, 0), 30, melanie); // trop de creneaux pour ce medecin
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ Rendez-Vous ___________________________");
		//date de rendez-vous antérieur à la date du jour
		try {
			rdv = new RendezVous(c1, (Patient)adhemar, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		//pas d'instance de creneau
		try {
			rdv = new RendezVous(null, (Patient)adhemar, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		//pas d'instance de patient
		try {
			rdv = new RendezVous(c1,  null, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}


		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//test medecin sans adresse
		Medecin edmond;
		try {
			edmond = new MedecinSpecialiste("Bosapin", "Edmond", "0228031724", null, "CARDIOLOGIE", 52);
			System.out.println(edmond);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		MedecinSpecialiste celine=null;
		Creneau c2= null;
		try {
			celine = new MedecinSpecialiste("OCENSEMAIME", "Céline", "0748159263", sh, "ORL", 52);
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
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			new Creneau(LocalTime.of(16, 40), 20, celine);
			new Creneau(LocalTime.of(17, 0), 20, celine); // trop de creneaux pour ce medecin
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ rendez-vous __________________________");
		//date de rendez-vous antérieur à la date du jour
		try {
			rdv = new RendezVous(c2, (Patient)jean, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		//pas d'instance de creneau
		try {
			rdv = new RendezVous(null, (Patient)jean, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		//pas d'instance de patient
		try {
			rdv = new RendezVous(c2,  null, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
	}
}
