
/**
 * Classe modélisant une adresse française en respectant les recommandations de
 * la poste.
 * 
 * @author ENI
 * @version 1.0
 *
 */
public class Adresse {
	
	//ATTRIBUTS D'INSTANCE
	private String mentionsCompl;
	@Override
	public String toString() {
		return "Adresse [mentionsCompl=" + mentionsCompl + ", numero=" + numero + ", complNumero=" + complNumero
				+ ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + "]";
	}

	private int numero;
	private String complNumero;
	private String rue;
	private int cp;
	private String ville;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type Adresse
	 * @param mentionsCompl - mentions complémentaires éventuelles (comme l’appartement,
	 *            l’étage, l’escalier, « chez… », le bâtiment ou de la résidence)
	 * @param numero - numéro dans la voie
	 * @param complNumero - complément facultatif de numéro tel bis, ter, quater...
	 * @param rue - type de voie (rue, avenue, etc.) et nom de celle-ci
	 * @param cp - code postal
	 * @param ville - nom de la commune
	 */
	public Adresse(String mentionsCompl, int numero, String complNumero, String rue, int cp, String ville) {
		this.mentionsCompl = mentionsCompl;
		this.numero = numero;
		this.complNumero = complNumero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}

	/**
	 * Constructeur : crée une instance de type Adresse
	 * @param numero - numéro dans la voie
	 * @param complNumero - complément facultatif de numéro tel bis, ter, quater...
	 * @param rue - type de voie (rue, avenue, etc.) et nom de celle-ci
	 * @param cp - code postal
	 * @param ville - nom de la commune
	 */
	public Adresse(int numero, String complNumero, String rue, int cp, String ville) {
		this(null, numero, complNumero, rue, cp, ville);
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme :
	 * Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 */
	public void afficher() {
		if (this.mentionsCompl != null)
			System.out.println(mentionsCompl);
		System.out.printf("%d%s %s%n%05d %s%n", this.numero, this.complNumero != null ? this.complNumero : "", this.rue,
				this.cp, this.ville.toUpperCase());
	}
}
