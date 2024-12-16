package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.UserApplication;
import com.example.ludotheque.services.IUserApplicationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class UtilisateurController extends AuthController {

    private final IUserApplicationService userApplicationService;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurController(IUserApplicationService userApplicationService, PasswordEncoder passwordEncoder) {
        super();
        this.userApplicationService = userApplicationService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/utilisateurs")
    public String getUtilisateurs(Model model) {
        model.addAttribute("users", userApplicationService.getAll());
        model.addAttribute("body", "pages/utilisateurs/listeUtilisateur");
        return "index";
    }

    @GetMapping("/utilisateurs/ajouter")
    public String getAjouterUtilisateur(Model model) {
        List<String> roles = Arrays.asList("USER", "ADMIN");
        UserApplication user = new UserApplication();

            model.addAttribute("user", user);
            model.addAttribute("roles", roles);
            model.addAttribute("body", "pages/utilisateurs/enregistrerUtilisateur");
        return "index";
    }

    @PostMapping("/utilisateurs/ajouter")
    public String postAjouterUtilisateur(Model model, @ModelAttribute("UserApplication") UserApplication userApplication ) {
        String password = passwordEncoder.encode(userApplication.getPassword());
        userApplication.setPassword(password);
        userApplicationService.add(userApplication);
        return "redirect:/utilisateurs";
    }

    @GetMapping("/utilisateurs/modifier/{id}")
    public String getModifierUtilisateur(Model model, @PathVariable("id") int id) {
        List<String> roles = Arrays.asList("USER", "ADMIN");
        Optional<UserApplication> userApplicationOptional = userApplicationService.getById(id);
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
        Optional<UserApplication> userApplicationOptional = userApplicationService.getById(userApplication.getId());
        if(userApplicationOptional.isPresent()) {
            UserApplication oldUserApplication = userApplicationOptional.get();
            oldUserApplication.setRoles(userApplication.getRoles());
            userApplicationService.update(oldUserApplication);
        }
        return "redirect:/utilisateurs";
    }

    @GetMapping("/utilisateurs/supprimer/{id}")
    public String getUtilisateurs(Model model, @PathVariable("id") int id) {
        userApplicationService.delete(id);
        return "redirect:/utilisateurs";
    }
}
