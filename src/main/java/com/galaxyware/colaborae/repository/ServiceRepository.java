package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.ServiceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, UUID> {
    List<ServiceModel> findByTitleContaining(String title);

    List<ServiceModel> findByUserUuid(UUID uuid);
}
