package fr.eni.quelmedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import fr.eni.quelmedecin.exception.ApplicationException;

/**
 * Classe modélisant un rendez-vous pris entre un patient et un médecin sur l'un
 * de ses créneaux pour une date donnée
 * 
 * @author ENI
 * @version 2.0
 */
public class RendezVous {

	// ATTRIBUTS D'INSTANCE
	// association unidirectionnelle
	// navigation vers Creneau 0..1
	private Creneau creneau;
	// association unidirectionnelle
	// navigation vers Patient 0..1
	private Patient patient;
	private LocalDate dateRDV;

	// CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type RendezVous
	 * 
	 * @param creneau - créneau horaire du médecin pour le rendez-vous
	 * @param patient - patient ayant pris rendez-vous
	 * @param date    - date du rendez-vous
	 * @throws ApplicationException
	 */
	public RendezVous(Creneau creneau, Patient patient, LocalDate dateRDV)
			throws ApplicationException, ApplicationException {
		this.setCreneau(creneau);
		this.setPatient(patient);
		this.setDateRDV(dateRDV);
	}

	// AUTRES METHODES
	/**
	 * Affiche sous la forme : Rendez-vous du 00 XXXXXXX 0000 00:00 - 00:00 (00
	 * minutes) avec le Dr Nom pour NOM Prénom Téléphone : XXXXXXXXXX Sexe : Féminin
	 * ou Masculin Numéro de Sécurité sociale XXXXXXXXXXXXXXX Date de naissance : XX
	 * mois XXXX Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	@SuppressWarnings("deprecation")
	public void afficher() {
		System.out.printf("Rendez-vous du %s ",
				this.getDateRDV().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		this.getCreneau().afficher();
		System.out.printf("avec le Dr %s%npour ", this.getCreneau().getMedecin().getNom());
		this.getPatient().afficher();
	}

	// ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour creneau
	 * 
	 * @return le creneau du rendez-vous
	 * @see RendezVous#setCreneau(Creneau)
	 */
	public Creneau getCreneau() {
		return creneau;
	}

	/**
	 * Setter pour creneau
	 * 
	 * @param creneau - le creneau du rendez-vous
	 * @throws ApplicationException
	 * @see RendezVous#getCreneau()
	 */
	public void setCreneau(Creneau creneau) throws ApplicationException {
		if (creneau != null) {
			this.creneau = creneau;
		} else {
			throw new ApplicationException("Le créneau est obligatoire pour la prise d'un RDV");
		}

	}

	/**
	 * Getter pour patient
	 * 
	 * @return le patient du rendez-vous
	 * @see RendezVous#setPatient(Patient)
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Setter pour patient
	 * 
	 * @param patient - le patient du rendez-vous
	 * @throws ApplicationException
	 * @see RendezVous#getPatient()
	 */
	public void setPatient(Patient patient) throws ApplicationException {
		if (patient != null) {
			this.patient = patient;
		} else {
			throw new ApplicationException("Un patient doit être rattaché au RDV");
		}
	}

	/**
	 * Getter dateRDV
	 * 
	 * @return la date de rendez-vous
	 * @see RendezVous#setDateRDV(LocalDate)
	 */
	public LocalDate getDateRDV() {
		return dateRDV;
	}

	/**
	 * @param dateRDV - la date de rendez-voust
	 * @throws ApplicationException
	 */
	public void setDateRDV(LocalDate dateRDV) throws ApplicationException {
		LocalDate now = LocalDate.now();
		if (dateRDV != null && dateRDV.isAfter(now)) {
			this.dateRDV = dateRDV;
		} else {
			throw new ApplicationException("La date de rdv doit être antérieur à la date du jour");
		}
	}

}