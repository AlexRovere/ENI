package dal;

import bo.Utilisateur;

public interface UtilisateurDao {
	 Utilisateur selectBy(String pseudo, String motPasse);
}
