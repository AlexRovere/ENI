package fr.eni.ludotheque.dal;

import java.util.List;

import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.exceptions.CodebarreDejaExistantException;

public interface JeuRepository extends ICrudRepository<Jeu>{
	List<Genre> getGenresByNoJeu(Integer noJeu);

	void addExemplaireJeu(ExemplaireJeu exemplaire) throws CodebarreDejaExistantException;

	List<ExemplaireJeu> getAllExemplaires(int noJeu);

	void deleteExemplaire(int id);
}
