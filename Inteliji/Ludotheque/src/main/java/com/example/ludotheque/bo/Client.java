package com.example.ludotheque.bo;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Client {
	private int noClient;

	@Size(min = 3, max=50)
	@NotBlank
	private String nom;

	@Size(min = 3, max=50)
	@NotBlank
	private String prenom;

	@Size(min = 3, max=50)
	@NotBlank
	private String email;

	@Size(min = 8, max=12)
	@NotBlank
	private String noTel;

	@Size(min = 3, max=50)
	@NotBlank
	private String rue;

	@NotNull
	private int codePostal;

	@Size(min = 3, max=50)
	@NotBlank
	private String ville;

	public Client(String nom, String prenom, String email, String noTel, String rue, int codePostal, String ville) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.noTel = noTel;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Client(String nom, String prenom, String email, String rue, String ville, int codePostal) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client{" +
				"noClient=" + noClient +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", email='" + email + '\'' +
				", noTel='" + noTel + '\'' +
				", rue='" + rue + '\'' +
				", codePostal='" + codePostal + '\'' +
				", ville='" + ville + '\'' +
				'}';
	}

	public int getNoClient() {
		return noClient;
	}

	public void setNoClient(int noClient) {
		this.noClient = noClient;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNoTel() {
		return noTel;
	}

	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
