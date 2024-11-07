package module3TP1.bo;

public class Eleve extends Personne {
	
	public String classe;
	public String ecole;

	public Eleve(String nom, int age, String adresse, String email, String classe, String ecole) {
		super(nom, age, adresse, email);
		this.classe = classe;
		this.ecole = ecole;
	}
	
	public void afficherInfos() {
		super.afficherInfos();
		System.out.println(this.classe + " " + this.ecole);
	}
	

}
