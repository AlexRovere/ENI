package com.example.ludotheque.controllers.converter;
import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.services.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JeuConverter implements Converter<String, Jeu> {

    @Autowired
    private JeuService jeuService;

    @Override
    public Jeu convert(String source) {
        int noJeu = Integer.parseInt(source);
        Optional<Jeu> optionalJeu = jeuService.getById(noJeu);

        return optionalJeu.orElseThrow(() -> new IllegalArgumentException("Jeu jeu non trouvé pour l'ID: " + noJeu));    }
}