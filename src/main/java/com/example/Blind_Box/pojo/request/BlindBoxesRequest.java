package com.example.Blind_Box.pojo.request;


import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;

public class BlindBoxesRequest {
    private String name;
    private String ratity;
    private BigDecimal price;
    private Integer stock;
    BlindBoxesCategoryRequest blindBoxCategories;

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

    public BlindBoxesCategoryRequest getBlindBoxCategories() {
        return blindBoxCategories;
    }

    public void setBlindBoxCategories(BlindBoxesCategoryRequest blindBoxCategories) {
        this.blindBoxCategories = blindBoxCategories;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
