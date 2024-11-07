import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RendezVous {
	Creneau creneau;
	Patient patient;
	LocalDate date;
	
	public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
		this.creneau = creneau;
		this.patient = patient;
		this.date = date;
	}
	
	public void afficher() {
		StringBuilder str = new StringBuilder();
		
		str.append("Rendez vous du ");
		str.append(date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
		str.append(" de ");
		str.append(creneau.getDebutCreneau());
		str.append(" - ");
		str.append(creneau.getDebutCreneau().plusMinutes(creneau.getDuree()));
		str.append(" (");
		str.append(creneau.getDuree());
		str.append(" minutes)");
		str.append("\n");
		str.append("avec le Dr ");
		str.append(creneau.getMedecin().getNom());
		str.append("\n");
		str.append("pour ");
		str.append(patient.getNom());
		str.append(" ");
		str.append(patient.getPrenom());
		
		String message = str.toString();
		
		System.out.println(message);
	}
	
	
}
