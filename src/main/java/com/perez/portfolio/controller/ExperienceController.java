package com.perez.portfolio.controller;

import com.perez.portfolio.model.Experience;
import com.perez.portfolio.service.experience.ExperienceService;

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
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;
    
    @DeleteMapping(path = "/portfolio/edit/experience/delete/{id}")
    public void deleteExperience(@PathVariable int id) {
        this.experienceService.deleteExperience(id);
    }

    @PutMapping(path = "/portfolio/edit/experience/update/{id}")
    public Experience updateExperience(
            @PathVariable int id,
            @RequestBody Experience exp) {
        return this.experienceService.updateExperience(
                id,
                exp.getTitle(),
                exp.getPeriod(),
                exp.getInstitution(),
                exp.getLocation(),
                exp.getDescription());
    }

    @PostMapping(path = "/portfolio/edit/experience/save")
    public Experience saveExperience(@RequestBody Experience ed) {
        return this.experienceService.saveExperience(ed);
    }

}
