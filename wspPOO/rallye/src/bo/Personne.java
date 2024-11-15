package bo;

public abstract class Personne {
	String nom;
	String prenom;
	Nationalite nationalite;
	
	
	public Personne(String nom, String prenom, Nationalite nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}
	
	public String infosPersonne() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", nationalite=");
		builder.append(nationalite);
		builder.append("]");
		return builder.toString();
	}
}
