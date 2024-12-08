package com.example.ludotheque.controllers;

import com.example.ludotheque.Exception.EmailAlreadyTakenException;
import com.example.ludotheque.bo.Client;
import com.example.ludotheque.services.GenreService;
import com.example.ludotheque.services.IClientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController extends AuthController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final GenreService genreService;
    IClientService clientService;

    ClientController(IClientService clientService, GenreService genreService) {
        this.clientService = clientService;
        this.genreService = genreService;
    }

    @ModelAttribute("client")
    public Client createClient() {
        return  new Client();
    }

    @GetMapping("/clients")
    public String clients(Model model,  @RequestParam(value = "filter", required = false) String filter) {
        List<Client> clients = clientService.getAllWithFilters(filter);
        model.addAttribute("filter", "filter");
        model.addAttribute("clients", clients);
        model.addAttribute("body", "pages/clients/listeClient");
        return "index";
    }

    @GetMapping("/clients/ajouter")
    public String pageAjouterClient(Model model) {
        model.addAttribute("body", "pages/clients/enregistrerClient");
        return "index";
    }

    @PostMapping("/clients/ajouter")
    public String ajouterClient(Model model, @Valid @ModelAttribute("client") Client client, BindingResult result,
                                RedirectAttributes redirectAttr) {
        model.addAttribute("body", "pages/clients/enregistrerClient");

        try {

            clientService.isClientEmailTaken(client.getEmail());
            if(result.hasErrors()){
                redirectAttr.addFlashAttribute( "org.springframework.validation.BindingResult.client", result);
                redirectAttr.addFlashAttribute("client", client);
                return "redirect:/clients/ajouter";
            }
        } catch (EmailAlreadyTakenException e) {
            redirectAttr.addFlashAttribute("client", client);
            redirectAttr.addFlashAttribute("emailAlreadyTaken", e.getMessage());
            return "redirect:/clients/ajouter";
        }
        clientService.add(client);

        return "redirect:/clients";

    }

    @GetMapping("/clients/modifier/{noClient}")
    public String getModifierClient(Model model, @PathVariable("noClient") int noClient) {
        Optional<Client> client = clientService.getById(noClient);
        if (client.isPresent()) {
            model.addAttribute("client", client);
            model.addAttribute("body", "pages/clients/enregistrerClient");

        } else {
            model.addAttribute("body", "pages/clients/listeClient");
        }
        return "index";
    }

    @PostMapping("/clients/modifier")
    public String postModifierClient(Model model, Client client) {
        clientService.update(client);
        model.addAttribute("body", "pages/clients/listeClient");
        return "redirect:/clients";
    }

    @GetMapping("/clients/supprimer/{noClient}")
    public String supprimerClient(Model model, @PathVariable("noClient") int noClient) {
        clientService.delete(noClient);
        model.addAttribute("body", "pages/clients/listeClient");
        return "redirect:/clients";
    }

    @GetMapping("/clients/detail/{noClient}")
    public String detailClient(Model model, @PathVariable("noClient") int noClient) {
        Optional<Client> client = clientService.getById(noClient);
        if (client.isPresent()) {
            model.addAttribute("client", client);
            model.addAttribute("body", "pages/clients/detailClient");

        } else {
            model.addAttribute("body", "pages/clients/listeClient");
        }
        return "index";
    }
}
