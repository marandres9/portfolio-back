package com.perez.portfolio.service.skill;

import java.util.List;

import com.perez.portfolio.model.Skill;

public interface SkillServiceInterface {
    public List<Skill> getAll();
    public Skill getSkill();
    public Skill createSkill(Skill skill);
    public List<Skill> getSoftSkills();
    public List<Skill> getHardSkills();
}
