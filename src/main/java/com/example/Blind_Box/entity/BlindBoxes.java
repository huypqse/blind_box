package com.example.Blind_Box.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity(name = "blind_boxes")
public class BlindBoxes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blindBoxID;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "ratity", length = 100, nullable = false)
    private String ratity;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private LocalDate releaseDate;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private BlindBoxCategories blindBoxCategories;


    public Integer getBlindBoxID() {
        return blindBoxID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatity() {
        return ratity;
    }

    public void setRatity(String ratity) {
        this.ratity = ratity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BlindBoxCategories getCategories() {
        return blindBoxCategories;
    }

    public void setCategories(BlindBoxCategories categories) {
        this.blindBoxCategories = categories;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BlindBoxCategories getBlindBoxCategories() {
        return blindBoxCategories;
    }

    public void setBlindBoxCategories(BlindBoxCategories blindBoxCategories) {
        this.blindBoxCategories = blindBoxCategories;
    }

    public void setBlindBoxID(Integer blindBoxID) {
        this.blindBoxID = blindBoxID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}