package com.example.ludotheque.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends AuthController {

    private PasswordEncoder passwordEncoder;

    LoginController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println(passwordEncoder.encode("password"));
        return "pages/security/login";
    }

    @PostMapping("/login")
    public String postLogin() {
        return "redirect:/jeux";
    }

}
