package fr.eni.demoFormulaire.controllers.dto;

public class PersonneDTO {
	private String nom;
	private String prenom;
	private int age; 
	private int idMetier;
	
	public PersonneDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonneDTO(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public PersonneDTO(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public String afficherBonjour() {
		return "Bonjour " + this.prenom + " " + this.nom; 
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

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIdMetier() {
		return idMetier;
	}

	public void setIdMetier(int idMetier) {
		this.idMetier = idMetier;
	}
	
}
