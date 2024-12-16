package fr.eni.ludotheque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.exceptions.CodebarreDejaExistantException;
import fr.eni.ludotheque.services.JeuService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/jeux")
public class ExemplaireController {

    private JeuService jeuService;

    public ExemplaireController(JeuService jeuService) {
        this.jeuService = jeuService;
    }

    @PostMapping("/{noJeu}/exemplaires/ajouter")
    public String ajouterExemplaire(
    		@PathVariable("noJeu") int noJeu,
    		Model model, @Valid ExemplaireJeu exemplaire, BindingResult bindingResult, RedirectAttributes redirectAttr) {
    	model.addAttribute("body", "pages/jeux/jeu");
    	if(bindingResult.hasErrors()) {
    		return "index";
    	}
    	
        try {
			jeuService.addExemplaireJeu(exemplaire);
		} catch (CodebarreDejaExistantException e) {
			redirectAttr.addFlashAttribute( "erreur", "codebarre déjà existant");
		}
        return "redirect:/jeux/" + exemplaire.getNoJeu() + "/afficher";
    }

    @GetMapping("/{noJeu}/exemplaires/{noExemplaireJeu}/supprimer")
    public String supprimerExemplaire(Model model, 
    		@PathVariable("noJeu") int noJeu,
    		@PathVariable("noExemplaireJeu") int noExemplaireJeu) {

        jeuService.deleteExemplaire(noExemplaireJeu);        
        return "redirect:/jeux/" + noJeu + "/afficher";

    }
}
