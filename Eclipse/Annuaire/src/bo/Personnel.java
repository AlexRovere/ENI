package bo;
import java.io.Serializable;
import java.time.LocalDate;

public class Personnel extends Contact implements Serializable {
	LocalDate dateAnniversaire;

	public Personnel(long numero, String nom, String telephone, String adresseMail, Adresse adresse, LocalDate dateAnniversaire ) {
		super(numero, nom, telephone, adresseMail, adresse);
		this.dateAnniversaire = dateAnniversaire;
	}
	
	public Personnel() {
		super();
	}

	public int getAge() {
		int age = this.getDateAnnivesaire().getYear() - LocalDate.now().getYear();
		return age;
	}
	
	public LocalDate getDateAnnivesaire() {
		return this.dateAnniversaire;
	}
	
	public String getNature() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personnel [dateAnniversaire=");
		builder.append(dateAnniversaire);
		builder.append("]");
		return builder.toString();
	}
	
	
}
