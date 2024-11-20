
public abstract class Contact {
	long numero;
	String nom;
	String telephone;
	String adresseMail;
	Boolean favoris;
	Adresse adresse;

	public Contact(long numero, String nom, String telephone, String adresseMail, Adresse adresse) {
		this.numero = numero;
		this.nom = nom;
		this.telephone = telephone;
		this.adresseMail = adresseMail;
		this.adresse = adresse;
	}
	
	protected abstract String getNature();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("]");
		return builder.toString();
	}
	
	

}
