package dal.impl;

import bo.Utilisateur;
import dal.UtilisateurDao;

public class UtilisateurBinaryImplDao implements UtilisateurDao {

	@Override
	public Utilisateur selectBy(String pseudo, String motPasse) {
		System.out.println("BINARY");
		return null;
	}

}
