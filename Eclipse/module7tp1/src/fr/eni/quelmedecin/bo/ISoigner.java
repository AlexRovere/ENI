package fr.eni.quelmedecin.bo;

public interface ISoigner {
	
	void orienter();
	
	default void examiner() {
		System.out.println("le médecin procède à des examens de\r\n"
				+ "routine sur les patients (auscultation, prise de tensions, ...) ");
	}
	
	default void diagnostiquer() {
		System.out.println("le médecin évalue l'état de santé du\r\n"
				+ "patient pour découvrir d'éventuels problèmes");
	}
	
	default void traiter() {
		System.out.println("le médecin met en place un traitement\r\n"
				+ "adapté");
	}
	
	default void conseiller() {
		System.out.println("le médecin dispense des conseils appropriés\r\n"
				+ "pour des habitudes saines (régime, hygiène, etc.)");
	}
}
