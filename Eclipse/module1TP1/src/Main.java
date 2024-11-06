import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static final String fileName = "dictionnaire.txt";
	public static int credit = 10;
	public static int numberOfTryLeft = 5;
	public static boolean cheat = false;


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		do {
			play(s);
		} while (playAgain(s));

		s.close();

		System.out.println("Merci d'avoir joué ! Score total : " + credit);

	}

	public static boolean playAgain(Scanner s) {
		System.out.println("Votre crédit est de " + credit + ", voulez-vous rejouer ? \n"
				+ "Entrez 1 pour rejouer ou 0 pour arrêter");
		String isPlayAgain = s.nextLine();
		if (isPlayAgain.equals("1")) {
			if (credit > 0) {
				return true;
			} else {
				System.out.println("Désolé vous n'avez plus de crédits");
				return false;
			}
		}
		return false;
	}

	public static void play(Scanner s) {
		String[] randomWord = tirerMotAleatoirement();
		
		if(cheat)System.out.println("Mot à trouver " + afficher(randomWord));

		String[] wordShuffled = melanger(randomWord);

		System.out.println("Bienvenue sur notre super jeux ! \n Voici le tirage : " + afficher(wordShuffled)
				+ "\n Quel est le mot caché dans ce tirage ?");

		int wordLength = randomWord.length;
		boolean playerWin = false;

		while (numberOfTryLeft > 0 && !playerWin) {
			numberOfTryLeft--;
			String playerWord = s.nextLine();

			if (sontIdentiques(randomWord, playerWord.split(""))) {
				System.out.println("GAGNE - " + "vous avez trouvé le mot " + afficher(randomWord));
				playerWin = true;
				credit += wordLength;
				continue;
			}

			if (numberOfTryLeft == 0) {
				System.err.println("PERDU - " + "le mot a trouvé était " + afficher(randomWord));
				credit -= wordLength;
				return;
			}

			if (!bonnesLettres(wordShuffled, playerWord.split(""))) {
				System.err.println(
						"Lettre incorrecte ! - Il vous reste " + numberOfTryLeft + " essai(s). Autre proposition ?");
			} else {
				System.err.println("Ce n'est pas le mot à trouver ! - Il vous reste " + numberOfTryLeft
						+ " essai(s). Autre proposition ?");
			}
		}
	}

	public static String afficher(String[] wordToDisplay) {
		return String.join("", wordToDisplay);
	}

	public static String[] tirerMotAleatoirement() {
		List<String> tableauDuFichier = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				tableauDuFichier.add(line);
				/* On passe à la prochaine ligne */
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
		} catch (IOException e) {
			System.out.println("Problème de lecture");
		}

		int length = tableauDuFichier.size();
		int randomIndex = (int) (Math.random() * length);

		String randomWord = tableauDuFichier.get(randomIndex);

		String[] word = randomWord.split("");

		return word;
	}

	public static String[] melanger(String[] word) {

		// Copie l'objet word pour éviter de modifier la référence
		String[] wordToShuffle = Arrays.copyOf(word, word.length);

		for (int i = 0; i < 20; i++) {
			int length = wordToShuffle.length;
			int randomIndex1 = (int) (Math.random() * length);
			int randomIndex2 = (int) (Math.random() * length);

			String randomLetter1 = wordToShuffle[randomIndex1];
			String randomLetter2 = wordToShuffle[randomIndex2];

			wordToShuffle[randomIndex1] = randomLetter2;
			wordToShuffle[randomIndex2] = randomLetter1;
		}

		return wordToShuffle;
	}

	public static boolean bonnesLettres(String[] wordToFind, String[] playerWord) {
		// Passer en HashSet permet de supprimer les doublons
		List<String> letterToFind = Arrays.asList(wordToFind);
		Set<String> uniqueLetterToFind = new HashSet<String>(letterToFind);

		List<String> PlayerLetterFind = Arrays.asList(playerWord);
		Set<String> uniquePlayerLetterFind = new HashSet<String>(PlayerLetterFind);

		if (uniqueLetterToFind.equals(uniquePlayerLetterFind))
			return true;
		return false;
	}

	public static boolean sontIdentiques(String[] array1, String[] array2) {
		if (Arrays.equals(array1, array2))
			return true;
		return false;
	}

}
