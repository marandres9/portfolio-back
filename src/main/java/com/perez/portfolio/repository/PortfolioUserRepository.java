package com.perez.portfolio.repository;

import java.util.Optional;

import com.perez.portfolio.model.PortfolioUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioUserRepository extends JpaRepository<PortfolioUser, Integer> {
    Optional<PortfolioUser> findByUsername(String username);    
}