package com.perez.portfolio.repository;

import com.perez.portfolio.model.Home;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Integer> {
    
}
