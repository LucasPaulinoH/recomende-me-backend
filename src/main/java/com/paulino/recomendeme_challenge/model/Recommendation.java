package com.paulino.recomendeme_challenge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Column(name = "username", nullable = false, updatable = false)
    private String username;

    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId;

    @Column(name = "cover", updatable = false)
    private String cover;

    @Column(name = "authors", updatable = false)
    private String[] authors;

    @Column(name = "ratings", nullable = false)
    private List<String> ratings = new ArrayList<>(0);

    @Column(name = "psychological_concept", nullable = false)
    private PsychologicalConcept psychologicalConcept;

    @Column(name = "psychological_impact", nullable = false)
    private String psychologicalImpact;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    public Recommendation() {
    }

    public Recommendation(RecommendationType type, String title, String username, String userId, String[] authors,
            String cover,
            PsychologicalConcept psychologicalConcept, String psychologicalImpact) {
        this.type = type;
        this.title = title;
        this.username = username;
        this.userId = userId;
        this.cover = cover;
        this.authors = authors;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public List<String> getRatings() {
        return ratings;
    }

    public void setRatings(List<String> ratings) {
        this.ratings = ratings;
    }

}
