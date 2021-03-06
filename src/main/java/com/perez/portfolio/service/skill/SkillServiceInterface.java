package com.perez.portfolio.service.skill;

import java.util.List;

import com.perez.portfolio.model.Skill;

public interface SkillServiceInterface {
    public List<Skill> getAll();

    public Skill getSkill(int id);
    public Skill saveSkill(Skill skill);
    
    public List<Skill> getSoftSkills();
    public List<Skill> getHardSkills();
    
    public void deleteSkill(int id);

    public Skill updateSkill(int id, String title, byte value);
}
