package fr.eni.quelmedecin.exception;

public class UtilisateurException extends Exception {

	private static final long serialVersionUID = 521203754125805885L;

	public UtilisateurException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilisateurException(String message) {
		super(message);
	}
}
