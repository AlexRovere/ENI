
public class Adresse {
	private long code;
	private String rue;
	private String codePostal;
	private String ville;
	
	public Adresse(long code, String rue, String codePostal, String ville) {
		super();
		this.code = code;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adresse [code=");
		builder.append(code);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}
	
	
}
