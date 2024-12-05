package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.Genre;
import com.example.ludotheque.services.IGenreService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class GenreController {

    Logger logger = LoggerFactory.getLogger(GenreController.class);

    IGenreService genreService;

    GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String getGenres(Model model) {
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);
        model.addAttribute("body", "pages/genres/listeGenre");
        return "index";
    }

    @GetMapping("/genres/ajouter")
    public String getAjouterGenre(Model model) {
        logger.debug(genreService.getAll().toString());
        model.addAttribute("genre", new Genre());
        model.addAttribute("allGenres", genreService.getAll());
        model.addAttribute("body", "pages/genres/enregistrerGenre");
        return "index";
    }

    @PostMapping("/genres/ajouter")
    public String postAjouterGenre(Model model, Genre genre) {
        genreService.add(genre);
        model.addAttribute("body", "pages/genres/enregistrerGenre");
        return "redirect:/genres";
    }

    @GetMapping("/genres/modifier/{noGenre}")
    public String getModifierGenre(Model model, @PathVariable("noGenre") int noGenre) {
        Optional<Genre> genre = genreService.getById(noGenre);
        if (genre.isPresent()) {
            model.addAttribute("genre", genre.get());
            model.addAttribute("allGenres", genreService.getAll());
            model.addAttribute("body", "pages/genres/enregistrerGenre");
        } else {
            model.addAttribute("body", "pages/genres/listeGenre");
        }
        return "index";
    }

    @PostMapping("/genres/modifier")
    public String postModifierGenre(Model model, Genre genre) {
        genreService.update(genre);
        model.addAttribute("body", "pages/genres/listeGenre");
        return "redirect:/genres";
    }

    @GetMapping("/genres/supprimer/{noGenre}")
    public String supprimerGenre(Model model, @PathVariable("noGenre") int noGenre) {
        genreService.delete(noGenre);
        model.addAttribute("body", "pages/genres/listeGenre");
        return "redirect:/genres";
    }

}
