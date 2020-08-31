package com.example.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Nbfile {
    @Id
    @GeneratedValue
    @Column(name="nbsite_id")
    Long id;

    @Column(name="idsite")
    private String idsite;

    @Column(name="url")
    private String url;

    @Column(name="fileName")
    private String fileName;


    public Nbfile(String idsite, String url, String fileName) {
        this.idsite = idsite;
        this.url = url;
        this.fileName = fileName;
    }


}
