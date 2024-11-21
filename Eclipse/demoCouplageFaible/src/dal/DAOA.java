package dal;

import bo.Personne;

public class DAOA implements DAOInterface {
	
	public void sauvegarder(Personne p) {
		System.out.println("j'ai sauvegardé ! " + p);
	}

}
