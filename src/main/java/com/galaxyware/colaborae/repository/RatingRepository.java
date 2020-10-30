package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel, UUID> {

    @Query("SELECT r FROM ratings r WHERE r.rating = ?1")
    public RatingModel findByRating(Integer rating);
}
