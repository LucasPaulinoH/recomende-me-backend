package com.paulino.recomendeme_challenge.controllers;

import java.util.List;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paulino.recomendeme_challenge.dtos.Recommendation.CreateRecommendationDTO;
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

    @GetMapping("/user")
    public ResponseEntity<List<Recommendation>> getAllRecommendationsFromAUserId(
            @RequestParam(value = "userId") String userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(recommendationService.getAllRecommendationsFromAUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRecommentation(@PathVariable(value = "id") UUID id) {
        return recommendationService.getRecommendation(id);
    }

    @PatchMapping("/{recommendationId}/{userId}")
    public ResponseEntity<Object> updateRecommendationRating(
            @PathVariable(value = "recommendationId") UUID recommendationId,
            @PathVariable(value = "userId") String userId) throws BadRequestException {
        return recommendationService.updateRecommendationRating(recommendationId, userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecommentation(@PathVariable(value = "id") UUID id) {
        return recommendationService.deleteRecommendation(id);
    }
}
