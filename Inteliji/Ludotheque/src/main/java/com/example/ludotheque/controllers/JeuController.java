package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.services.IGenreService;
import com.example.ludotheque.services.IJeuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JeuController {

    Logger logger = LoggerFactory.getLogger(JeuController.class);

    IJeuService jeuService;
    IGenreService genreService;

    JeuController(IJeuService jeuService, IGenreService genreService) {
        this.jeuService = jeuService;
        this.genreService = genreService;
    }

    @GetMapping("/jeux")
    public String getJeux(Model model) {
        List<Jeu> jeux = jeuService.getAll();
        jeux.forEach(j -> {
            System.out.println(j.getExemplaires());
            System.out.println(j.getGenres());

        });
        model.addAttribute("jeux", jeux);
        model.addAttribute("body", "pages/jeux/listeJeu");
        return "index";
    }

    @GetMapping("/jeux/ajouter")
    public String getAjouterJeu(Model model) {
        logger.debug(genreService.getAll().toString());
        model.addAttribute("jeu", new Jeu());
        model.addAttribute("allGenres", genreService.getAll());
        model.addAttribute("body", "pages/jeux/enregistrerJeu");
        return "index";
    }

    @PostMapping("/jeux/ajouter")
    public String postAjouterJeu(Model model, Jeu jeu) {
        jeuService.add(jeu);
        model.addAttribute("body", "pages/jeux/enregistrerJeu");
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/modifier/{noJeu}")
    public String getModifierJeu(Model model, @PathVariable("noJeu") int noJeu) {
        Optional<Jeu> jeu = jeuService.getById(noJeu);
        if (jeu.isPresent()) {
            model.addAttribute("jeu", jeu);
            model.addAttribute("allGenres", genreService.getAll());
            model.addAttribute("body", "pages/jeux/enregistrerJeu");

        } else {
            model.addAttribute("body", "pages/jeux/listeJeu");
        }
        return "index";
    }

    @PostMapping("/jeux/modifier")
    public String postModifierJeu(Model model, Jeu jeu) {
        jeuService.update(jeu);
        model.addAttribute("body", "pages/jeux/listeJeu");
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/supprimer/{noJeu}")
    public String supprimerJeu(Model model, @PathVariable("noJeu") int noJeu) {
        jeuService.delete(noJeu);
        model.addAttribute("body", "pages/jeux/listeJeu");
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/detail/{noJeu}")
    public String detailJeu(Model model, @PathVariable("noJeu") int noJeu) {
        Optional<Jeu> jeu = jeuService.getById(noJeu);
        if (jeu.isPresent()) {
            model.addAttribute("jeu", jeu);
            model.addAttribute("allGenres", genreService.getAll());
            model.addAttribute("body", "pages/jeux/detailJeu");

        } else {
            model.addAttribute("body", "pages/jeux/listeJeu");
        }
        return "index";
    }
}
