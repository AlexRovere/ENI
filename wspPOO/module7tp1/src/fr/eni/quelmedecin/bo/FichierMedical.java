package fr.eni.quelmedecin.bo;

import java.time.LocalDate;

public class FichierMedical {
	private int poids;
	private int taille;
	private String tension;
	private int oxygenation;
	private int pulsation;
	private String probleme;
	private String prescription;
	private LocalDate dateSoin;
	private Medecin medecin;
	private Patient patient;
	
	
	public FichierMedical(int poids, int taille, String tension, int oxygenation, int pulsation, String probleme,
			String prescription, LocalDate dateSoin, Patient patient, Medecin melanie) {
		super();
		this.poids = poids;
		this.taille = taille;
		this.tension = tension;
		this.oxygenation = oxygenation;
		this.pulsation = pulsation;
		this.probleme = probleme;
		this.prescription = prescription;
		this.dateSoin = dateSoin;
		this.medecin = melanie;
		this.patient = patient;
	}


	public FichierMedical() {
		super();
	}
	
	public String affichageSpecifique() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.medecin.toString());
		return builder.toString();
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FicherMedical [poids=");
		builder.append(poids);
		builder.append(", taille=");
		builder.append(taille);
		builder.append(", tension=");
		builder.append(tension);
		builder.append(", oxygenation=");
		builder.append(oxygenation);
		builder.append(", pulsation=");
		builder.append(pulsation);
		builder.append(", probleme=");
		builder.append(probleme);
		builder.append(", prescription=");
		builder.append(prescription);
		builder.append(", dateSoin=");
		builder.append(dateSoin);
		builder.append(", medecin=");
		builder.append(medecin);
		builder.append(", patient=");
		builder.append(patient);
		builder.append("]");
		return builder.toString();
	}


	public int getPoids() {
		return poids;
	}


	public void setPoids(int poids) {
		this.poids = poids;
	}


	public int getTaille() {
		return taille;
	}


	public void setTaille(int taille) {
		this.taille = taille;
	}


	public String getTension() {
		return tension;
	}


	public void setTension(String tension) {
		this.tension = tension;
	}


	public int getOxygenation() {
		return oxygenation;
	}


	public void setOxygenation(int oxygenation) {
		this.oxygenation = oxygenation;
	}


	public int getPulsation() {
		return pulsation;
	}


	public void setPulsation(int pulsation) {
		this.pulsation = pulsation;
	}


	public String getProbleme() {
		return probleme;
	}


	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}


	public String getPrescription() {
		return prescription;
	}


	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}


	public LocalDate getDateSoin() {
		return dateSoin;
	}


	public void setDateSoin(LocalDate dateSoin) {
		this.dateSoin = dateSoin;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
