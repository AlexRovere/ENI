package module3TP2;

public class Utils {

	public static boolean formatNumeroTelephone(String input) {
		return input.matches("^\\d{2}(\\.\\d{2}){4}$");
	}

	public static String premiereEnMajuscule(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	};

}
