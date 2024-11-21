
public class ProduitInstable extends Produit {
	
	String reglement;

	public ProduitInstable(String libelle, int poids, String reglement) {
		super(libelle, poids);
		this.reglement = reglement;
	}

	@Override
	public String toString() {
		return "ProduitInstable [reglement=" + reglement + "] " + super.toString();
	}

}
