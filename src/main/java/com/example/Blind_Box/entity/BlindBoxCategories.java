package com.example.Blind_Box.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "blind_box_categories")
public class BlindBoxCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID;
    @Column(name = "categoryname", length = 100, nullable = false)
    private String categoryName;
    @Lob
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "raritylevel", length = 50, nullable = false)
    private String rarityLevel;
    @Column(name = "pricerange", length = 50, nullable = false)
    private String priceRange;
    @OneToMany(mappedBy = "blindBoxCategories")
    private List<BlindBoxes> blindBox;

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<BlindBoxes> getBlindBox() {
        return blindBox;
    }

    public void setBlindBox(List<BlindBoxes> blindBox) {
        this.blindBox = blindBox;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getRarityLevel() {
        return rarityLevel;
    }

    public void setRarityLevel(String rarityLevel) {
        this.rarityLevel = rarityLevel;
    }
}