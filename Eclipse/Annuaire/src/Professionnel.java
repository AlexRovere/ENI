
public class Professionnel extends Contact {
	String nomEntreprise;

	public Professionnel(long numero, String nom, String telephone, String adresseMail, Adresse adresse, String nomEntreprise ) {
		super(numero, nom, telephone, adresseMail, adresse);
		this.nomEntreprise = nomEntreprise;
	}
	
	public String getNature() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Professionel [nomEntreprise=");
		builder.append(nomEntreprise);
		builder.append("]");
		return builder.toString();
	}

}