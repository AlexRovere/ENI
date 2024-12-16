package fr.eni.ludotheque.services;

import java.util.List;

import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.exceptions.CodebarreDejaExistantException;


public interface JeuService extends ICrudService <Jeu>{

	void addExemplaireJeu(ExemplaireJeu exemplaire) throws CodebarreDejaExistantException;
	
	public List<ExemplaireJeu> getAllExemplaires(int noJeu);

	void deleteExemplaire(int id);

}
