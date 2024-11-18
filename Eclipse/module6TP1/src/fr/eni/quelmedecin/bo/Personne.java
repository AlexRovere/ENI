package fr.eni.quelmedecin.bo;

import java.util.Comparator;

public abstract class Personne {
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private Adresse adresse;

	public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.adresse = adresse;
	}

public static Comparator<Personne> comparatorNomPrenomCroissant () {
	return Comparator.comparing(Personne::getNom).thenComparing(Personne::getPrenom);
}

public static Comparator<Personne> comparatorNomPrenomDecroissant () {
	return Comparator.comparing(Personne::getNom) .thenComparing(Personne::getPrenom).reversed();
}

	public String toString() {
		return "";

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
