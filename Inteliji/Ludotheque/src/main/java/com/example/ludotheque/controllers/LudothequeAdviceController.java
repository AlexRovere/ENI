package com.example.ludotheque.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LudothequeAdviceController extends AuthController {
    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        logger.debug(ex.getMessage());
        model.addAttribute("body", "pages/erreur");
        return "index";
    };
}
