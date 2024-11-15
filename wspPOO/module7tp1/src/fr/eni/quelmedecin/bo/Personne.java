package fr.eni.quelmedecin.bo;

import java.util.Comparator;

import fr.eni.quelmedecin.controller.PersonneController;
import fr.eni.quelmedecin.exception.ApplicationException;


public abstract class Personne {
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private Adresse adresse;

	public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse)
			throws ApplicationException {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setNumeroDeTelephone(numeroDeTelephone);
		this.setAdresse(adresse);
	}

	public static Comparator<Personne> comparatorNomPrenomCroissant() {
		return Comparator.comparing(Personne::getNom).thenComparing(Personne::getPrenom);
	}

	public static Comparator<Personne> comparatorNomPrenomDecroissant() {
		return Comparator.comparing(Personne::getNom).thenComparing(Personne::getPrenom).reversed();
	}

	public String toString() {
		return "";

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws ApplicationException {
		this.prenom = PersonneController.validerNom(nom);

	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws ApplicationException {
		this.prenom = PersonneController.validerPrenom(prenom);
	}

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) throws ApplicationException {
		this.numeroDeTelephone = PersonneController.validerNumeroDeTelephone(numeroDeTelephone);
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) throws ApplicationException {
		this.adresse = PersonneController.validerAdresse(adresse);
	}

}
