package fr.eni.demoFormulaire.dal;

import java.util.List;

import fr.eni.demoFormulaire.bo.Metier;


public interface MetierRepository {
	public List<Metier> findAllMetiers();
}
