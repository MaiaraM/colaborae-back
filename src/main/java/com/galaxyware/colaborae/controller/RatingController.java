package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.RatingModel;
import com.galaxyware.colaborae.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping(value = "/{rating}")
    public ResponseEntity<RatingModel> findById(@PathVariable UUID uuid) {
        RatingModel rating = ratingRepository.findById(uuid).orElse(null);
        return rating != null
                ? ResponseEntity.ok().body(rating)
                : ResponseEntity.notFound().build();
    }
}
