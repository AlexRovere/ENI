package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.Client;
import com.example.ludotheque.services.IClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    IClientService clientService;

    ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping({"/clients", "/"})
    public String clients(Model model) {
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        model.addAttribute("body", "pages/clients/clients");
        return "index";
    }

    @GetMapping("/clients/ajouter")
    public String pageAjouterClient(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("body", "pages/clients/ajouterClient");
        return "index";
    }

    @PostMapping("/clients/ajouter")
    public String ajouterClient(Model model, Client client) {
        clientService.add(client);
        model.addAttribute("body", "pages/clients/ajouterClient");
        return "redirect:/clients";
    }

    @GetMapping("/clients/modifier/{id}")
    public String getModifierClient(Model model, @PathVariable("id") int id) {
        Optional<Client> client = clientService.getById(id);
        if (client.isPresent()) {
            model.addAttribute("client", client);
            model.addAttribute("body", "pages/clients/modifierClient");

        } else {
            model.addAttribute("body", "pages/clients/clients");
        }
        return "index";
    }

    @PostMapping("/clients/modifier")
    public String postModifierClient(Model model, Client client) {
        System.out.println("controller update client");
        clientService.update(client);
        model.addAttribute("body", "pages/clients/clients");
        return "redirect:/clients";
    }

    @GetMapping("/clients/supprimer/{id}")
    public String supprimerClient(Model model, @PathVariable("id") int id) {
        clientService.delete(id);
        model.addAttribute("body", "pages/clients/clients");
        return "redirect:/clients";
    }
}
