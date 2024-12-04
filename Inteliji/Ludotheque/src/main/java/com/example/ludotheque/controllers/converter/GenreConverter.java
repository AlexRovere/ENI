package com.example.ludotheque.controllers.converter;
import com.example.ludotheque.bo.Genre;
import com.example.ludotheque.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GenreConverter implements Converter<String, Genre> {

    @Autowired
    private GenreService genreService;  // Service pour récupérer les genres en base de données

    @Override
    public Genre convert(String source) {
        int noGenre = Integer.parseInt(source);
        Optional<Genre> optionalGenre = genreService.getById(noGenre);

        // Vérifier si l'Optional contient une valeur
        return optionalGenre.orElseThrow(() -> new IllegalArgumentException("Genre jeu non trouvé pour l'ID: " + noGenre));    }
}