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
        if(!model.containsAttribute("client")) {
            model.addAttribute("client", new Client());
        }
        model.addAttribute("body", "pages/clients/enregistrerClient");
        return "index";
    }

    @PostMapping("/clients/ajouter")
    public String ajouterClient(Model model, @Valid @ModelAttribute("client") Client client, BindingResult result,
                                RedirectAttributes redirectAttr) {
        model.addAttribute("body", "pages/clients/enregistrerClient");
        try {
            clientService.isClientEmailTaken(client.getEmail());
        } catch (EmailAlreadyTakenException e) {
            result.rejectValue("email", null, e.getMessage());
        }
        if(result.hasErrors()){
            redirectAttr.addFlashAttribute( "org.springframework.validation.BindingResult.client", result);
            redirectAttr.addFlashAttribute("client", client);
            return "redirect:/clients/ajouter";
        }
        clientService.add(client);

        return "redirect:/clients";

    }

    @GetMapping("/clients/modifier/{noClient}")
    public String getModifierClient(Model model, @PathVariable("noClient") int noClient, RedirectAttributes redirectAttr) {
        if(!model.containsAttribute("client")) {
            Optional<Client> client = clientService.getById(noClient);
            if (client.isPresent()) {
                model.addAttribute("client", client);
                model.addAttribute("body", "pages/clients/enregistrerClient");
            } else {
                model.addAttribute("body", "pages/clients/listeClient");
            }
        } else {
            model.addAttribute("body", "pages/clients/enregistrerClient");
        }
        return "index";
    }

    @PostMapping("/clients/modifier")
    public String postModifierClient(Model model, @Valid @ModelAttribute("client") Client client, BindingResult result, RedirectAttributes redirectAttr) {
        model.addAttribute("body", "pages/clients/listeClient");

        Optional<Client> oldClientOptional = clientService.getById(client.getNoClient());
        if(oldClientOptional.isPresent()) {
            Client oldClient = oldClientOptional.get();
            if(!oldClient.getEmail().equals(client.getEmail())) {
                try {
                    clientService.isClientEmailTaken(client.getEmail());
                } catch (EmailAlreadyTakenException e) {
                    result.rejectValue("email", null, e.getMessage());
                }
            }
                if(result.hasErrors()){
                    redirectAttr.addFlashAttribute( "org.springframework.validation.BindingResult.client", result);
                    redirectAttr.addFlashAttribute("client", client);
                    return "redirect:/clients/modifier/" + client.getNoClient();
                }
                clientService.update(client);
                return "redirect:/clients";
        } else {
            model.addAttribute("client", client);
            model.addAttribute("body", "pages/clients/enregistrerClient");
        }
        return "index";
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
