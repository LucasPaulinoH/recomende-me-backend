package com.paulino.recomendeme_challenge.dtos.Recommendation;

import com.paulino.recomendeme_challenge.types.PsychologicalConcept;
import com.paulino.recomendeme_challenge.types.RecommendationType;

public record CreateRecommendationDTO(RecommendationType type, String title, String username, String userId,
                String cover, String[] authors,
                PsychologicalConcept psychologicalConcept, String psychologicalImpact) {
}
