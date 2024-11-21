package tests;

import dal.UtilisateurDao;
import dal.impl.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bo.Adresse;
import bo.Contact;
import bo.Personnel;
import bo.Professionnel;
import bo.Utilisateur;

//import dal.ContactDao;
//import dal.ContactFactoryDao;
//import dal.UtilisateurDao;
import dal.UtilisateurFactoryDao;
import dal.impl.UtilisateurBinaryImplDao;
import dal.impl.UtilisateurJsonImplDao;
import dal.tools.SerialiseurBinaire;
import dal.tools.SerialiseurJson;
import data.Contacts;
import data.Utilisateurs;

public class TestsInterface {

	public static void main(String[] args) {
		// PARTIE OBLIGATOIRE
		
		//1- tester la serialisation/déserialisation binaire des utilisateurs
		
		System.out.println("Partie 1 - serialisation/déserialisation binaire des utilisateurs.");
		//partie utilisateur
		List<Utilisateur> tempUsers = List.of( 
				new Utilisateur(1, "Ju", "Julie", "Pa$$w0rd"),
				new Utilisateur(2, "Cha", "Charline", "Pa$$w0rd"),
				new Utilisateur(3, "Jus", "Justin", "Pa$$w0rd"));
		Utilisateurs usersContainer = new Utilisateurs(tempUsers);
		SerialiseurBinaire.exporterUtilisateursToBinary("storage/utilisateurs.bin", usersContainer); //vérifier que le fichier à été créé
		
		Utilisateurs restoreBinaireUsers = SerialiseurBinaire.importerUtilisateursFromBinary("storage/utilisateurs.bin");
		System.out.println("==> Liste des utilisateurs restaurés depuis binaire");
		for (Utilisateur utilisateur : restoreBinaireUsers.utilisateurs()) {
			System.out.println(utilisateur.toString());
		}
		
		//2- tester l'implémentation de l'interface UtilisateurDao 
		UtilisateurDao dao = new UtilisateurBinaryImplDao();
		dao.selectBy("Ju", "Pa$$w0rd");
		dao = new UtilisateurJsonImplDao();
		dao.selectBy("Ju", "Pa$$w0rd");
		

		//3- tester le couplage faible en utilisant la factory de UtilisateurXXXImplDao
		//Constatez que vous appeliez bien la methode selectBy lié au contexte choisi
		UtilisateurDao utilisateurDao = UtilisateurFactoryDao.createInstance("binary"); //la classe test travaille avec une instance de UtilisateurBinaryImplDao
		Utilisateur utilisateurTrouve = utilisateurDao.selectBy("Ju", "Pa$$w0rd");
		System.out.printf("==> Utilisateur connecté : %s%n", (utilisateurTrouve != null) ? utilisateurTrouve.getNom(): "Utilisateur inconnu");
		utilisateurDao = UtilisateurFactoryDao.createInstance("json"); //la classe test travaille avec une instance de UtilisateurJsonImplDao
		utilisateurTrouve = utilisateurDao.selectBy("Ju", "Pa$$w0rd");
		System.out.printf("==> Utilisateur connecté : %s%n", (utilisateurTrouve != null) ? utilisateurTrouve.getNom(): "Utilisateur inconnu");
		
		
		
		//=> l'ideal serait de ne passer aucun paramètre à la méthode createInstance de la factory...
		//Le contexte pourrait être configuré dans un fichier de config exploité directement par la factory
		//(cf createInstance() sans paramètre dans la correction)
		
		
		
		// PARTIE OPTIONNELLE
		//1- tester la serialisation/déserialisation json des utilisateurs
		SerialiseurJson.exporterUtilisateursToJson("storage/utilisateurs.json", usersContainer); //vérifier que le fichier à été créé
		
		Utilisateurs restoreJsonUsers = SerialiseurJson.importerUtilisateursFromJson("storage/utilisateurs.json");
		System.out.println("==> Liste des utilisateurs restaurés depuis json");
		for (Utilisateur utilisateur : restoreJsonUsers.utilisateurs()) {
			System.out.println(utilisateur.toString());
		}
		
		//2-tester la serialisation/déserialisation binaire et json des contacts
//		Adresse a1 = new Adresse(1, "9 chemin des bois", "44000", "Nantes");
//		Adresse a2 = new Adresse(2, "1 rue de la forêt", "35000", "Rennes");
//		Adresse a3 = new Adresse(3, "2b rue Faraday", "44800", "Saint Herblain"); 
//		Contact c1 = new Personnel(1, "Tom", "0601020304", "tom@campus-eni.fr", a1, LocalDate.of(2000, 9, 22));
//		Contact c2 = new Personnel(2, "Felix", "0605060708", "felix@campus-eni.fr", a2, LocalDate.of(2005, 5, 10));
//		Contact c3 = new Professionnel(3, "Samuel", "0609101112", "samuel@campus-eni.fr", a3, "ENI Ecole");
//		Contact c4 = new Professionnel(4, "Jade", "0613141516", "jade@campus-eni.fr", a3, "ENI Ecole");
//		Contact c5 = new Professionnel(5, "Lauryne", "0617181920", "charline@campus-eni.fr", null, "Xpert");
//		List<Contact> tempContacts = new ArrayList<>();
//		tempContacts.add(c1);
//		tempContacts.add(c2);
//		tempContacts.add(c3);
//		tempContacts.add(c4);		
//		Contacts contactsContainer = new Contacts(tempContacts);
//		
//		//partie binaire
//		SerialiseurBinaire.exporterContactsToBinary("storage/contacts.bin", contactsContainer); //vérifier que le fichier à été créé
//		
//		Contacts restoreBinaireContacts = SerialiseurBinaire.importerContactsFromBinary("storage/contacts.bin");
//		System.out.println("==> Liste des contacts restaurés depuis binaire");
//		for (Contact contact : restoreBinaireContacts.contacts()) {
//			System.out.println(contact.toString());
//		}
//		
//		//partie json
//		SerialiseurJson.exporterContactsToJson("storage/contacts.json", contactsContainer); //vérifier que le fichier à été créé
//		
//		Contacts restoreJsonContacts = SerialiseurJson.importerContactsFromJson("storage/contacts.json");
//		System.out.println("Liste des contacts restaurés depuis json");
//		for (Contact contact : restoreJsonContacts.contacts()) {
//			System.out.println(contact.toString());
//		}
		
		//2- tester le couplage faible en utilisant la factory de ContactXXXImplDao
		//Constatez que vous appeliez bien la methode selectBy lié au contexte choisi
//		ContactDao contactDao = ContactFactoryDao.createInstance("binary"); //la classe test travaille avec une instance de ContactBinaryImplDao
//		contactDao.selectAll();
//		contactDao = ContactFactoryDao.createInstance("json"); //la classe test travaille avec une instance de ContactJsonImplDao
//		contactDao.selectAll();
	}

}
