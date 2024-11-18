package fr.eni.quelmedecin.bo;

public class MedecinSpecialiste extends Medecin{
	

	private String specialite;
	
	
	public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
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


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getNom()  {
		return super.getNom();
	}
	
}
