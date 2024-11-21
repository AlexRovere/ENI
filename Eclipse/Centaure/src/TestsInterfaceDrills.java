import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestsInterfaceDrills {

	public static void main(String[] args) {
		System.out.println("***** cheval *****");
		Cheval tornado = new Cheval();
		tornado.communiquer();
		tornado.dormir();
		tornado.galoper();

		System.out.println("***** humain *****");
		Humain zorro = new Humain();
		zorro.communiquer();
		zorro.dormir();
		zorro.siffler();

		// DECOMMENTER POUR LA QUESTION 6
		System.out.println("***** oiseau *****");
		Oiseau titi = new Oiseau();
		titi.siffler();
		titi.communiquer();
		titi.dormir();
		
		Animal anonyme1 = tornado ;
		anonyme1.communiquer() ;
		Animal anonyme2 = zorro ;
		anonyme2.communiquer() ;
		
		Humain inconnu = (Humain) anonyme2 ;
		inconnu.siffler() ;
		
		List<Animal> liste = new ArrayList<Animal>();
		
		liste.add(anonyme1);
		liste.add(anonyme2);
		liste.add(tornado);
		liste.add(zorro);
	}

}
