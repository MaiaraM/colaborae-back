package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel, UUID> {

    public RatingModel findByRating(Integer rating);
}
