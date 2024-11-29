package fr.eni.demoFormulaire.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.demoFormulaire.bo.Metier;
import fr.eni.demoFormulaire.dal.MetierRepository;

@Component
public class StringToMetierConverter implements Converter<String, Metier>{

	@Autowired
	private MetierRepository metierRepo;
	
	@Override
	public Metier convert(String idMetier) {
		int id = Integer.parseInt(idMetier);
		
		Optional<Metier> optMetier = metierRepo.findMetierById(id);
		
		if(optMetier.isEmpty()) {
			throw new RuntimeException("Metier non trouvé");
		}
		
		return optMetier.get();
	}

}
