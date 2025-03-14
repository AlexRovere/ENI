package com.example.ludotheque.services;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ImageService {

    public String convertByteToString(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
