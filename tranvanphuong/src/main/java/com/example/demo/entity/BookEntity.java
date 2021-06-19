package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publiserid")
    private int publiserid;


    @OneToOne
    @JoinColumn(name = "publiserid", insertable = false, updatable = false)
    private PubliserEntity publiser;

    public int getPubliserid() {
        return publiserid;
    }

    public void setPubliserid(int publiserid) {
        this.publiserid = publiserid;
    }

    public PubliserEntity getPubliser() {
        return publiser;
    }

    public void setPubliser(PubliserEntity publiser) {
        this.publiser = publiser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
