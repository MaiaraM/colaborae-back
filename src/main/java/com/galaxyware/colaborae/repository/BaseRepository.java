package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseRepository extends JpaRepository<BaseModel, UUID> {
}
