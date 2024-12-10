package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.UserApplication;
import com.example.ludotheque.security.UserDetailsServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends AuthController {

    private final UserDetailsServiceImpl demoUserDetailsServiceImpl;
    private PasswordEncoder passwordEncoder;

    LoginController(PasswordEncoder passwordEncoder, UserDetailsServiceImpl demoUserDetailsServiceImpl) {
        this.passwordEncoder = passwordEncoder;
        this.demoUserDetailsServiceImpl = demoUserDetailsServiceImpl;
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("body", "pages/security/login");
        return "index";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("body", "pages/security/sign-up");
        return "index";
    }

    @PostMapping("/sign-up")
    public String postSignUp(Model model, @RequestParam("login") String login, @RequestParam("password") String password) {
        UserApplication user = new UserApplication();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        demoUserDetailsServiceImpl.addUser(user);
        model.addAttribute("body", "pages/security/sign-up");
        return "index";
    }

}
