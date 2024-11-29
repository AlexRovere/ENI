package nombreMystere.services;

import nombreMystere.bo.Partie;

public interface IPartieService {
	void tryNumber(Partie partie, int userNumber);
	void reset(Partie partie);
}
