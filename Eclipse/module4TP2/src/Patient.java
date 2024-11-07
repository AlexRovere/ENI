
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un patient
 *  
 * @author ENI
 * @version 1.0
 */
public class Patient {
	
	//ATTRIBUT D'INSTANCE
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaires;
	private Adresse adresse;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type Patient
	 * @param nom - nom du patient
	 * @param prenom - prénom du patient
	 * @param numeroDeTelephone - numéro de téléphone du patient
	 * @param sexe - sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @param numSecu - numéro de sécurité sociale du patient
	 * @param dateNaissance - date de naissance du patient
	 * @param commentaires - commentaires associé à ce patient (allergie, antécédents médicaux…)
	 */
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecu,
			LocalDate dateNaissance, String commentaires, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
		this.commentaires = commentaires;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom.toUpperCase();
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public long getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(long numSecu) {
		this.numSecu = numSecu;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	public void afficher() {
		System.out.printf(
				"%s %s%nTéléphone : %s%nSexe : %s%nNuméro de Sécurité sociale : %d%nDate de naissance : %s%nCommentaires : %s%n",
				this.nom, this.prenom, this.numeroDeTelephone, this.sexe == 'F' ? "Féminin" : "Masculin",
				this.numSecu, this.dateNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
				this.commentaires != null ? this.commentaires : "[aucun commentaire]", this.adresse);
	}
 
	/**
	 * Getter pour prenom 
	 * @return le prénom
	 * @see Patient#setPrenom(String)
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour prenom
	 * @param prenom - le prenom du patient
	 * @see Patient#getPrenom()
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour numeroDeTelephone 
	 * @return le numéro de téléphone
	 * @see Patient#setNumeroDeTelephone(String)
	 */
	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	/**
	 * Setter pour numeroDeTelephone
	 * @param numeroDeTelephone - le numéro de téléphone
	 * @see Patient#getNumeroDeTelephone()
	 */
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}
	
	
}
