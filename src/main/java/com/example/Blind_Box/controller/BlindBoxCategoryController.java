package com.example.Blind_Box.controller;

import com.example.Blind_Box.pojo.response.BlindBoxesCategoryResponse;
import com.example.Blind_Box.service.BlindBoxCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blindbox-category")
public class BlindBoxCategoryController {
    @Autowired
    private BlindBoxCategoryService blindBoxCategoryService;

    @Operation(
            summary = "Get all blind boxes categories",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved blind boxes categories")
    @ApiResponse(responseCode = "401", description = "Unauthorized - Invalid or missing token")
    @GetMapping
    public ResponseEntity<List<BlindBoxesCategoryResponse>> getAll() {
        List<BlindBoxesCategoryResponse> list = blindBoxCategoryService.getAll();
        return ResponseEntity.ok(list);
    }
}
