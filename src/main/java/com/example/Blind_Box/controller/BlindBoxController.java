package com.example.Blind_Box.controller;

import com.example.Blind_Box.pojo.request.BlindBoxesRequest;
import com.example.Blind_Box.pojo.response.BlindBoxesResponse;
import com.example.Blind_Box.service.BlindBoxesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blindbox")
public class BlindBoxController {

    @Autowired
    private BlindBoxesService blindBoxesService;

    @Operation(
            summary = "Get all blind boxes",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved blind boxes")
    @ApiResponse(responseCode = "403", description = "Unauthorized - Invalid or missing token")
    @GetMapping
    public ResponseEntity<List<BlindBoxesResponse>> getAllBlindBoxes() {
        List<BlindBoxesResponse> response = blindBoxesService.getAllBlindBoxes();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create blind boxes",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Successfully created blind box")
    @ApiResponse(responseCode = "403", description = "Unauthorized - Invalid or missing token")
    @PostMapping
    public ResponseEntity<BlindBoxesResponse> createBlindBox(@RequestBody @Valid BlindBoxesRequest request) {
        BlindBoxesResponse response = blindBoxesService.createBlindBox(request);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Update blind boxes",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Successfully updated blind box")
    @ApiResponse(responseCode = "403", description = "Unauthorized - Invalid or missing token")
    @PutMapping("/{id}")
    public ResponseEntity<BlindBoxesResponse> updateBlindBox(@PathVariable("id") Integer id, @RequestBody @Valid BlindBoxesRequest request) {
        BlindBoxesResponse response = blindBoxesService.updateBlindBox(id, request);
        System.out.println("Blind box updated successfully: " + response);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Delete blind boxes",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Successfully deleted blind box")
    @ApiResponse(responseCode = "403", description = "Unauthorized - Invalid or missing token")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlindBox(@PathVariable("id") Integer id) {
        blindBoxesService.deleteBlindBox(id);
        return ResponseEntity.noContent().build();
    }
}