package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.Image;
import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.bo.UserApplication;
import com.example.ludotheque.services.IUserApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class UtilisateurController extends AuthController {

    private final IUserApplicationService userApplicationService;

    public UtilisateurController(IUserApplicationService userApplicationService) {
        super();
        this.userApplicationService = userApplicationService;
    }

    @GetMapping("/utilisateurs")
    public String getUtilisateurs(Model model) {
        model.addAttribute("users", userApplicationService.getAll());
        model.addAttribute("body", "pages/utilisateurs/listeUtilisateur");
        return "index";
    }

    @GetMapping("/utilisateurs/modifier/{login}")
    public String getModifierUtilisateur(Model model, @PathVariable("login") String login) {
        List<String> roles = Arrays.asList("USER", "ADMIN");
        Optional<UserApplication> userApplicationOptional = userApplicationService.getByLogin(login);
        if(userApplicationOptional.isPresent()) {
            UserApplication userApplication = userApplicationOptional.get();
            model.addAttribute("user", userApplication);
            model.addAttribute("roles", roles);
            model.addAttribute("body", "pages/utilisateurs/enregistrerUtilisateur");

        } else {
            model.addAttribute("body", "pages/utilisateurs/listeUtilisateur");
        }

        return "index";
    }

    @PostMapping("/utilisateurs/modifier")
    public String postModifierUtilisateur(Model model, @ModelAttribute("UserApplication") UserApplication userApplication ) {
        userApplicationService.update(userApplication);
        model.addAttribute("body", "pages/jeux/listeJeu");
        return "redirect:/utilisateurs";
    }

    @GetMapping("/utilisateurs/supprimer/{login}")
    public String getUtilisateurs(Model model, @PathVariable("login") String login) {
        System.out.println(login);
        userApplicationService.deleteUser(login);
        return "redirect:/utilisateurs";
    }
}
