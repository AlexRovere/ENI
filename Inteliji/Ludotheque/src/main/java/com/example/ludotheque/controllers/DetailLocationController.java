package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.DetailLocation;
import com.example.ludotheque.bo.Location;
import com.example.ludotheque.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class DetailLocationController extends AuthController {

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    ILocationService locationService;
    IDetailLocationService detailLocationService;

    DetailLocationController(ILocationService locationService, IDetailLocationService detailLocationService) {
        this.locationService = locationService;
        this.detailLocationService = detailLocationService;
    }

    @GetMapping("/locations/lignes/ajouter/{noLocation}")
    public String getAjouterLigne(Model model,  @PathVariable("noLocation") int noLocation) {
        Optional<Location> locationOpt = locationService.getById(noLocation);
        if(locationOpt.isPresent()) {
            DetailLocation detailLocation = new DetailLocation();
            detailLocation.setLocation(locationOpt.get());
            model.addAttribute("detailLocation", detailLocation);
            model.addAttribute("body", "pages/detailLocation/enregistrerDetailLocation");
        } else {
            model.addAttribute("body", "pages/locations/listeLocation");
        }
        return "index";
    }

    @PostMapping("/locations/lignes/ajouter")
    public String postAjouterLigne(Model model, DetailLocation detailLocation) {
        detailLocationService.add(detailLocation);
        model.addAttribute("body", "pages/detailLocation/enregistrerDetailLocation");
        return "redirect:/locations";
    }

    @GetMapping("/locations/lignes/modifier/{noLigne}")
    public String getModifierDetailLocation(Model model, @PathVariable("noLigne") int noLigne) {
        Optional<DetailLocation> detailLocationOpt = detailLocationService.getById(noLigne);
        if (detailLocationOpt.isPresent()) {
            DetailLocation detailLocation = detailLocationOpt.get();
            int jeuSelected = detailLocation.getJeu().getNoJeu();
            model.addAttribute("jeuSelected", jeuSelected);
            model.addAttribute("detailLocation", detailLocation);
            model.addAttribute("body", "pages/detailLocation/enregistrerDetailLocation");
        } else {
            model.addAttribute("body", "pages/locations/listeLocation");
        }
        return "index";
    }

    @PostMapping("/locations/lignes/modifier")
    public String postModifierDetailLocation(Model model, DetailLocation detailLocation) {
        detailLocationService.update(detailLocation);
        model.addAttribute("body", "pages/locations/listeLocation");
        return "redirect:/locations";
    }

    @GetMapping("/locations/lignes/supprimer/{noLigne}")
    public String supprimerLocation(Model model, @PathVariable("noLigne") int noLigne) {
        detailLocationService.delete(noLigne);
        model.addAttribute("body", "pages/locations/listeLocation");

        return "redirect:/locations";
    }


}
