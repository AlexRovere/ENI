package nombreMystere.services;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class PartieService {
	private int userNumber;
	private int computerNumber;
	private int tryLeft = 3;
	private String helper;
	private String resultat;
	private Boolean userWin = false;

	PartieService() {
		this.computerNumber = generateRandomNumber();
	}

	private int generateRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(0, 50 + 1) - 1;
		return randomNumber;
	}

	public void restartGame() {
		this.computerNumber = generateRandomNumber();
		this.tryLeft = 3;
		this.userNumber = 0;
		this.helper = null;
		this.resultat = null;
		this.userWin = false;
	}

	public void play(int userNumber) {
	
		if (this.tryLeft < 1) {
			this.helper = null;
			resultat = "Désolé vous n'avez plus d'essais restants";
		} else {
			this.tryLeft--;
			this.userNumber = userNumber;
			if (userNumber == computerNumber) {
				resultat = "Vous avez gagné !";
				userWin = true;
				helper = null;
			} else {
				resultat = "Vous n'avez pas trouvé le nombre";
				if (userNumber >computerNumber) {
					helper = "C'est moins !";
				} else {
					helper = "c'est plus !";
				}
			}
		}
	}

	public int getComputerNumber() {
		return computerNumber;
	}

	public int getTryLeft() {
		return tryLeft;
	}

	public String getResultat() {
		return resultat;
	}

	public String getHelper() {
		return helper;
	}
	
	public int getUserNumber() {
		return userNumber;
	}
	
	public Boolean getUserWin() {
		return userWin;
	}

}
