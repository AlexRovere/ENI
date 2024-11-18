package fr.eni.quelmedecin.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.quelmedecin.bo.Adresse;
import fr.eni.quelmedecin.bo.Creneau;
import fr.eni.quelmedecin.bo.MedecinGeneraliste;
import fr.eni.quelmedecin.bo.Patient;
import fr.eni.quelmedecin.bo.Personne;
import fr.eni.quelmedecin.bo.RendezVous;

public class TestPersonne {

	private static Adresse sh = new Adresse("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800,
			"Saint Herblain");
	// transtypage ascendant
	private static Personne malalaniche = new MedecinGeneraliste("Malalaniche", "Mélanie", "02.28.03.17.28", sh);

	private static Adresse nio = new Adresse(19, null, "avenue Léo Lagrange", 79000, "Niort");
	private static Patient adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, nio);

	public static void main(String[] args) {
		System.out.println("__________________________ Affichage d'un médecin ______________________________");
		malalaniche.afficher();
		//transtypage descendant
		MedecinGeneraliste melanie =(MedecinGeneraliste) malalaniche;
		melanie.afficherAdresseEtCreneaux();

		System.out.println("__________________________ Affectation des creneaux au médecin ______________________________");
		Creneau c1 = new Creneau(LocalTime.of(9, 0), 15, melanie);
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
		new Creneau(LocalTime.of(16, 30), 30, melanie);
		//polymorphisme
		melanie.afficher();
		melanie.afficherAdresseEtCreneaux();
		
		System.out.println("__________________________ Affichage d'un Patient ______________________________");
		adhemar.afficher();

		System.out.println("__________________________ Afficher le rendez-Vous du Patient ___________________________");
		RendezVous rdv = new RendezVous(c1, adhemar, LocalDate.of(2020, 5, 23));
		rdv.afficher();

	}
}
