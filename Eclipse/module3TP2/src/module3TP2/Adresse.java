package module3TP2;

public class Adresse {
	private String mentionComplementaire;
	private int numeroVoie;
	private String complementVoie;
	private String voie;
	private int codePostal;
	private String ville;
	
	
	public Adresse(String mentionComplementaire, int numeroVoie, String complementVoie, String voie, int codePostal,
			String ville) {
		this.mentionComplementaire = mentionComplementaire;
		this.numeroVoie = numeroVoie;
		this.complementVoie = complementVoie;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse(int numeroVoie, String complementVoie, String voie, int codePostal,
			String ville) {
		this.mentionComplementaire = null;
		this.numeroVoie = numeroVoie;
		this.complementVoie = complementVoie;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public void afficher() {
		if(mentionComplementaire != null) System.out.println(mentionComplementaire);
		if(complementVoie != null) System.out.print(complementVoie + " ");
		System.out.println(numeroVoie + " " + voie);
		System.out.println(codePostal + " " + ville.toUpperCase());
	}

	public String getMentionComplementaire() {
		return mentionComplementaire;
	}

	public void setMentionComplementaire(String mentionComplementaire) {
		this.mentionComplementaire = mentionComplementaire;
	}

	public int getNumeroVoie() {
		return numeroVoie;
	}

	public void setNumeroVoie(int numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public String getComplementVoie() {
		return complementVoie;
	}

	public void setComplementVoie(String complementVoie) {
		this.complementVoie = complementVoie;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
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
