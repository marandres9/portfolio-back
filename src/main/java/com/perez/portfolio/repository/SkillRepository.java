package com.perez.portfolio.repository;

import java.util.List;

import com.perez.portfolio.model.Skill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    List<Skill> findBysoftSkillTrue();
    List<Skill> findBysoftSkillFalse();
}
