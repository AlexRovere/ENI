package fr.eni.ludotheque.exceptions;

import org.springframework.dao.DuplicateKeyException;



public class CodebarreDejaExistantException extends Exception {

	
	
	public CodebarreDejaExistantException() {
		
	}
	
	public CodebarreDejaExistantException(DuplicateKeyException duplicateKeyException) {
		// TODO Auto-generated constructor stub
	}

}
