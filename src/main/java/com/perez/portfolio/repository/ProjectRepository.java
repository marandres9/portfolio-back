package com.perez.portfolio.repository;

import com.perez.portfolio.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    
}
