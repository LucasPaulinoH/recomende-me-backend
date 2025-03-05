package com.paulino.recomendeme_challenge.services;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulino.recomendeme_challenge.dtos.Recommendation.CreateRecommendationDTO;
import com.paulino.recomendeme_challenge.model.Recommendation;
import com.paulino.recomendeme_challenge.repositories.RecommendationRepository;
import com.paulino.recomendeme_challenge.types.RecommendationType;
import com.paulino.recomendeme_challenge.utils.Functions;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;

    public Recommendation createRecommendation(CreateRecommendationDTO createRecommendationDTO)
            throws BadRequestException {
        var newRecommendation = new Recommendation();
        BeanUtils.copyProperties(createRecommendationDTO, newRecommendation);

        return recommendationRepository.save(newRecommendation);
    }

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    public List<Recommendation> getAllRecommendationsFromAType(RecommendationType recommendationType) {
        return recommendationRepository.findByType(recommendationType);
    }

    public List<Recommendation> getAllRecommendationsFromAUserId(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public ResponseEntity<Object> getRecommendation(UUID id) {
        Optional<Recommendation> foundedRecommendation = recommendationRepository.findById(id);

        if (foundedRecommendation.isEmpty())
            return Functions.returnNotFoundResponseEntity("Recommendation");

        return Functions.returnOkResponseEntity(foundedRecommendation);
    }

    public int[] getRecommendationsQuantityByType() {
        int[] recommendationsQuantity = new int[3];

        recommendationsQuantity[0] = (int) recommendationRepository
                .recommendationsQuantityByType(RecommendationType.BOOK);
        recommendationsQuantity[1] = (int) recommendationRepository
                .recommendationsQuantityByType(RecommendationType.MOVIE);
        recommendationsQuantity[2] = (int) recommendationRepository
                .recommendationsQuantityByType(RecommendationType.SONG);

        return recommendationsQuantity;
    }

    public ResponseEntity<Object> updateRecommendationRating(UUID recommendationId, String userId)
            throws BadRequestException {
        Optional<Recommendation> foundedRecommendation = recommendationRepository.findById(recommendationId);

        if (foundedRecommendation.isEmpty())
            return Functions.returnNotFoundResponseEntity("Recommendation");

        if (foundedRecommendation.get().getUserId().equals(userId))
            throw new BadRequestException("Recommendation creator can't rate it.");

        Recommendation updatedRecommendation = foundedRecommendation.get();

        if (updatedRecommendation.getRatings().contains(userId))
            updatedRecommendation.getRatings().remove(userId);
        else
            updatedRecommendation.getRatings().add(userId);

        return Functions.returnOkResponseEntity(recommendationRepository.save(updatedRecommendation));
    }

    public ResponseEntity<Object> deleteRecommendation(UUID id) {
        Optional<Recommendation> foundedRecommendation = recommendationRepository.findById(id);

        if (foundedRecommendation.isEmpty())
            return Functions.returnNotFoundResponseEntity("Recommendation");

        recommendationRepository.delete(foundedRecommendation.get());

        return Functions.returnOkResponseEntity("Recommendation successfully deleted.");
    }
}
