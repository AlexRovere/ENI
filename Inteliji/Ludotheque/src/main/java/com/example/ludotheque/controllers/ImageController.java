package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.Image;
import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.dal.ImageRepository;
import com.example.ludotheque.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ImageController extends AuthController {

    private final ImageRepository imageRepository;
    private final ImageService imageService;

    ImageController(ImageRepository imageRepository, ImageService imageService) {
        this.imageRepository = imageRepository;
        this.imageService = imageService;
    }

    @GetMapping("/img")
    public String getImage(Model model) throws IOException {
        model.addAttribute("body", "pages/images/listeImage");
        Iterable<Image> images = imageRepository.findAll();
        model.addAttribute("images", images);
        return "index";
    }

    @GetMapping("/img/ajouter")
    public String getAjouterImage(Model model) {
        model.addAttribute("body", "pages/images/enregistrerImage");
        return "index";
    }

    @PostMapping("/img/ajouter")
    public String postAjouterImage(Model model, @RequestParam MultipartFile img, @RequestParam("fileName") String fileName) {
        Image image = new Image();
        image.setFileName(fileName);
        image.setMimeType(img.getContentType());
        try {
            image.setData(img.getBytes());
            imageRepository.save(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("body", "pages/images/enregistrerImage");
        return "redirect:/img";
    }

    @GetMapping("/img/modifier/{id}")
    public String getModifierImage(Model model, @PathVariable("id") int id) {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isPresent()) {
            model.addAttribute("image", image.get());
            model.addAttribute("body", "pages/images/enregistrerImage");
        } else {
            model.addAttribute("body", "pages/images/listeImage");
        }
        return "index";
    }

    @PostMapping("/img/modifier")
    public String postModifierImage(Model model, @RequestParam MultipartFile img, @RequestParam("fileName") String fileName, @RequestParam("imageId") int id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            image.setFileName(fileName);
            try {
                // Update si nouvelle image
                if(!img.isEmpty()){
                image.setData(img.getBytes());
                }
                imageRepository.save(image);
                model.addAttribute("body", "pages/images/enregistrerImage");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            model.addAttribute("body", "pages/images/listeImage");
        }
        return "redirect:/img";
    }

    @GetMapping("/img/supprimer/{id}")
    public String deleteImg(Model model, @PathVariable("id") int id) {
        Optional<Image> image = imageRepository.findById(id);
        image.ifPresent(imageRepository::delete);
        return "redirect:/img";
    }
}
