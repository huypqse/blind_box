package com.example.Blind_Box.service;

import com.example.Blind_Box.pojo.request.BlindBoxesCategoryRequest;
import com.example.Blind_Box.pojo.request.BlindBoxesRequest;
import com.example.Blind_Box.pojo.response.BlindBoxesResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlindBoxesService {
    List<BlindBoxesResponse> getAllBlindBoxes();
    BlindBoxesResponse createBlindBox(BlindBoxesRequest blindBoxesRequest);
    BlindBoxesResponse updateBlindBox(Integer blindBoxID, BlindBoxesRequest blindBoxesRequest);
    void deleteBlindBox(Integer blindBoxID);
}
