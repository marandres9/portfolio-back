package com.perez.portfolio.repository;

import com.perez.portfolio.model.About;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Integer> {
    
}
