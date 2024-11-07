package module3TP2;

import java.time.LocalDate;

public class Patient {
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private char sexe;
	private long numeroDeSecu;
	private LocalDate dateDeNaissance;
	private String commentaires;

	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroDeSecu,
			LocalDate dateDeNaissance, String commentaires) {
		this.nom = nom;
		setPrenom(prenom);
		setNumeroDeTelephone(numeroDeTelephone);
		this.sexe = sexe;
		this.numeroDeSecu = numeroDeSecu;
		this.dateDeNaissance = dateDeNaissance;
		this.commentaires = commentaires;
	}

	public void afficher() {
		System.out.println(nom.toUpperCase() + " " + prenom);
		System.out.println("Téléphone : " + numeroDeTelephone);
		System.out.println("Sexe : " + sexe);
		System.out.println("Numéro de sécurité sociale : " + numeroDeSecu);
		System.out.println("Date de naissance : " + dateDeNaissance);
		System.out.println("Commentaires : " + commentaires);
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
		String capitalizedPrenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
		this.prenom = capitalizedPrenom;
	}

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String telephone) {
		System.out.println(telephone);
		if(telephone != null &&  Utils.formatNumeroTelephone(telephone)) {
			this.numeroDeTelephone = telephone;
		} else {
			System.err.println("Le numéro de téléphone " + telephone + " n'est pas conforme");
			this.numeroDeTelephone = "<< Numéro incorrect >>";
		}
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public long getNumeroDeSecu() {
		return numeroDeSecu;
	}

	public void setNumeroDeSecu(long numeroDeSecu) {
		this.numeroDeSecu = numeroDeSecu;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

}
