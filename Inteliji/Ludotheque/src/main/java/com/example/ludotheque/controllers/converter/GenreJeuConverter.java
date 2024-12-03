package com.example.ludotheque.controllers.converter;
import com.example.ludotheque.bo.GenreJeu;
import com.example.ludotheque.services.GenreJeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GenreJeuConverter implements Converter<String, GenreJeu> {

    @Autowired
    private GenreJeuService genreJeuService;  // Service pour récupérer les genres en base de données

    @Override
    public GenreJeu convert(String source) {
        int noGenre = Integer.parseInt(source);
        Optional<GenreJeu> optionalGenreJeu = genreJeuService.getById(noGenre);

        // Vérifier si l'Optional contient une valeur
        return optionalGenreJeu.orElseThrow(() -> new IllegalArgumentException("Genre jeu non trouvé pour l'ID: " + noGenre));    }
}