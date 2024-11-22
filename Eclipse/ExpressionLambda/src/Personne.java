import java.time.LocalDate;

public class Personne {
	String nom;
	int age;
	LocalDate dateNaissance;
	
	public Personne(String nom, int age, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.age = age;
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + ", dateNaissance=" + dateNaissance + "]";
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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
