package com.paulino.recomendeme_challenge.controllers;

import java.util.List;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paulino.recomendeme_challenge.dtos.Recommendation.CreateRecommendationDTO;
import com.paulino.recomendeme_challenge.dtos.Recommendation.UpdateRecommendationDTO;
import com.paulino.recomendeme_challenge.model.Recommendation;
import com.paulino.recomendeme_challenge.services.RecommendationService;
import com.paulino.recomendeme_challenge.types.RecommendationType;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    @Autowired
    RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<Recommendation> createRecommentation(
            @RequestBody @Valid CreateRecommendationDTO recommendationDTO) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(recommendationService.createRecommendation(recommendationDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recommendation>> getAllRecommentations() {
        return ResponseEntity.status(HttpStatus.OK).body(recommendationService.getAllRecommendations());
    }

    @GetMapping("/quantity-by-type")
    public ResponseEntity<int[]> getRecommendationsQuantityByType() {
        return ResponseEntity.status(HttpStatus.OK).body(recommendationService.getRecommendationsQuantityByType());
    }

    @GetMapping
    public ResponseEntity<List<Recommendation>> getAllRecommendationsFromAType(
            @RequestParam(value = "type") RecommendationType type) {
        return ResponseEntity.status(HttpStatus.OK).body(recommendationService.getAllRecommendationsFromAType(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRecommentation(@PathVariable(value = "id") UUID id) {
        return recommendationService.getRecommendation(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRecommentation(@PathVariable(value = "id") UUID id,
            @RequestBody @Valid UpdateRecommendationDTO RecommentationDTO) {
        return recommendationService.updateRecommendation(id, RecommentationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecommentation(@PathVariable(value = "id") UUID id) {
        return recommendationService.deleteRecommendation(id);
    }
}
