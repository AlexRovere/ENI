package fr.eni.demoFormulaire.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.demoFormulaire.bo.Personne;
import fr.eni.demoFormulaire.dal.PersonneRepository;

@Service
public class PersonneServiceImpl implements PersonneService{

	private PersonneRepository personneRepo;
		
	@Autowired
	public PersonneServiceImpl(PersonneRepository personneRepo) {
		super();
		this.personneRepo = personneRepo;
	}

	
	@Override
	public void ajouterPersonne(Personne personne) {
		personneRepo.ajouterPersonne(personne);
	}


	@Override
	public List<Personne> findAllPersonnes() {
		return personneRepo.findAllPersonnes();
	}


}
