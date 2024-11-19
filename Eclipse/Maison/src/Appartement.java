
public class Appartement extends Logement {
	private int numeroEtage;


	public Appartement(String adresse, int codePostal, String ville, int numeroEtage) {
		super(adresse, codePostal, ville);
		this.numeroEtage = numeroEtage;
	}
	
	public String getNumeroEtage() {
		String numeroEtage =String.valueOf(this.numeroEtage);
		return numeroEtage;
	}
	
	
	
	
}
