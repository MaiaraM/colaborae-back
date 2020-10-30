package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, UUID> {
    @Query("SELECT s FROM services s WHERE s.title = ?1")
    ServiceModel findByTitle(String title);

}
