package fr.eni.demoFormulaire.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.demoFormulaire.bll.PersonneService;
import fr.eni.demoFormulaire.bo.Personne;
import jakarta.validation.Valid;

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
			@Valid @ModelAttribute("personne") Personne personne, BindingResult resultat, Model modele, RedirectAttributes redirectAttr) {
		//Personne personne = new Personne(nom, prenom, age);

		List<Personne> personnes = personneService.findAllPersonnes();		
		modele.addAttribute("personnes", personnes);
		
		if(resultat.hasErrors()) {
			
			redirectAttr.addFlashAttribute( "org.springframework.validation.BindingResult.personne", resultat);
			redirectAttr.addFlashAttribute("personne", personne);
			//return "accueil";
			return "redirect:/accueil";
		}

		
		personneService.ajouterPersonne(personne);
		
		
		
		//return "accueil";//délégation de traitement
		return "redirect:/accueil"; //Redirection
	}
	
}
