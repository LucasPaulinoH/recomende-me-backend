package com.paulino.recomendeme_challenge.dtos.Recommendation;

import java.util.UUID;

import com.paulino.recomendeme_challenge.types.PsychologicalConcept;
import com.paulino.recomendeme_challenge.types.RecommendationType;

public record CreateRecommendationDTO(RecommendationType type, String title, String userNickname, UUID userId,
                PsychologicalConcept psychologicalConcept, String psychologicalImpact) {
}
