package dal;

import bo.Personne;

public class DAOB implements DAOInterface {
	
	public void sauvegarder(Personne p) {
		System.out.println("j'ai sauvegardé ! " + p);
	}

}
