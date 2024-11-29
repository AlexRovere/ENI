package fr.eni.demoFormulaire.bo;

public class Metier {
	private int id;
	private String libelle;
	
	
	public Metier(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	public Metier(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Metier [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
