package nombreMystere.services;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import nombreMystere.bo.Partie;

@Service
@SessionScope
public class PartieServiceImpl implements IPartieService {

	private int generateRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(0, 50 + 1) - 1;
		return randomNumber;
	}

	@Override
	public void tryNumber(Partie partie, int userNumber) {
		
		if(partie.getNewGame()) {
			partie.setComputerNumber(generateRandomNumber());
		}
		
		if(partie.getNumberOfTry() < Partie.MAX_TRY) {
			partie.setUserNumber(userNumber);
			
			if(partie.getUserNumber() == partie.getComputerNumber()) {
				// you win
				partie.setUserWin(true);
			}
		} else {
			partie.setUserWin(false);
			// perdu
		}

	}

	@Override
	public void reset(Partie partie) {
		// TODO Auto-generated method stub
	}
}
