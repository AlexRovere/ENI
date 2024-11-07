import java.time.LocalTime;

public class Creneau {
	private LocalTime debutCreneau;
	private int duree;
	private MedecinGeneraliste medecin;
	
	public Creneau(LocalTime debutCreneau, int duree, MedecinGeneraliste medecin) {
		this.debutCreneau = debutCreneau;
		this.duree = duree;
		this.medecin = medecin;
		medecin.ajouterCreneau(this);
	}
	
	public void afficher() {
			LocalTime finRdv = this.debutCreneau.plusMinutes(this.duree); 
			System.out.println(this.debutCreneau + " - " + finRdv.toString());
	}

	public LocalTime getDebutCreneau() {
		return debutCreneau;
	}

	public void setDebutCreneau(LocalTime debutCreneau) {
		this.debutCreneau = debutCreneau;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public MedecinGeneraliste getMedecin() {
		return medecin;
	}

	public void setMedecin(MedecinGeneraliste medecin) {
		this.medecin = medecin;
	}
	
}
