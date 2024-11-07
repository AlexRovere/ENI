package module3TP1.bo;

public class Personne {
	private String nom;
	public int age;
	String adresse;
	protected String email;
	
	public Personne(String nom, int age, String adresse, String email) {
		this.nom = nom;
		this.age = age;
		this.adresse = adresse;
		this.email = email;
	}
	
	public void afficherInfos() {
		System.out.println(this.nom + " " + this.age + " " +  this.adresse + " "  + this.email);
	}
	
	public void mettreAJourAdresse(String nouvelleAdress) {
		this.adresse = nouvelleAdress;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + ", adresse=" + adresse + ", email=" + email + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
