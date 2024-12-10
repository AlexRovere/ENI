package com.example.ludotheque.bo.dto;

public class ImageDto {
    private int id;
    private String fileName;
    private String data;

    public ImageDto(String fileName, String data) {
        this.fileName = fileName;
        this.data = data;
    }

    public ImageDto(int id, String fileName, String data) {
        this.id = id;
        this.fileName = fileName;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
