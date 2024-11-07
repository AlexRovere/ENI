
public class Methode {

	/**
	 * Constructeur privé
	 */
	private Methode() {}

	/**
	 * Fabrique par methode de classe
	 * @return
	 */
	public static Methode getMethode() {
		return new Methode();
	}
	
    /**
     * Methode permettant pour chaque première lettre des mots de la chaine d'être transformé
     * en majuscule. Les séparateurs de mot doivent être précisés.
     * @param chaine : chaine de caractères à formater
     * @param separateurs : une chaine de caractères regoupant les séparateurs
     * @return une chaine formaté avec la première lettre de chaque mot en majuscule
     */
    public String premiereEnMajuscule(String chaine, String separateurs) {
    	char[] prenomOrigine = chaine.toCharArray();
    	char[] prenomFormate = new char[prenomOrigine.length];
    	int pos = 0;
    	boolean enMaj = true;
    	boolean sep = false;
    	
    	for (char c : prenomOrigine) {
			//le char est-il un des séparateurs
    		if (separateurs.contains(String.valueOf(c))){
    			sep = true;
    		} else {
    			sep = false;
    		}
    		//inscrire le caractère dans le prenomFormate
    		if (sep){
    			//si c'est un séparateur, il est inscrit tel quel...
    			prenomFormate[pos]=c;
    			enMaj=true;
    		}else if (enMaj){
    			//si c'est un caractère qui suit un séparateur, inscrit en majuscules...
    			prenomFormate[pos]=Character.toUpperCase(c);
    			enMaj=false;
    		}else {
    			//sinon inscrit en minuscules...
    			prenomFormate[pos]=Character.toLowerCase(c);
    		}
    		pos++;
		}
    	return String.valueOf(prenomFormate);
    	
    }
    
    /**
     * Methode permettant de contrôler et de formater le numero de telephone
     * - reçue sur 10 caractères
	 * - ne contient que des caractères numériques
	 * - livré au format ##.##.##.##.##
	 * @param numeroTelephone
     * @return le numéro de telephone formaté
     */
    public String formatNumeroTelephone(String numeroTelephone) {
    	String erreur = "<< numero incorrect >>";
    	String numTelFormat="";
    	@SuppressWarnings("unused")
		int numero = 0;
		int position = 0;
    	
    	if (numeroTelephone!= null) {
			if (numeroTelephone.length() != 10) {
				System.err.println("Le numero de téléphone "+numeroTelephone+" n'est pas conforme !");
				numTelFormat= erreur;
            } else {
            	try {
					numero = Integer.parseInt(numeroTelephone);
					// 0123456789 => 01.23.45.67.89
					for (char car : numeroTelephone.toCharArray()) {
						numTelFormat += String.valueOf(car);
						switch (position){
						case 1:
						case 3:
						case 5:
						case 7:
							numTelFormat += ".";
							break;
						}
						position++;
					}
				} catch (NumberFormatException e) {
					System.err.println("Le numero de téléphone "+numeroTelephone+" n'est pas conforme !");
					numTelFormat= erreur;
				}
			}
    	} else {
            System.err.println("Le numéro de téléphone est obligatoire !");
            numTelFormat= erreur;
        }
		return numTelFormat;
    }
}
