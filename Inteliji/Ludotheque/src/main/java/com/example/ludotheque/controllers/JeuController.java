package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.ExemplaireJeu;
import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.services.IExemplaireJeuService;
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
    IExemplaireJeuService exemplaireJeuService;

    JeuController(IJeuService jeuService, IGenreService genreService, IExemplaireJeuService exemplaireJeuService) {
        this.jeuService = jeuService;
        this.genreService = genreService;
        this.exemplaireJeuService = exemplaireJeuService;
    }

    @GetMapping("/jeux")
    public String getJeux(Model model) {
        List<Jeu> jeux = jeuService.getAll();
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
            model.addAttribute("jeu", jeu.get());
            model.addAttribute("allGenres", genreService.getAll());
            model.addAttribute("body", "pages/jeux/enregistrerJeu");
            model.addAttribute("listeExemplaire", "pages/jeux/listeExemplaire");
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
            model.addAttribute("jeu", jeu.get());
            model.addAttribute("allGenres", genreService.getAll());
            model.addAttribute("body", "pages/jeux/detailJeu");
            model.addAttribute("listeExemplaire", "pages/jeux/listeExemplaire");

        } else {
            model.addAttribute("body", "pages/jeux/listeJeu");
        }
        return "index";
    }

    @GetMapping("/jeux/exemplaire/ajouter/{noJeu}")
    public String getAjouterExemplaire(Model model,  @PathVariable("noJeu") int noJeu) {
        model.addAttribute("exemplaireJeu", new ExemplaireJeu(noJeu));
        model.addAttribute("body", "pages/jeux/enregistrerExemplaire");
        return "index";
    }


    @PostMapping("/jeux/exemplaire/ajouter")
    public String PostAjouterExemplaire(Model model, ExemplaireJeu exemplaire) {
        exemplaireJeuService.add(exemplaire);
        model.addAttribute("body", "pages/jeux/enregistrerExemplaire");
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/exemplaire/modifier/{noExemplaire}")
    public String getModifierExemplaire(Model model, @PathVariable("noExemplaire") int noExemplaire) {
        Optional<ExemplaireJeu> exemplaireJeu = exemplaireJeuService.getById(noExemplaire);
        if (exemplaireJeu.isPresent()) {
            model.addAttribute("exemplaireJeu", exemplaireJeu.get());
            model.addAttribute("allGenres", genreService.getAll());
            model.addAttribute("body", "pages/jeux/enregistrerExemplaire");

        } else {
            model.addAttribute("body", "pages/jeux/listeJeu");
        }
        return "index";
    }

    @PostMapping("/jeux/exemplaire/modifier")
    public String postModifierJeu(Model model, ExemplaireJeu exemplaireJeu) {
        exemplaireJeuService.update(exemplaireJeu);
        model.addAttribute("body", "pages/jeux/listeJeu");
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/exemplaire/supprimer/{noExemplaire}")
    public String supprimerExemplaire(Model model, @PathVariable("noExemplaire") int noExemplaire) {
        exemplaireJeuService.delete(noExemplaire);
        model.addAttribute("body", "pages/jeux/listeJeu");
        return "redirect:/jeux";
    }
}
