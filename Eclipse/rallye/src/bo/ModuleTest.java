package bo;


import java.util.Scanner;

import fr.eni.rallye.bo.Equipage;
import fr.eni.rallye.bo.Equipe;
import fr.eni.rallye.bo.Nationalite;
import fr.eni.rallye.exception.ProgrammeurException;
import fr.eni.rallye.exception.UtilisateurException;

/**
 * Classe permettant de tester l'application
 * @author ENI
 * @version 1.0
 *
 */
public class ModuleTest {

	/**
	 * Methode point d'entrée de l'application
	 * @param args
	 */
	public static void main(String[] args) {

        /*
         * définir les équipes
         */
        Equipe eqHyundai = Equipe.getEquipe("Hyundai", Nationalite.Allemagne, true);
        Equipe eqToyota = Equipe.getEquipe("Toyota", Nationalite.Angleterre, true);
        Equipe eqFord = Equipe.getEquipe("Ford", Nationalite.France, false);

        Equipage equipe;
		try {
			equipe = new Equipage(1, "NEUVILLE", "Thierry", Nationalite.Belgique, "WYDAEGHE", "Martijn", Nationalite.Belgique);
			eqHyundai.ajouterEquipage(equipe);
			eqHyundai.ajouterEquipage(new Equipage(2, "TANAK", "Ott", Nationalite.Estonie, "JARVEOJA", "Martin", Nationalite.Estonie));
	        eqToyota.ajouterEquipage(new Equipage(3, "OGIER", "Sebastien", Nationalite.France, "LANDAIS", "Vincent", Nationalite.France));
	        eqToyota.ajouterEquipage(new Equipage(4, "EVANS", "Elfyn", Nationalite.Angleterre, "MARTIN", "Scott", Nationalite.Angleterre));
	        /*	l'instruction suivante doit lever une exception de type ProgrammeurException */        
			eqFord.ajouterEquipage(null);
	        eqFord.ajouterEquipage(new Equipage(5, "FOURMAUX", "Adrien", Nationalite.France, "CORIA", "Alexandre", Nationalite.France));
	        eqFord.ajouterEquipage(new Equipage(6, "ROSSEL", "Yohan", Nationalite.France, "DUNAND", "Arnaud", Nationalite.France));
	        eqFord.ajouterEquipage(new Equipage(7, "LOPEZ", "Pepe", Nationalite.Espagne, "VAZQUEZ", "David", Nationalite.Espagne));
	        /*	l'instruction suivante doit lever une exception de type ... */        
	        eqFord.ajouterEquipage(new Equipage(8, "CIAMIN", "Nicolas", Nationalite.France, "ROCHE", "Yannick", Nationalite.France));
		} catch (ProgrammeurException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("ERREUR : ").append(e.getMessage()).append("\n");
			sb.append("DETAIL :").append(e.getCause()).append("\n");
			sb.append("classe ").append(e.getStackTrace()[0].getClassName()).append("\n");
			sb.append("methode").append(e.getStackTrace()[0].getMethodName()).append("\n");
			sb.append("ligne ").append(e.getStackTrace()[0].getLineNumber()).append("\n");
			System.out.println(sb.toString());
		}

        System.out.println("**Composition de l'équipe Citroen");
        System.out.println("*********************************");
        System.out.println(eqHyundai.infosEquipe());
        System.out.println("**Composition de l'équipe Ford");
        System.out.println("******************************");
        System.out.println(eqToyota.infosEquipe());
        System.out.println("**Composition de l'équipe Mustang");
        System.out.println("******************************");
        System.out.println(eqFord.infosEquipe());
        

        
		System.out.println("Appuyez sur entrée pour sortir du test...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();
		}

}
