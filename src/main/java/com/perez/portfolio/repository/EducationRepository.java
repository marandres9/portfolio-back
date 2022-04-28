package com.perez.portfolio.repository;

import com.perez.portfolio.model.Education;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Integer> {
    
}
