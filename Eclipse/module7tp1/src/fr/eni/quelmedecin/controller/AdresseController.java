package fr.eni.quelmedecin.controller;

import fr.eni.quelmedecin.exception.ApplicationException;

public class AdresseController {

	public static int validerNumero(int numero) throws ApplicationException {
		if (numero > 0) {
			return numero;
		}
		throw new ApplicationException("Le numéro de rue doit être positif");
	}

	public static String validerRue(String rue) throws ApplicationException {
		if (rue != null && rue.trim().length() > 0) {
			return rue;
		}
		throw new ApplicationException("La rue doit être renseigné");
	}

	public static int validerCp(int cp) throws ApplicationException {
		if (cp >= 10000 & cp <= 99999) {
			return cp;
		}
		throw new ApplicationException("Le code postal doit être renseigné");
	}

	public static String validerVille(String ville) throws ApplicationException {
		if (ville != null && ville.trim().length() > 0) {
			return ville;
		}
		throw new ApplicationException("La ville doit être renseigné");
	}
}
