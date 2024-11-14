package fr.eni.quelmedecin.bo;

import fr.eni.quelmedecin.test.UtilisateurException;

public class MedecinGeneraliste extends Medecin{
	

	private final int TARIF = 25;
	
	
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) throws UtilisateurException {
		super(nom, prenom, numeroDeTelephone, adresse);

	}
	
	public void orienter() {
		System.out.println("Le spécialiste oriente le patient");
	}
}
