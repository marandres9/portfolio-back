package com.perez.portfolio.controller;

import com.perez.portfolio.model.Skill;
import com.perez.portfolio.service.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://my-portfolio-65acc.web.app/", maxAge = 3600)
public class SkillsController {
    @Autowired
    SkillService skillService;

    @DeleteMapping(path = "/portfolio/edit/skills/delete/{id}")
    public void deleteSkill(@PathVariable int id) {
        this.skillService.deleteSkill(id);
    }
    
    @PutMapping(path = "/portfolio/edit/skills/update/{id}")
    public Skill updateSkill(@PathVariable int id, @RequestBody Skill skill) {
        return this.skillService.updateSkill(id, skill.getTitle(), skill.getValue());
    }

    @PostMapping(path = "/portfolio/edit/skills/save")
    public Skill saveSkill(@RequestBody Skill skill) {
        return this.skillService.saveSkill(skill);
    }

}
