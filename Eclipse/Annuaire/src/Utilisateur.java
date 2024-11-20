
public class Utilisateur {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		return builder.toString();
	}
	
	
}
