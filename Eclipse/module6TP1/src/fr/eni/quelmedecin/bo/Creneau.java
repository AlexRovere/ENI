package fr.eni.quelmedecin.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un créneau horaire pour un médecin
 * 
 * @author ENI
 * @version 2.0
 *
 */
public class Creneau {
	
	//ATTRIBUTS D'INSTANCE
	private LocalTime heureDebut;
	private int duree;
	//association bidirectionnelle
	//navigation vers Medecin 0..1
	private Medecin medecin;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type Creneau
	 * 
	 * @param heureDebut - heure de début du créneau
	 * @param duree - durée du créneau en minutes
	 * @param medecin - médecin possédant ce créneau
	 */
	public Creneau(LocalTime heureDebut, int duree, Medecin medecin) {
		this.setHeureDebut(heureDebut);
		this.setDuree(duree);
		this.setMedecin(medecin);
		medecin.ajouterCreneau(this);
	}

	//AUTRES METHODES
	/**
	 * Affiche un créneau horaire sous la forme :
	 * 00:00 - 00:00 (XX minutes)
	 */
	public void afficher() {
		System.out.printf("%s - %s (%d minutes)%n",
				this.getHeureDebut().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
				this.getHeureDebut().plusMinutes(this.getDuree()).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
				this.getDuree());
	}

	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour heureDebut
	 * @return l'heure de debut du creneau
	 * @see Creneau#setHeureDebut(LocalTime)
	 */
	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	/**
	 * Setter pour heureDebut
	 * @param heureDebut - l'heure de debut du creneau
	 * @see Creneau#getHeureDebut()
	 */
	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	/**
	 * Getter pour duree
	 * @return la duree du creneau
	 * @see Creneau#setDuree(int)
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * Setter pour duree
	 * @param duree - la duree du creneau
	 * @see Creneau#getDuree()
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * Getter pour medecin.
	 * @return le medecin
	 * @see Creneau#setMedecin(MedecinGeneraliste)
	 */
	public Medecin getMedecin() {
		return medecin;
	}

	/**
	 * Setter pour medecin
	 * @param medecin - le medecin
	 * @see Creneau#getMedecin()
	 */
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

}
