package com.paulino.recomendeme_challenge.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulino.recomendeme_challenge.model.Recommendation;

public interface RecommendationRepositoy extends JpaRepository<Recommendation, UUID> {
}
