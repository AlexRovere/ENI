/**
 * 
 */


/**
 * Classe de test
 *
 */
public class MettreEnCaisse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Cr�ation de quelques produits stables
		ProduitStable marteau = new ProduitStable("marteau", 3);
		ProduitStable tournevis = new ProduitStable("tournevis", 1);

		// Cr�ation de quelques produits instables
		ProduitInstable essence = new ProduitInstable("essence", 5, "");
		ProduitInstable batterie = new ProduitInstable("batterie", 30, "");

		
		// Cr�ation d'une caisse de produits stables et y ajouter des produits
		Caisse<ProduitStable> caisseStable = new Caisse<ProduitStable>(5);
		try {
		caisseStable.mettre(marteau);
		caisseStable.mettre(tournevis);
		} catch(CaisseSurchargeException e) {
			System.out.println(e.getMessage());
		}
		
		// Cr�ation d'une caisse de produits instables et y ajouter des produits
		Caisse<ProduitInstable> caisseInstable = new Caisse<ProduitInstable>(50);
		try {
		caisseInstable.mettre(batterie);
		caisseInstable.mettre(essence);
		} catch(CaisseSurchargeException e) {
			System.out.println(e.getMessage());
		}

		// Tester la surcharge de la caisse
		System.out.println(caisseInstable.peser());
		
	}

}
