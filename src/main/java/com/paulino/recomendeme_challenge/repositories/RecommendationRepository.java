package com.paulino.recomendeme_challenge.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.paulino.recomendeme_challenge.model.Recommendation;
import com.paulino.recomendeme_challenge.types.RecommendationType;

public interface RecommendationRepository extends JpaRepository<Recommendation, UUID> {
    public List<Recommendation> findByType(RecommendationType type);

    @Query("SELECT COUNT(r) FROM Recommendation r WHERE r.type = :type")
    long recommendationsQuantityByType(RecommendationType type);
}
