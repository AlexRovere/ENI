package fr.eni.heritage.bo;

public class Vehicule {
	
	private long numeroSerie;
	private String marque;
	private String modele;
	
	public Vehicule(long numeroSerie, String marque, String modele) {
		this.numeroSerie = this.getNumeroSerie();
		this.marque = this.getMarque();
		this.modele = this.getModele();
	}

	public long getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(long numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
}
