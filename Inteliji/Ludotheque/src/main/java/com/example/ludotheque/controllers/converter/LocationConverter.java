package com.example.ludotheque.controllers.converter;
import com.example.ludotheque.bo.Location;
import com.example.ludotheque.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocationConverter implements Converter<String, Location> {

    @Autowired
    private LocationService locationService;

    @Override
    public Location convert(String source) {
        int noLocation = Integer.parseInt(source);
        Optional<Location> optionalLocation = locationService.getById(noLocation);

        // Vérifier si l'Optional contient une valeur
        return optionalLocation.orElseThrow(() -> new IllegalArgumentException("Location jeu non trouvé pour l'ID: " + noLocation));    }
}