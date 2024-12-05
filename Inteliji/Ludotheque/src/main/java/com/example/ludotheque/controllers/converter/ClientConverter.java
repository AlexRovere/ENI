package com.example.ludotheque.controllers.converter;
import com.example.ludotheque.bo.Client;
import com.example.ludotheque.bo.Client;
import com.example.ludotheque.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientConverter implements Converter<String, Client> {

    @Autowired
    private ClientService clientService;

    @Override
    public Client convert(String source) {
        int noClient = Integer.parseInt(source);
        Optional<Client> optionalClient = clientService.getById(noClient);

        // Vérifier si l'Optional contient une valeur
        return optionalClient.orElseThrow(() -> new IllegalArgumentException("Client jeu non trouvé pour l'ID: " + noClient));    }
}