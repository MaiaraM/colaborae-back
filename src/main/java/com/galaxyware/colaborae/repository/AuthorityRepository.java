package com.galaxyware.colaborae.repository;

import com.galaxyware.colaborae.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository<A extends Authority> extends JpaRepository<A, String> {

    A findByName(String name);

}
