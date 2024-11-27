package com.example.ludotheque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/game", "/"})
    public String game(Model model) {
        model.addAttribute("body", "pages/game");
        return "index";
    }
}
