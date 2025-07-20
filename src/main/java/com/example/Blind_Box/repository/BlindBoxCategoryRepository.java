package com.example.Blind_Box.repository;

import com.example.Blind_Box.entity.BlindBoxCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlindBoxCategoryRepository extends JpaRepository<BlindBoxCategories, Integer> {
    BlindBoxCategories findByBlindBoxBlindBoxID(Integer blindBoxID);
    BlindBoxCategories findByCategoryName(String categoryName);
}
