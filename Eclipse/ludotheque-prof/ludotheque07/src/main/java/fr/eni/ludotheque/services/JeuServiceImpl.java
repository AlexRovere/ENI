package fr.eni.ludotheque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.GenreRepository;
import fr.eni.ludotheque.dal.JeuRepository;
import fr.eni.ludotheque.exceptions.CodebarreDejaExistantException;

@Service
public class JeuServiceImpl implements JeuService{

	private JeuRepository jeuRepo;
	private GenreRepository genreRepo;
	
	public JeuServiceImpl(JeuRepository jeuRepo, GenreRepository genreRepo) {
		this.jeuRepo = jeuRepo;
		this.genreRepo = genreRepo;
	}
	
	@Override
	public void add(Jeu entity) {
		
		jeuRepo.add(entity);
	}

	@Override
	public List<Jeu> getAll() {
		
		return jeuRepo.getAll();
	}

	@Override
	public Optional<Jeu> getById(int id) {
		Optional<Jeu> optJeu = jeuRepo.getById(id);
		
		//Recherche des exemplaires de jeu
		if(optJeu.isPresent()) {		
			Jeu jeu = optJeu.get();
			List<ExemplaireJeu> exemplaires = jeuRepo.getAllExemplaires(id);
			jeu.setExemplaires(exemplaires);
			optJeu=Optional.of(jeu);
		}
		
		return optJeu;
	}

	@Override
	public void update(Jeu entity) {
		jeuRepo.update(entity);
		
	}

	@Override
	public void save(Jeu jeu) {
		if(jeu.getNoJeu()!=null) {
			jeuRepo.update(jeu);
		}else {
			jeuRepo.add(jeu);
		}
		
	}

	@Override
	public void delete(int id) {
		jeuRepo.delete(id);
		
	}

	@Override
	public void addExemplaireJeu(ExemplaireJeu exemplaire) throws CodebarreDejaExistantException {
		jeuRepo.addExemplaireJeu(exemplaire);
		
	}

	@Override
	public List<ExemplaireJeu> getAllExemplaires(int noJeu) {
		
		return jeuRepo.getAllExemplaires(noJeu);
	}

	@Override
	public void deleteExemplaire(int id) {
		jeuRepo.deleteExemplaire(id);
		
	}

	
}
