package com.example.ludotheque.controllers;

import com.example.ludotheque.bo.Image;
import com.example.ludotheque.bo.dto.ImageDto;
import com.example.ludotheque.dal.ImageRepository;
import com.example.ludotheque.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
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
        List<ImageDto> imageDtos = new ArrayList<>();
        for(Image img : images) {
            imageDtos.add(imageService.convertToImageDto(img));
        }

        model.addAttribute("images", imageDtos);
//        Image img = new Image();
//        img.setFileName("heroquest.jpg");
//        img.setMimeType("images/jpg");
//            try (InputStream inputStream = getClass().getResourceAsStream("/static/images/heroquest.jpg")) {
//
//                if (inputStream == null) {
//                    throw new IOException("Image not found in classpath");
//                }
//                img.setData(inputStream.readAllBytes());
//            imageRepository.save(img);
//        }
        return "index";
    }

    @GetMapping("/img/supprimer/{id}")
    public String deleteImg(Model model, @PathVariable("id") int id) {
        Optional<Image> image = imageRepository.findById(id);
        image.ifPresent(imageRepository::delete);
        return "redirect:/img";
    }
}
