package fr.eni.quelmedecin.bo;

import java.util.Comparator;

import fr.eni.quelmedecin.test.UtilisateurException;

public abstract class Personne {
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private Adresse adresse;

	public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse) throws UtilisateurException {
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

	public void setNom(String nom) throws UtilisateurException {
		if (nom != null && !nom.trim().isEmpty() && nom.length() > 0 && nom.length() < 100) {
			this.nom = nom;
		} else {
			throw new UtilisateurException("Le nom doit être renseigné et comporter entre 1 et 100 caractères");
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws UtilisateurException {
		if (prenom != null && !prenom.trim().isEmpty() && prenom.length() > 0 && prenom.length() < 100) {
			this.prenom = prenom;
		} else {
			throw new UtilisateurException("Le prenom doit être renseigné et comporter entre 1 et 100 caractères");
		}
	}

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) throws UtilisateurException {
		if(numeroDeTelephone.length() == 10) {
			this.numeroDeTelephone = numeroDeTelephone;
		} else {
			throw new UtilisateurException("Le numéro de téléphone doit avoir 10 caractères si il est renseigné");
		}
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
