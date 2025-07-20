package com.example.Blind_Box.service.impl;

import com.example.Blind_Box.entity.BlindBoxCategories;
import com.example.Blind_Box.entity.BlindBoxes;
import com.example.Blind_Box.pojo.request.BlindBoxesRequest;
import com.example.Blind_Box.pojo.response.BlindBoxesCategoryResponse;
import com.example.Blind_Box.pojo.response.BlindBoxesResponse;
import com.example.Blind_Box.repository.BlindBoxCategoryRepository;
import com.example.Blind_Box.repository.BlindBoxRepository;
import com.example.Blind_Box.service.BlindBoxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlindBoxesServiceImpl implements BlindBoxesService {
    @Autowired
    private BlindBoxRepository blindBoxRepository;
    @Autowired
    private BlindBoxCategoryRepository blindBoxCategoryRepository;

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<BlindBoxesResponse> getAllBlindBoxes() {
        List<BlindBoxesResponse> list = blindBoxRepository.findAll().stream()
                .map(blindBox -> {
                    BlindBoxesResponse response = new BlindBoxesResponse();
                    response.setBlindBoxID(blindBox.getBlindBoxID());
                    response.setName(blindBox.getName());
                    response.setRatity(blindBox.getRatity());
                    response.setPrice(blindBox.getPrice());
                    response.setReleaseDate(blindBox.getReleaseDate());
                    response.setStock(blindBox.getStock());
                    BlindBoxCategories categories = blindBoxCategoryRepository.findByBlindBoxBlindBoxID(blindBox.getBlindBoxID());
                    BlindBoxesCategoryResponse categoriesResponse = new BlindBoxesCategoryResponse();
                    categoriesResponse.setName(categories.getCategoryName());
                   response.setBlindBoxCategories(categoriesResponse);
                    return response;
                })
                .toList();
        if (list.isEmpty()) {
            throw new RuntimeException("No blind boxes found");
        }
        return list;
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public BlindBoxesResponse createBlindBox(BlindBoxesRequest request) {
        if(request.getName() == null || request.getRatity() == null || request.getPrice() == null ||
                request.getStock() == null || request.getBlindBoxCategories() == null || request.getBlindBoxCategories().getCategoryName() == null) {
            throw new RuntimeException("All fields are required");
        }
        if(request.getStock() <= 1 || request.getStock() >= 100) {
            throw new RuntimeException("Stock must be between 1 and 100");
        }
        if(request.getName().length() < 10) {
            throw new RuntimeException("Name must be greater than 10 characters long");
        }
        BlindBoxes blindBox = new BlindBoxes();
        blindBox.setName(request.getName());
        blindBox.setRatity(request.getRatity());
        blindBox.setPrice(request.getPrice());
        blindBox.setReleaseDate(LocalDate.now());
        blindBox.setStock(request.getStock());
        BlindBoxCategories categories = blindBoxCategoryRepository.findByCategoryName(request.getBlindBoxCategories().getCategoryName());
        if (categories == null) {
            throw new IllegalArgumentException("Category not found");
        }
        blindBox.setCategories(categories);
        blindBoxRepository.save(blindBox);
        BlindBoxesResponse response = new BlindBoxesResponse();
        response.setName(blindBox.getName());
        response.setRatity(blindBox.getRatity());
        response.setPrice(blindBox.getPrice());
        response.setReleaseDate(blindBox.getReleaseDate());
        response.setStock(blindBox.getStock());
        BlindBoxesCategoryResponse categoriesResponse = new BlindBoxesCategoryResponse();
        categoriesResponse.setName(categories.getCategoryName());
        response.setBlindBoxCategories(categoriesResponse);
        return response;
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public BlindBoxesResponse updateBlindBox(Integer blindBoxID, BlindBoxesRequest blindBoxesRequest) {
        if (blindBoxID == null || blindBoxesRequest == null) {
            throw new IllegalArgumentException("BlindBoxID and request must not be null");
        }
        var blindBox = blindBoxRepository.findById(blindBoxID)
                .orElseThrow(() -> new IllegalArgumentException("Blind box not found"));
        blindBox.setName(blindBoxesRequest.getName());
        blindBox.setRatity(blindBoxesRequest.getRatity());
        blindBox.setPrice(blindBoxesRequest.getPrice());
        blindBox.setStock(blindBoxesRequest.getStock());
        blindBox.setCategories(blindBoxCategoryRepository.findByCategoryName(blindBoxesRequest.getBlindBoxCategories().getCategoryName()));
        blindBoxRepository.save(blindBox);
        BlindBoxesResponse response = new BlindBoxesResponse();
        response.setBlindBoxID(blindBox.getBlindBoxID());
        response.setName(blindBox.getName());
        response.setRatity(blindBox.getRatity());
        response.setPrice(blindBox.getPrice());
        response.setReleaseDate(blindBox.getReleaseDate());
        response.setStock(blindBox.getStock());
        BlindBoxesCategoryResponse categoriesResponse = new BlindBoxesCategoryResponse();
        categoriesResponse.setName(blindBox.getCategories().getCategoryName());
        response.setBlindBoxCategories(categoriesResponse);
        response.setBlindBoxCategories(categoriesResponse);
        return response;
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteBlindBox(Integer blindBoxID) {
        if (blindBoxID == null) {
            throw new IllegalArgumentException("BlindBoxID must not be null");
        }
        var blindBox = blindBoxRepository.findById(blindBoxID)
                .orElseThrow(() -> new IllegalArgumentException("Blind box not found"));
        blindBoxRepository.delete(blindBox);
    }
}
