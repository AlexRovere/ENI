package fr.eni.demoFormulaire.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.demoFormulaire.bo.Personne;

@Repository
public class PersonneRepositoryBouchonImpl implements PersonneRepository{

	private static int indexPersonne=1;
	private List<Personne> personnes;
	
	public PersonneRepositoryBouchonImpl() {
		personnes = new ArrayList<>();
	}
	
	@Override
	public void ajouterPersonne(Personne personne) {
		personne.setId(indexPersonne++);
		personnes.add(personne);

	}

	@Override
	public List<Personne> findAllPersonnes() {
		return this.personnes;
	}

}
