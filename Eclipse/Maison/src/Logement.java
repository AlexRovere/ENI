
public abstract class Logement {
	private String adresse;
	private int codePostal;
	private String ville;
	
	public Logement(String adresse, int codePostal, String ville) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	
	public String getAdresseComplete() {
		StringBuilder builder = new StringBuilder();
		builder.append(adresse).append(" ").append(codePostal).append(" ").append(ville);
		return builder.toString();
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}


	public int getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}
	
}
