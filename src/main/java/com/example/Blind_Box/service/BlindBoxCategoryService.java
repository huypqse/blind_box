package com.example.Blind_Box.service;

import com.example.Blind_Box.pojo.response.BlindBoxesCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlindBoxCategoryService {
    List<BlindBoxesCategoryResponse> getAll();
}
