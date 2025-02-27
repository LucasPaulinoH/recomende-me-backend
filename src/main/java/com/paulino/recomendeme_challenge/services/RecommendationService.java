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
import com.paulino.recomendeme_challenge.dtos.Recommendation.UpdateRecommendationDTO;
import com.paulino.recomendeme_challenge.model.Recommendation;
import com.paulino.recomendeme_challenge.repositories.RecommendationRepositoy;
import com.paulino.recomendeme_challenge.utils.Functions;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepositoy recommendationRepository;

    public Recommendation createRecommendation(CreateRecommendationDTO createRecommendationDTO)
            throws BadRequestException {
        var newRecommendation = new Recommendation();
        BeanUtils.copyProperties(createRecommendationDTO, newRecommendation);

        return recommendationRepository.save(newRecommendation);
    }

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    public ResponseEntity<Object> getRecommendation(UUID id) {
        Optional<Recommendation> foundedRecommendation = recommendationRepository.findById(id);

        if (foundedRecommendation.isEmpty())
            return Functions.returnNotFoundResponseEntity("Recommendation");

        return Functions.returnOkResponseEntity(foundedRecommendation);
    }

    public ResponseEntity<Object> updateRecommendation(UUID id, UpdateRecommendationDTO updateRecommendationDTO) {
        Optional<Recommendation> foundedRecommendation = recommendationRepository.findById(id);

        if (foundedRecommendation.isEmpty())
            return Functions.returnNotFoundResponseEntity("Recommendation");

        Recommendation updatedRecommendation = foundedRecommendation.get();
        BeanUtils.copyProperties(updateRecommendationDTO, updatedRecommendation);

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
