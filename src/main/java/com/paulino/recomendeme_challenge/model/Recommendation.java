package com.paulino.recomendeme_challenge.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import com.paulino.recomendeme_challenge.types.PsychologicalConcept;
import com.paulino.recomendeme_challenge.types.RecommendationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recommendations")
public class Recommendation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type", nullable = false, updatable = false)
    private RecommendationType type;

    @Column(name = "title", nullable = false, updatable = false)
    private String title;

    @Column(name = "user_nickname", nullable = false, updatable = false)
    private String userNickname;

    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(name = "rating", nullable = false)
    private Integer rating = 0;

    @Column(name = "psychological_concept", nullable = false)
    private PsychologicalConcept psychologicalConcept;

    @Column(name = "psychological_impact", nullable = false)
    private String psychologicalImpact;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    public Recommendation() {
    }

    public Recommendation(RecommendationType type, String title, String userNickname, UUID userId,
            PsychologicalConcept psychologicalConcept, String psychologicalImpact) {
        this.type = type;
        this.title = title;
        this.userNickname = userNickname;
        this.userId = userId;
        this.psychologicalConcept = psychologicalConcept;
        this.psychologicalImpact = psychologicalImpact;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RecommendationType getType() {
        return type;
    }

    public void setType(RecommendationType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public PsychologicalConcept getPsychologicalConcept() {
        return psychologicalConcept;
    }

    public void setPsychologicalConcept(PsychologicalConcept psychologicalConcept) {
        this.psychologicalConcept = psychologicalConcept;
    }

    public String getPsychologicalImpact() {
        return psychologicalImpact;
    }

    public void setPsychologicalImpact(String psychologicalImpact) {
        this.psychologicalImpact = psychologicalImpact;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
