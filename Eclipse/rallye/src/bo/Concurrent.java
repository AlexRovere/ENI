package bo;

public class Concurrent  extends Personne{

	public Concurrent(String nom, String prenom, Nationalite nationalite) {
		super(nom, prenom, nationalite);
	}

	public String infosConcurrent() {
		StringBuilder builder = new StringBuilder();
		builder.append("Concurrent [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", nationalite=");
		builder.append(nationalite);
		builder.append("]");
		return builder.toString();
	}
	
}
