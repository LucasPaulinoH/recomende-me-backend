package com.paulino.recomendeme_challenge.dtos.Recommendation;

import com.paulino.recomendeme_challenge.types.PsychologicalConcept;

public record UpdateRecommendationDTO(
        PsychologicalConcept psychologicalConcept, String psychologicalImpact) {
}
