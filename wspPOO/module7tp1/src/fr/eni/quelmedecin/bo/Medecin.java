package fr.eni.quelmedecin.bo;

import fr.eni.quelmedecin.exception.ApplicationException;

/**
 * Classe modélisant un médecin généraliste
 * 
 * @author ENI
 * @version 2.0
 */
public class Medecin extends Personne implements ISoigner {

	//ATTRIBUTS D'INSTANCE
	//association bidirectionnelle
	//navigation vers Creneau 0..15
	private Creneau[] creneaux;
	private int tarif = 25;
	
	//CONSTANTES DE CLASSE
	public static final int MAX_CRENEAUX = 15;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type MedecinGeneraliste
	 * 
	 * @param nom - nom du médecin
	 * @param prenom - prénom du médecin
	 * @param numeroDeTelephone - numéro de téléphone
	 * @param adresse - adresse postale du medecin
	 * @throws ApplicationException 
	 * @throws ApplicationException 
	 */
	public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse) throws ApplicationException, ApplicationException {
		super(nom.toUpperCase(), prenom, numeroDeTelephone, adresse);
		creneaux = new Creneau[MAX_CRENEAUX];
	}
	
	public void orienter() {
		System.out.println("Le médecin oriente le patient");
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme : 
	 * NOM Prénom 
	 * Téléphone : XXXXXXXXXX
	 * Tarif : XX€ 
	 * Adresse : Complément 
	 * XXbis rue XXXXXXXXX 
	 * 00000 XXXXXXXXXXXXX
	 * Créneaux :
	 * 00:00 - 00:00 (XX minutes)
	 */
	public String toString() {
		String str = String.format("%s %s%nTéléphone : %s%nTarif : %d€%nAdresse :%n", this.getNom(), this.getPrenom(),
				this.getNumeroDeTelephone(), this.tarif);
		return str;

	}
	
	public void afficherAdresseEtCreneaux () {
		if (super.getAdresse() != null) {
			this.getAdresse().afficher();
		}
		System.out.println("Créneaux :");
		for (int i = 0; i < this.creneaux.length; i++)
			if (this.creneaux[i] != null)
				this.creneaux[i].afficher();
	}

	/**
	 * @param creneauAAjouter
	 * @throws ApplicationException 
	 */
	void ajouterCreneau(Creneau creneauAAjouter) throws ApplicationException {
		if (this != creneauAAjouter.getMedecin()) {
			System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre");
		} else {
			int pos = 0;
			while (pos < this.creneaux.length && this.creneaux[pos] != null)
				pos++;
			if (pos == this.creneaux.length)
				throw new ApplicationException("Trop de créneaux sont affectés à ce médecin");
			else
				this.creneaux[pos] = creneauAAjouter;
		}
	}

	public Creneau[] getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(Creneau[] creneaux) {
		this.creneaux = creneaux;
	}

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) throws ApplicationException {
		if(tarif > this.tarif) {
			this.tarif = tarif;
		} else {
			throw new ApplicationException("Le tarif du spécialiste doit être supérieur à celui d'un généraliste");
		}
	}


}
