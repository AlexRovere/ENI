package dal.tools;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Contacts;
import data.Utilisateurs;

public class SerialiseurBinaire {
	/**
	 * désérialise le contenu du fichier binaire passé en paramètre
	 * @param fileName
	 * @return
	 */
	public static Utilisateurs importerUtilisateursFromBinary(String fileName) {
		File file = new File(fileName);
		Utilisateurs utilisateurs=null;
		FileInputStream fileInputStream=null;
		ObjectInputStream objectInputStream=null;
		
		try {
            // Deserialize Binary file into Java object.
		    fileInputStream = new FileInputStream(file);
		    objectInputStream = new ObjectInputStream(fileInputStream);
		    utilisateurs = (Utilisateurs) objectInputStream.readObject();
		    objectInputStream.close();
		    System.out.printf("Utilisateurs restaurés : %s%n", utilisateurs.toString());
		} catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
		}

		return utilisateurs;
	}
	
	/**
	 * sérialise au format binaire la classe Utilisateurs dans le fichier passé en paramètre
	 * @param fileName
	 * @param utilisateurs
	 */
	public static void exporterUtilisateursToBinary(String fileName, Utilisateurs utilisateurs) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		File file = new File(fileName);
		
		try {
            // Serialize Java object info binary file.
			fileOutputStream = new FileOutputStream(file);
		    objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(utilisateurs);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		    System.out.printf("Utilisateurs sauvegardés : %s%n", utilisateurs.toString());
		}catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * désérialise le contenu du fichier binaire passé en paramètre
	 * @param fileName
	 * @return
	 */
	public static Contacts importerContactsFromBinary(String fileName) {
		File file = new File(fileName);
		Contacts contacts=null;
		FileInputStream fileInputStream=null;
		ObjectInputStream objectInputStream=null;
		
		try {
            // Deserialize Binary file into Java object.
		    fileInputStream = new FileInputStream(file);
		    objectInputStream = new ObjectInputStream(fileInputStream);
		    contacts = (Contacts) objectInputStream.readObject();
		    objectInputStream.close();
		    System.out.printf("Contats restaurés : %s%n", contacts.toString());
		} catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
		}

		return contacts;
	}
	
	/**
	 * sérialise au format binaire la classe Contacts dans le fichier passé en paramètre
	 * @param fileName
	 * @param utilisateurs
	 */
	public static void exporterContactsToBinary(String fileName, Contacts contacts) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		File file = new File(fileName);
		
		try {
            // Serialize Java object info binary file.
			fileOutputStream = new FileOutputStream(file);
		    objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(contacts);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		    System.out.printf("Contacts sauvegardé : %s%n", contacts.toString());
		}catch (IOException e) {
            e.printStackTrace();
        }
	}


}
