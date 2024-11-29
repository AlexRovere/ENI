package nombreMystere.bo;

public class Partie {
	public static final int MAX_TRY = 5;
	

	private int userNumber;
	private int computerNumber;
	private Boolean isUserWin;
	private String helper;
	private String resultat;
	private int numberOfTry = 0;
	private Boolean newGame = true;
	
	public int getNumberOfTry() {
		return numberOfTry;
	}

	public void setNumberOfTry(int numberOfTry) {
		this.numberOfTry = numberOfTry;
	}

	public Boolean getNewGame() {
		return newGame;
	}

	public void setNewGame(Boolean newGame) {
		this.newGame = newGame;
	}

	public Partie() {
		super();
	}
	
	public Partie(int userNumber, int computerNumber) {
		super();
		this.userNumber = userNumber;
		this.computerNumber = computerNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getComputerNumber() {
		return computerNumber;
	}
	public void setComputerNumber(int computerNumber) {
		this.computerNumber = computerNumber;
	}
	public Boolean getUserWin() {
		return isUserWin;
	}
	public void setUserWin(Boolean userWin) {
		this.isUserWin = userWin;
	}
	public Boolean getIsUserWin() {
		return isUserWin;
	}

	public void setIsUserWin(Boolean isUserWin) {
		this.isUserWin = isUserWin;
	}

	public String getHelper() {
		return helper;
	}
	public void setHelper(String helper) {
		this.helper = helper;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	

}
