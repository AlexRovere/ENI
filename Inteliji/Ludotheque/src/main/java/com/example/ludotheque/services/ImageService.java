package com.example.ludotheque.services;

import com.example.ludotheque.bo.Image;
import com.example.ludotheque.bo.dto.ImageDto;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ImageService {
    public ImageDto convertToImageDto(Image image) {
        int id = image.getId();
        String fileName = image.getFileName();
        String data = Base64.getEncoder().encodeToString(image.getData());
        ImageDto imageDto = new ImageDto(id, fileName, data);
        return imageDto;
    }
}
