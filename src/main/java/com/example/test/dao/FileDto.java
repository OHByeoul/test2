package com.example.test.dao;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FileDto {
    private String idiste;

    private String url;

    private String filename;

    public FileDto(String idiste, String url, String filename) {
        this.idiste = idiste;
        this.url = url;
        this.filename = filename;
    }
}
