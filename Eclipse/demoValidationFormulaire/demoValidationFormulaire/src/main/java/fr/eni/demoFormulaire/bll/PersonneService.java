package fr.eni.demoFormulaire.bll;

import java.util.List;

import fr.eni.demoFormulaire.bo.Personne;

public interface PersonneService {

	void ajouterPersonne(Personne personne);

	List<Personne> findAllPersonnes();

	
}
