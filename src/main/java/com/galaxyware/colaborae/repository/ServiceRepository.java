package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, UUID> {
    ServiceModel findByTitle(String title);

}
