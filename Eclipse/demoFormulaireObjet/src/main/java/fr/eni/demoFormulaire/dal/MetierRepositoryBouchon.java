package fr.eni.demoFormulaire.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.eni.demoFormulaire.bo.Metier;

@Repository
public class MetierRepositoryBouchon implements MetierRepository {

	private List<Metier> metiers;
	
	public MetierRepositoryBouchon() {
		metiers = new ArrayList<>();
		metiers.add(new Metier(1, "Vigneron.ne"));
		metiers.add(new Metier(2, "Estheticien.ne"));
		metiers.add(new Metier(3, "Bucheron.ne"));
	}
	
	
	@Override
	public List<Metier> findAllMetiers() {
		
		return metiers.stream().toList();
	}


	@Override
	public Optional<Metier> findMetierById(int id) {		
		return metiers.stream().filter(metier->metier.getId()==id).findFirst();
	}

}
