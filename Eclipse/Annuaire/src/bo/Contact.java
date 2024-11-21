package bo;

import java.io.Serializable;

public abstract class Contact implements Serializable {

	long numero;
	String nom;
	String telephone;
	String adresseMail;
	Boolean favoris;
	Adresse adresse;
	
	public Contact() {
		super();
	}

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
		builder.append("Contact [numero=");
		builder.append(numero);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", adresseMail=");
		builder.append(adresseMail);
		builder.append(", favoris=");
		builder.append(favoris);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append("]");
		return builder.toString();
	}
	
	

}
