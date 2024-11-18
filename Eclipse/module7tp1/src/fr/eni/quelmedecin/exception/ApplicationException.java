package fr.eni.quelmedecin.exception;

public class ApplicationException extends Exception {

	static final long serialVersionUID = 4422194464517828203L;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
		System.out.println(message);

	}

}
