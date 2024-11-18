package fr.eni.quelmedecin.bo;

public class MedecinSpecialiste extends Medecin{
	

	private String specialite;
	
	
	public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse, String specialite, int tarif) {
		super(nom, prenom, numeroDeTelephone, adresse);
		this.specialite = specialite;
		super.setTarif(tarif);
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	public String getNom()  {
		return super.getNom();
	}

}
