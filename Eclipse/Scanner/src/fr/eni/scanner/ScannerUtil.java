package fr.eni.scanner;

import java.util.Scanner;

public class ScannerUtil {
	
	String test = "test";
	char test2 = 'a';
	
	

	public void askName() {
	System.out.println("Comment tou tapel ?");
	
	Scanner scanner = new Scanner(System.in);
	
	String prenom  = scanner.nextLine();
	
	System.out.printf("Bienvenue %s", prenom);
	
	scanner.close();
	}
}
