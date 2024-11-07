import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe modélisant un médecin généraliste
 * 
 * @author ENI
 * @version 1.0
 */
public class MedecinGeneraliste {
	
	//ATTRIBUTS D'INSTANCE
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private Adresse adresse;
	private List<Creneau> creneaux = new ArrayList<>();
	//ATTRIBUT DE CLASSE
	private static int tarif = 25;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type MedecinGeneraliste
	 * @param nom - nom du médecin mis en majuscule
	 * @param prenom - prénom du médecin
	 * @param numeroDeTelephone - numéro de téléphone du médecin
	 */
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.adresse = adresse;
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Tarif : XX€
	 */
	public void afficher() {
		System.out.printf("%s %s%nTéléphone : %s%nTarif : %d€%n",  this.nom, this.prenom,
				this.numeroDeTelephone, MedecinGeneraliste.tarif);
		
		System.out.println(this.adresse.toString());
		
		System.out.println("Créneaux : ");
		for (Creneau creneau : creneaux) {
			LocalTime finRdv = creneau.debutCreneau.plusMinutes(creneau.duree); 
			System.out.println(creneau.debutCreneau + " - " + finRdv.toString());
		}
	}
	
	public void ajouterCreneau(Creneau creneau) {
		creneaux.add(creneau);
	}

	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour numeroDeTelephone.
	 * 
	 * @return le numéro de téléphone
	 * @see MedecinGeneraliste#setNumeroDeTelephone(String)
	 */
	public String getNumeroDeTelephone() {
		return this.numeroDeTelephone;
	}

	/**
	 * Setter pour numeroDeTelephone.
	 * 
	 * @param numeroDeTelephone -le numéro de téléphone
	 * @see MedecinGeneraliste#getNumeroDeTelephone()
	 */
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	/**
	 * Getter pour tarif.
	 * 
	 * @return le tarif de la consultation
	 * @see MedecinGeneraliste#setTarif(int)
	 */
	public static int getTarif() {
		return MedecinGeneraliste.tarif;
	}

	/**
	 * Setter pour tarif.
	 * 
	 * @param tarif - le tarif de la consultation
	 * @see MedecinGeneraliste#getTarif()
	 */
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}

	/**
	 * Getter pour nom.
	 * @return le nom du médecin
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter pour prenom.
	 * 
	 * @return le prénom du médecin
	 * @see MedecinGeneraliste#setPrenom(String)
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour prenom.
	 * 
	 * @param prenom - le prénom du médecin
	 * @see MedecinGeneraliste#getPrenom()
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}
