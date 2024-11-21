package bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.Contacts;
import data.Utilisateurs;


public class TestsBo {

	public static void main(String[] args) {		
		System.out.println("Partie 1 - Tests de la couche métier.");
		//partie utilisateur
		List<Utilisateur> tempUsers = List.of( 
				new Utilisateur(1, "Ju", "Julie", "Pa$$w0rd"),
				new Utilisateur(2, "Cha", "Charline", "Pa$$w0rd"),
				new Utilisateur(3, "Jus", "Justin", "Pa$$w0rd"));
		Utilisateurs usersContainer = new Utilisateurs(tempUsers);
		System.out.println("Les utilisateurs");
		for (Utilisateur utilisateur : usersContainer.utilisateurs()) {
			System.out.println(utilisateur.toString());
		}
		
		//partie métier
		Adresse a1 = new Adresse(1, "9 chemin des bois", "44000", "Nantes");
		Adresse a2 = new Adresse(2, "1 rue de la forêt", "35000", "Rennes");
		Adresse a3 = new Adresse(3, "2b rue Faraday", "44800", "Saint Herblain"); 
		
		System.out.println("a1 : " + a1);
		System.out.println("a2 : " + a2);
		System.out.println("a3 : " + a3);
		
		Contact c1 = new Personnel(1, "Tom", "0601020304", "tom@campus-eni.fr", a1, LocalDate.of(2000, 9, 22));
		Contact c2 = new Personnel(2, "Felix", "0605060708", "felix@campus-eni.fr", a2, LocalDate.of(2005, 5, 10));
		Contact c3 = new Professionnel(3, "Samuel", "0609101112", "samuel@campus-eni.fr", a3, "ENI Ecole");
		Contact c4 = new Professionnel(4, "Jade", "0613141516", "jade@campus-eni.fr", a3, "ENI Ecole");
		Contact c5 = new Professionnel(5, "Lauryne", "0617181920", "charline@campus-eni.fr", null, "Xpert");

		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("c3 : " + c3);
		System.out.println("c4 : " + c4);
		System.out.println("c5 : " + c5);
		
		//Polymorphisme
		List<Contact> tempContacts = new ArrayList<>();
		tempContacts.add(c1);
		tempContacts.add(c2);
		tempContacts.add(c3);
		tempContacts.add(c4);		
		Contacts contactsContainer = new Contacts(tempContacts);
		System.out.println("Les contacts");
		for (Contact contact : contactsContainer.contacts()) {
			System.out.println(contact.toString());
		}
		

	}

}
