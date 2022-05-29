package com.perez.portfolio.controller;

import com.perez.portfolio.model.Education;
import com.perez.portfolio.service.education.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "https://my-portfolio-65acc.web.app/", maxAge = 3600)
public class EducationController {
    @Autowired
    EducationService educationService;
    
    @DeleteMapping(path = "/portfolio/edit/education/delete/{id}")
    public void deleteEducation(@PathVariable int id) {
        this.educationService.deleteEducation(id);
    }

    @PutMapping(path = "/portfolio/edit/education/update/{id}")
    public Education updateEducation(@PathVariable int id, @RequestBody Education ed) {
        return this.educationService.updateEducation(
                id,
                ed.getTitle(),
                ed.getPeriod(),
                ed.getInstitution(),
                ed.getLocation(),
                ed.getDescription());
    }

    @PostMapping(path = "/portfolio/edit/education/save")
    public Education saveEducation(@RequestBody Education ed) {
        return this.educationService.saveEducation(ed);
    }

}
