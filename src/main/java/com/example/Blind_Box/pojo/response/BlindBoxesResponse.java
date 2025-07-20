package com.example.Blind_Box.pojo.response;



import java.math.BigDecimal;
import java.time.LocalDate;

public class BlindBoxesResponse {
    private Integer blindBoxID;
    private String name;
    private String ratity;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Integer stock;
    private BlindBoxesCategoryResponse blindBoxCategories;

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

    public Integer getBlindBoxID() {
        return blindBoxID;
    }

    public void setBlindBoxID(Integer blindBoxID) {
        this.blindBoxID = blindBoxID;
    }


    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BlindBoxesCategoryResponse getBlindBoxCategories() {
        return blindBoxCategories;
    }

    public void setBlindBoxCategories(BlindBoxesCategoryResponse blindBoxCategories) {
        this.blindBoxCategories = blindBoxCategories;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
