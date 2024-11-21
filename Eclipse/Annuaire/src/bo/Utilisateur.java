package bo;

import java.io.Serializable;

public class Utilisateur implements Serializable {
	int id;


	String nom;
	String pseudo;
	String motPasse;
	
	public Utilisateur(int id, String nom, String pseudo, String motPasse) {
		this.id = id;
		this.nom = nom;
		this.pseudo = pseudo;
		this.motPasse = motPasse;
	}
	
	
	public Utilisateur() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", motPasse=");
		builder.append(motPasse);
		builder.append("]");
		return builder.toString();
	}
	
	public String getNom() {
		return this.nom;
	}


	
	
}
