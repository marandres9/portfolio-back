package com.perez.portfolio.service.skill;

import java.util.List;

import com.perez.portfolio.model.Skill;
import com.perez.portfolio.repository.SkillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements SkillServiceInterface {
    @Autowired
    SkillRepository skillRepo;

    @Override
    public List<Skill> getAll() {
        return skillRepo.findAll();
    }

    @Override
    public Skill getSkill() {
        return getAll().get(0);
    }

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public List<Skill> getSoftSkills() {
        return skillRepo.findBysoftSkillTrue();
    }

    @Override
    public List<Skill> getHardSkills() {
        return skillRepo.findBysoftSkillFalse();
    }
}
