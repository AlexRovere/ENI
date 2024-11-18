package fr.eni.quelmedecin.controller;

import fr.eni.quelmedecin.bo.Adresse;
import fr.eni.quelmedecin.exception.ApplicationException;

public class PersonneController {

	public static String validerPrenom(String prenom) throws ApplicationException {
		if (prenom != null && !prenom.trim().isEmpty() && prenom.length() > 0 && prenom.length() < 100) {
			return prenom;
		}
		throw new ApplicationException("Le prenom doit être renseigné et comporter entre 1 et 100 caractères");
	}
	
	public static String validerNom(String nom) throws ApplicationException {
		if (nom != null && !nom.trim().isEmpty() && nom.length() > 0 && nom.length() < 100) {
			return nom;
		}
		throw new ApplicationException("Le prenom doit être renseigné et comporter entre 1 et 100 caractères");
	}


	public static String validerNumeroDeTelephone(String numeroDeTelephone) throws ApplicationException {
		if (numeroDeTelephone.length() == 10) {
			return numeroDeTelephone;
		}
		throw new ApplicationException("Le numéro de téléphone doit avoir 10 caractères si il est renseigné");
	}
	
	public static Adresse validerAdresse(Adresse adresse) throws ApplicationException {
		if (adresse != null) {
			return adresse;
		}
		throw new ApplicationException("L'adresse doit être renseignée");
	}

}
