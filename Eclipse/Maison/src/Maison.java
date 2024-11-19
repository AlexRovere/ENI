import java.util.ArrayList;
import java.util.List;

public class Maison extends Logement {
	
	private static int nbMaisons;


	private int surface;
	private int nbPortes;
	private int nbFenetres;
	private boolean estAVendre;
	private Boolean aUnTerrain;
	private List<Habitant> habitants = new ArrayList<Habitant>();

	public Maison(String adresse, int codePostal, String ville) {
		super(adresse, codePostal, ville);
		this.estAVendre = false;
		this.aUnTerrain = false;
		Maison.nbMaisons++;
	}

	public void mettreEnVente() {
		this.estAVendre = true;
	}

	public String informations() {
		String aVendre = estAVendre ? " est à vendre" : " n'est pas à vendre";

		StringBuilder builder = new StringBuilder();
		builder.append("La maison de ");
		builder.append(surface);
		builder.append(" m2 située ");
		builder.append(super.getAdresseComplete());
		builder.append(aVendre);
		return builder.toString();
	}
	
	public void addHabitant(Habitant habitant) {
		this.habitants.add(habitant);
	}
	
	public String getHabitants() {
		StringBuilder builder = new StringBuilder();
		for(Habitant habitant : habitants) {
			builder.append(habitant.getPrenom()).append(" , ");
		}
		return builder.toString();
	}

	public static String compter() {
		StringBuilder builder = new StringBuilder();
		return builder.append("Nous avons crée ").append(Maison.nbMaisons).append(" maison.").toString();
	}

	public String getAdresse() {
		return super.getAdresse();
	}

	public int getCodePostal() {
		return super.getCodePostal();
	}

	public String getVille() {
		return super.getVille();
	}

	public int getSurface() {
		return surface;
	}

	public int getNbPortes() {
		return nbPortes;
	}

	public int getNbFenetres() {
		return nbFenetres;
	}
	
	public boolean getTerrain() {
		return aUnTerrain;
	}

	public boolean isEstAVendre() {
		return estAVendre;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}

	public void setNbFenetres(int nbFenetres) {
		this.nbFenetres = nbFenetres;
	}

}
