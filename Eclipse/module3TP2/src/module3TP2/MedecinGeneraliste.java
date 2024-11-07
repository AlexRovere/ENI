package module3TP2;

public class MedecinGeneraliste {
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	
	static int tarif = 25;
	
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
		this.nom = nom;
		setPrenom(prenom);
		setNumeroDeTelephone(numeroDeTelephone);
	}
	
	public void afficher() {
		System.out.println(nom.toUpperCase() + " " + prenom);
		System.out.println("Téléphone : " + numeroDeTelephone);
		System.out.println("Tarif : " + tarif + "€");
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
	
	static public void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
	

	

}
