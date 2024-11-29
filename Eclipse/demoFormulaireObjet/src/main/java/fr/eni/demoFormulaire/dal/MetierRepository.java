package fr.eni.demoFormulaire.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.demoFormulaire.bo.Metier;


public interface MetierRepository {
	public List<Metier> findAllMetiers();
	
	public Optional<Metier> findMetierById(int id);
}
