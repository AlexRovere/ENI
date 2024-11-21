package dal.impl;

import bo.Utilisateur;
import dal.UtilisateurDao;

public class UtilisateurJsonImplDao implements UtilisateurDao {

	@Override
	public Utilisateur selectBy(String pseudo, String motPasse) {
		System.out.println("JSON");
		return null;
	}

}
