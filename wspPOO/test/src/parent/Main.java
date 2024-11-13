package parent;

public class Main {

	public static void main(String[] args) {
		
		// Parent parent = new Parent(); // IMPOSSIBLE car la classe est abstraite

		Enfant enfant_type_enfant = new Enfant(); // Instance d'enfant de type Enfant

		Parent enfant_type_parent = new Enfant(); // Instance d'enfant de type Parent

		// Méthode redéfini dans l'enfant (POLYMORPHISME)

		enfant_type_enfant.respirer(); // Appel la méthode "respirer" d'Enfant, sortie : "l'enfant respire"

		enfant_type_parent.respirer(); // POLYMORPHISME Appel la méthode "respirer" d'Enfant car elle a été rédéfini,
										// sortie : "l'enfant respire"

		// Méthode non redéfini dans l'enfant

		enfant_type_enfant.manger(); // Appel la méthode "manger" de parent car elle n'a pas été rédéfini dans
										// l'enfant, sortie : "le parent mange"

		enfant_type_parent.manger(); // Appel la méthode "manger" de parent, sortie : "le parent mange"

		// Méthode créer uniquement dans l'enfant

		enfant_type_enfant.jouer(); // Appel la méthode "jouer" d'enfant, sortie : "l'enfant joue"

		// enfant_type_parent.jouer(); // IMPOSSIBLE car la méthode jouer n'existe pas dans le type Parent
	}

}
