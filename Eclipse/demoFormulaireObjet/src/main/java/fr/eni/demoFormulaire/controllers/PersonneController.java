package fr.eni.demoFormulaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.demoFormulaire.bll.PersonneService;
import fr.eni.demoFormulaire.bo.Personne;

@Controller
public class PersonneController {
	
	
	private PersonneService personneService;

	@Autowired
	public PersonneController(PersonneService personneService) {
		super();
		this.personneService = personneService;
	}


	
	@PostMapping("/ajoutPersonne")	
	public String ajouterPersonne(
			//@ModelAttribute("personne") Personne personne	) {
			Personne personne	) {

			//Version avec DTO : 
			//			PersonneDTO personneDto) {
//		Personne personne = new Personne(personneDto.getNom(), 
//				personneDto.getPrenom(), 
//				personneDto.getAge());
//		personne.setMetier(new Metier(personneDto.getIdMetier()));

		personneService.ajouterPersonne(personne);
		
		
		return "redirect:/accueil"; //Redirection
	}
	
}
