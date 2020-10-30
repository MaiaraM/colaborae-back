package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {

    @Query("SELECT c FROM categories c WHERE c.name = ?1")
    Optional<CategoryModel> findByName(String name);
}
