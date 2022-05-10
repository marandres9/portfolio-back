package com.perez.portfolio.repository;

import com.perez.portfolio.model.Experience;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    
}
