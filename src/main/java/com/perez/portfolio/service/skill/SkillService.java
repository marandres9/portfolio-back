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
    public Skill getSkill(int id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public Skill saveSkill(Skill skill) {
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

    @Override
    public void deleteSkill(int id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill updateSkill(int id, String title, byte value) {
        // get and check not null
        Skill skill = this.getSkill(id);
        if(skill == null) return null;
        // update values
        skill.setTitle(title);
        skill.setValue(value);

        // save changes
        this.saveSkill(skill);

        return skill;
    }
}
