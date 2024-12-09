package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.Location;
import com.example.ludotheque.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class LocationController extends AuthController {

    private final IClientService clientService;
    private final ToolsService toolsService;
    private final IJeuService jeuService;
    private final ILocationService locationService;
    private final Logger logger = LoggerFactory.getLogger(LocationController.class);

    LocationController(IJeuService jeuService, ILocationService locationService, ClientService clientService, ToolsService toolsService) {
        this.locationService = locationService;
        this.jeuService = jeuService;
        this.clientService = clientService;
        this.toolsService = toolsService;
    }

    @GetMapping("/locations")
    public String getLocations(Model model) {
        List<Location> locations = locationService.getAll();
        model.addAttribute("locations", locations);
        model.addAttribute("body", "pages/locations/listeLocation");
        return "index";
    }

    @GetMapping("/locations/ajouter")
    public String getAjouterLocation(Model model) {
        logger.debug(locationService.getAll().toString());
        model.addAttribute("location", new Location());
        model.addAttribute("body", "pages/locations/enregistrerLocation");

        return "index";
    }

    @PostMapping("/locations/ajouter")
    public String postAjouterLocation(Model model, Location location) {
        locationService.add(location);
        model.addAttribute("body", "pages/locations/enregistrerLocation");
        return "redirect:/locations";
    }

    @GetMapping("/locations/modifier/{noLocation}")
    public String getModifierLocation(Model model, @PathVariable("noLocation") int noLocation) {
        Optional<Location> locationOpt = locationService.getById(noLocation);
        if (locationOpt.isPresent()) {
            Location location = locationOpt.get();
            int clientSelected = location.getClient().getNoClient();
            model.addAttribute("clientSelected", clientSelected);
            model.addAttribute("location", location);
            model.addAttribute("body", "pages/locations/enregistrerLocation");
            model.addAttribute("listeDetailLocation", "pages/locations/listeDetailLocation");
        } else {
            model.addAttribute("body", "pages/locations/listeLocation");
        }
        return "index";
    }

    @PostMapping("/locations/modifier")
    public String postModifierLocation(Model model, Location location) {
        locationService.update(location);
        model.addAttribute("body", "pages/locations/listeLocation");
        return "redirect:/locations";
    }

    @GetMapping("/locations/supprimer/{noLocation}")
    public String supprimerLocation(Model model, @PathVariable("noLocation") int noLocation) {
        locationService.delete(noLocation);
        model.addAttribute("body", "pages/locations/listeLocation");

        return "redirect:/locations";
    }

    @GetMapping("/locations/detail/{noLocation}")
    public String detailLocation(Model model, @PathVariable("noLocation") int noLocation) {
        Optional<Location> locationOpt = locationService.getById(noLocation);
        if (locationOpt.isPresent()) {
            LocalDate testDate = LocalDate.now();
            Location location = locationOpt.get();
            model.addAttribute("testDate", testDate);
            model.addAttribute("location", location);
            model.addAttribute("body", "pages/locations/detailLocation");
            model.addAttribute("listeDetailLocation", "pages/locations/listeDetailLocation");

        } else {
            model.addAttribute("body", "pages/locations/listeLocation");
        }
        return "index";
    }


}
