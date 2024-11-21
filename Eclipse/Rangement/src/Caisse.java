import java.util.ArrayList;
import java.util.List;

public class Caisse<T extends Produit> {
	int poidsMax;
	List<T> objets = new ArrayList<>();

	Caisse(int poidsMax) {
		this.poidsMax = poidsMax;
	}
	
	public void mettre(T t) throws CaisseSurchargeException {
		if(this.peser() + t.getPoids() > this.poidsMax) {
			throw new CaisseSurchargeException("Le caisse est trop lourde");
		}
		System.out.println(t.toString() + " a bien été ajouté");
		objets.add(t);
	}
	
	public int peser() {
		int poids = 0;
		for(T objet : objets) {
			poids+= objet.getPoids();
		}
		return poids;
	}

	@Override
	public String toString() {
		return "Caisse [poidsMax=" + poidsMax + "]";
	}
}
