package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.GenreJeu;
import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.services.IGenreJeuService;
import com.example.ludotheque.services.IJeuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class JeuController {

    IJeuService jeuService;
    IGenreJeuService genreJeuService;

    JeuController(IJeuService jeuService, IGenreJeuService genreJeuService) {
        this.jeuService = jeuService;
        this.genreJeuService = genreJeuService;
    }

    @GetMapping("/jeux")
    public String getJeux(Model model) {
        List<Jeu> jeux = jeuService.getAll();
        model.addAttribute("jeux", jeux);
        model.addAttribute("body", "pages/jeux/jeux");
        return "index";
    }

    @GetMapping("/jeux/ajouter")
    public String getAjouterJeu(Model model) {
        model.addAttribute("jeu", new Jeu());
        model.addAttribute("genres", genreJeuService.getAll());
        model.addAttribute("body", "pages/jeux/ajouterJeu");
        return "index";
    }

    @PostMapping("/jeux/ajouter")
    public String postAjouterJeu(Model model, Jeu jeu) {
        jeuService.add(jeu);
        model.addAttribute("body", "pages/jeux/ajouterJeu");
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/modifier/{id}")
    public String getModifierJeu(Model model, @PathVariable("id") int id) {
        Optional<Jeu> jeu = jeuService.getById(id);
        if (jeu.isPresent()) {
            model.addAttribute("jeu", jeu);
            model.addAttribute("body", "pages/jeux/modifierJeu");

        } else {
            model.addAttribute("body", "pages/jeux/jeux");
        }
        return "index";
    }

    @PostMapping("/jeux/modifier")
    public String postModifierJeu(Model model, Jeu jeu) {
        System.out.println("controller update jeu");
        jeuService.update(jeu);
        model.addAttribute("body", "pages/jeux/jeux");
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/supprimer/{id}")
    public String supprimerJeu(Model model, @PathVariable("id") int id) {
        jeuService.delete(id);
        model.addAttribute("body", "pages/jeux/jeux");
        return "redirect:/jeux";
    }
}
