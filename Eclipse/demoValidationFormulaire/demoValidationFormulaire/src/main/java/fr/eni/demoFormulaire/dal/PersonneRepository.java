package fr.eni.demoFormulaire.dal;

import java.util.List;

import fr.eni.demoFormulaire.bo.Personne;


public interface PersonneRepository {
	public void ajouterPersonne(Personne personne);

	public List<Personne> findAllPersonnes();
}
