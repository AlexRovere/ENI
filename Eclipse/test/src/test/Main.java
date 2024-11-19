package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// 'Iterable <- Collection <- List <- ArrayList'
		
		// Nouvelle liste
		ArrayList<Object> listeArray = new ArrayList<>();
		
		
		// Cast ascendant (implicite)
		
		// On remonte vers List
		List<Object> listeList = listeArray;
		System.out.println("LISTE = " + listeList.getClass().getGenericSuperclass());

		
		// On remonte vers Collection
		Collection<Object> listeCollection =  listeArray;
		System.out.println("LISTE = " + listeArray.getClass().getSimpleName());

		
		// On remonte vers Iterable
		Iterable<Object> listeIterator =  listeArray;
		

		// donc si tu as une Liste tu peux la convertir en Iterable ou Iterable sans faire de cast(implicitement)
		// Pas besoin d'instancié Collection car c'est une Interface

		Iterable<Object> listeIterable = listeCollection;

		// Pour descendre vers ArrayList il faut que tu déclares le cast(explicitement)
		// Il faut vérifier que l'objet soit de la hiéarchie de List
		


		
		if (listeCollection instanceof Collection || listeCollection instanceof List || listeCollection instanceof Iterable) {
			listeArray = (ArrayList<Object>) listeCollection;
		}
		
		
		System.out.println(listeArray.getClass().getSimpleName());
	}
}
