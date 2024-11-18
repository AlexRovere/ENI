package fr.eni.quelmedecin.bo;

import fr.eni.quelmedecin.exception.ApplicationException;

public class MedecinSpecialiste extends Medecin{
	

	private String specialite;
	
	
	public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) throws ApplicationException {
		super(nom, prenom, numeroDeTelephone, adresse);
	}
	
	public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse, String specialite, int tarif) throws ApplicationException {
		super(nom, prenom, numeroDeTelephone, adresse);
		super.setTarif(tarif);
		this.specialite = specialite;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Spécialité : ").append(specialite).append("\n");

		return builder.toString();
	}

	
	public void orienter() {
		System.out.println("Le spécialiste oriente le patient");
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) throws ApplicationException {
		if(specialite != null && specialite.trim().length() > 0) {
			this.specialite = specialite;
		} else {
			throw new ApplicationException("La spécialité doit être renseignée");
		}
	}

	public String getNom()  {
		return super.getNom();
	}
	
}
