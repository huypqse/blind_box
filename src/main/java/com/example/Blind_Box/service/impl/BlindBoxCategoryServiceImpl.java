package com.example.Blind_Box.service.impl;

import com.example.Blind_Box.entity.BlindBoxCategories;
import com.example.Blind_Box.pojo.response.BlindBoxesCategoryResponse;
import com.example.Blind_Box.repository.BlindBoxCategoryRepository;
import com.example.Blind_Box.service.BlindBoxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlindBoxCategoryServiceImpl implements BlindBoxCategoryService {
    @Autowired
    private BlindBoxCategoryRepository blindBoxCategoryRepository;
    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<BlindBoxesCategoryResponse> getAll() {
        List<BlindBoxCategories> blindBoxCategories = blindBoxCategoryRepository.findAll();
        List<BlindBoxesCategoryResponse> list = new ArrayList<>();
        for (BlindBoxCategories categories: blindBoxCategories) {
            BlindBoxesCategoryResponse response = new BlindBoxesCategoryResponse();
            response.setName(categories.getCategoryName());
            list.add(response);
        }
        return list;
    }
}
