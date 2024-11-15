package fr.eni.quelmedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import fr.eni.quelmedecin.exception.ApplicationException;

/**
 * Classe modélisant un patient
 * 
 * @author ENI
 * @version 2.0
 */
public class Patient extends Personne {

	// ATTRIBUTS D'INSTANCE
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaires;
	// association unidirectionnelle
	// navigation vers Adresse 0..1

	// CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type Patient
	 * 
	 * @param nom               - nom du patient
	 * @param prenom            - prénom du patient
	 * @param numeroDeTelephone - numéro de téléphone du patient
	 * @param sexe              - sexe du patient : 'F' pour Féminin ou 'M' pour
	 *                          Masculin
	 * @param numSecu           - numéro de sécurité sociale du patient
	 * @param dateNaissance     - date de naissance du patient
	 * @param commentaires      - commentaires associé à ce patient (allergie,
	 *                          antécédents médicaux…)
	 * @param adresse           - adresse postale du patient
	 * @throws ApplicationException
	 * @throws DeveloppeurException
	 */
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecu,
			LocalDate dateNaissance, String commentaires, Adresse adresse)
			throws ApplicationException {
		super(nom.toUpperCase(), prenom, numeroDeTelephone, adresse);
		this.setSexe(sexe);
		this.setNumSecu(numSecu);
		this.setDateNaissance(dateNaissance);
		this.setCommentaires(commentaires);
	}

	// AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme : NOM Prénom Téléphone : XXXXXXXXXX Sexe
	 * : Féminin ou Masculin Numéro de Sécurité sociale XXXXXXXXXXXXXXX Date de
	 * naissance : XX mois XXXX Commentaires : XXXXXXXXXXXXXXX ou [aucun
	 * commentaire] Adresse : Complément XXbis rue XXXXXXXXX 00000 XXXXXXXXXXXXX
	 */
	public String toString() {
		String str = String.format(
				"%s %s%nTéléphone : %s%nSexe : %s%nNuméro de Sécurité sociale : %d%nDate de naissance : %s%nCommentaires : %s%n",
				this.getNom(), this.getPrenom(), this.getNumeroDeTelephone(),
				this.getSexe() == 'F' ? "Féminin" : "Masculin", this.getNumSecu(),
				this.getDateNaissance().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
				this.commentaires != null ? this.getCommentaires() : "[aucun commentaire]");

		return str;
	}

	@Deprecated
	public String afficher() {
		return "";
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) throws ApplicationException {
		List<Character> chars = new ArrayList<Character>();
		chars.add('A');
		chars.add('M');
		chars.add('F');
		if (sexe != 0 && chars.contains((Character) Character.toUpperCase(sexe))) {
			this.sexe = Character.toUpperCase(sexe);
		} else {
			throw new ApplicationException("Le sexe doit être renseigné au format ('M', 'A', 'F')");
		}
	}

	public long getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(long numSecu) throws ApplicationException {
		int length = numSecu > 0 ? (int) (Math.log10(numSecu) + 1) : 0;
		if (length == 13) {
			this.numSecu = numSecu;
		} else {
			throw new ApplicationException("Le numéro de sécurité social doit être renseigné et comporter 13 chiffres");
		}
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) throws ApplicationException {
		LocalDate now = LocalDate.now();
		LocalDate minDate = LocalDate.of(1900, 01, 01);
		if (dateNaissance == null) {
			throw new ApplicationException("La date de naissance doit être renseignée");
		}

		if (dateNaissance.isAfter(now)) {
			throw new ApplicationException("la date de naissance doit être inferieur à la date du jour");
		}
		
		if( dateNaissance.isBefore(minDate)) {
			throw new ApplicationException("la date de naissance doit être supérieur au 01/01/1900");
		}
		
		this.dateNaissance = dateNaissance;

	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

}
