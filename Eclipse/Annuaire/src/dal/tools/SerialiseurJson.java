package dal.tools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import data.Contacts;
import data.Utilisateurs;

public class SerialiseurJson {
	public static Utilisateurs importerUtilisateursFromJson(String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		Utilisateurs utilisateurs=null;
		try {
            // Deserialize JSON file into Java object.
			Path filePath = Path.of(fileName);
			String jsonUtilisateurs = Files.readString(filePath);
			utilisateurs = mapper.readValue(jsonUtilisateurs, Utilisateurs.class);
			System.out.printf("Utilisateurs restaurés : %s%n", jsonUtilisateurs);
        }catch (IOException e) {
            e.printStackTrace();
        }
		return utilisateurs;
	}
	
	public static void exporterUtilisateursToJson(String fileName, Utilisateurs utilisateurs) {
		ObjectMapper mapper = new ObjectMapper();    
		mapper.registerModule(new JavaTimeModule());
        try {
            // Serialize Java object info JSON file.
        	String jsonUtilisateurs = mapper.writeValueAsString(utilisateurs);
        	Path filePath = Path.of(fileName);
			Files.writeString(filePath, jsonUtilisateurs, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
			System.out.printf("Utilisateurs sauvegardés : %s%n", jsonUtilisateurs);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static Contacts importerContactsFromJson(String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		Contacts contacts=null;
		try {
            // Deserialize JSON file into Java object.
			Path filePath = Path.of(fileName);
			String jsonContacts = Files.readString(filePath);
			contacts = mapper.readValue(jsonContacts, Contacts.class);
			System.out.printf("Contacts restaurés : %s%n", jsonContacts);
        }catch (IOException e) {
            e.printStackTrace();
        }
		return contacts;
	}
	
	public static void exporterContactsToJson(String fileName,Contacts contacts) {
		ObjectMapper mapper = new ObjectMapper();  
		mapper.registerModule(new JavaTimeModule());
        try {
            // Serialize Java object info JSON file.
        	String jsonContacts = mapper.writeValueAsString(contacts);
        	Path filePath = Path.of(fileName);
			Files.writeString(filePath, jsonContacts, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
			System.out.printf("Contacts sauvegardés : %s%n", jsonContacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
