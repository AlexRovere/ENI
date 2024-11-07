package module3TP1;

import java.util.Random;

public class Personnage {
	private String nom;
	public int force;
	protected int agilite;
	int sante;
	static int nombrePersonnages;
	int intelligence;
	
	private Random rand = new Random();


	public Personnage(String nom, int force, int agilite, int sante, int intelligence) {
		this.nom = nom;
		this.force = force;
		this.agilite = agilite;
		this.sante = sante;
		this.intelligence = intelligence;

		nombrePersonnages++;
	}
	
	
	public void attaqueSacrifice(Personnage cible) {
		int degats = this.force * 4;
		int min = (degats / 2);
		degats = rand.nextInt(degats + 1 - min) + min;
		int degatsSurSoi = rand.nextInt((degats + 1 - min) + min) / 2;
		this.sante -= degatsSurSoi;
		System.out.println(nom + " lance une attaque déspéré est s'inflige " + degatsSurSoi + " points de dégats");
		System.out.println(sante + " PV restants");
		cible.defendre(degats);
	}

	public void attaquer(Personnage cible) {
		int degats = this.force * 2;
		int min = (degats / 2);
		degats = rand.nextInt(degats + 1 - min) + min;
		cible.defendre(degats);
	}
	
	public void bouleDeFeu(Personnage cible) {
		int minDice = 1;
		int maxDice = 3;
		int dice = rand.nextInt((maxDice + 1 - minDice) + minDice);
		int degats = this.intelligence;
		int min = 1;
		degats = rand.nextInt(this.intelligence + 1 - min) + min;
				
		int totalDegats = degats * dice;
		System.out.println(nom + " lance une boule de feu et inflige " + totalDegats + " points de dégats");

		cible.defendre(totalDegats);
	}

	public void defendre(int degats) {
		int reductionDegats = (int) (this.agilite * 0.5);
		int min = (reductionDegats / 2);
		reductionDegats = rand.nextInt(reductionDegats + 1 - min) + min;
		int degatsFinaux = (degats - reductionDegats);
		this.sante -= degatsFinaux;

		System.out.println(nom + " se défend et réduit les dégats à " + degatsFinaux);
		System.out.println(sante + " PV restants");

	}

	public boolean estVivant() {
		return this.sante > 0;
	}

	public void afficherStatistiques() {
		System.out.println("Nom : " + this.nom + " Force : " + this.force + " Agilité : " + this.agilite + " Santé : " + this.sante);
	}

	static public void afficherNombrePersonnages() {
		System.out.println(nombrePersonnages);
	}

	public String getNom() {
		return this.nom;
	}

}
