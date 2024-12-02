package fr.eni.demoFormulaire.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.eni.demoFormulaire.bll.PersonneService;
import fr.eni.demoFormulaire.bo.Personne;

@Controller
public class AccueilController {

	private PersonneService personneService; 
	
	public AccueilController(PersonneService personneService) {
		super();
		this.personneService = personneService;
	}

	@ModelAttribute("personne")
	public Personne createPersonne() {
		Personne p = new Personne();
		p.setNom("le nom");
		p.setPrenom("le prenom");
		p.setAge(33);
		return p;
	}

	@GetMapping({"/", "/accueil"})
	public String accueil(Model model) {
		
		List<Personne> personnes = personneService.findAllPersonnes();
		
		model.addAttribute("personnes", personnes);
		
		return "accueil";
	}
	
}
