
public abstract class Produit {
	String libelle;
	int poids;
	
	public Produit(String libelle, int poids) {
		this.libelle = libelle;
		this.poids = poids;
	}

	public int getPoids() {
		return poids;
	}

	@Override
	public String toString() {
		return "Produit [libelle=" + libelle + ", poids=" + poids + "]";
	}
	
	
}
