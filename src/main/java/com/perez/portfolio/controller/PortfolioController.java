package com.perez.portfolio.controller;

import java.util.List;

import com.perez.portfolio.dto.PortfolioDTO;
import com.perez.portfolio.model.About;
import com.perez.portfolio.model.Education;
import com.perez.portfolio.model.Home;
import com.perez.portfolio.model.Skill;
import com.perez.portfolio.model.Project;
import com.perez.portfolio.service.about.AboutService;
import com.perez.portfolio.service.education.EducationService;
import com.perez.portfolio.service.home.HomeService;
import com.perez.portfolio.service.project.ProjectService;
import com.perez.portfolio.service.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PortfolioController {
    @Autowired
    HomeService homeService;
    @Autowired
    AboutService aboutService;
    @Autowired
    SkillService skillService;
    @Autowired
    EducationService educationService;
    @Autowired
    ProjectService projectService;

    @GetMapping(path = "/portfolio/get")
    public PortfolioDTO getPortfolio() {
        return new PortfolioDTO(
            homeService.getHome(),
            aboutService.getAbout(),
            skillService.getHardSkills(),
            skillService.getSoftSkills(),
            educationService.getAll(),
            projectService.getAll()
        );
    }

    // === HOME ===
    @PutMapping(path = "/portfolio/edit/home/update")
    public Home updateHome(@RequestParam String title, @RequestParam String description) {
        return this.homeService.updateHome(title, description);
    }
    
    // === ABOUT ===
    @PutMapping(path = "/portfolio/edit/about/update")
    public About updateAbout(@RequestParam String description) {
        return this.aboutService.updateAbout(description);
    }
    
    // === SKILLS ===
    @DeleteMapping(path = "/portfolio/edit/skills/delete/{id}")
    public void deleteSkill(@PathVariable int id) {
        this.skillService.deleteSkill(id);
    }

    @PutMapping(path = "/portfolio/edit/skills/update/{id}")
    public Skill updateSkill(@PathVariable int id, @RequestParam String title, @RequestParam byte value) {
        return this.skillService.updateSkill(id, title, value);
    }

    @PostMapping(path = "/portfolio/edit/skills/save")
    public Skill saveSkill(@RequestBody Skill skill) {
        return this.skillService.saveSkill(skill);
    }
    
    // === EDUCATION ===
    @DeleteMapping(path = "/portfolio/edit/education/delete/{id}")
    public void delteEducation(@PathVariable int id) {
        this.educationService.deleteEducation(id);
    }

    @PutMapping(path = "/portfolio/edit/education/update/{id}")
    public Education updateEducation(
        @PathVariable int id,
        @RequestParam String title,
        @RequestParam String period,
        @RequestParam String institution,
        @RequestParam String location,
        @RequestParam String description) {
        return this.educationService.updateEducation(id, title, period, institution, location, description);
    }

    @PostMapping(path = "/portfolio/edit/education/save")
    public Education saveEducation(@RequestBody Education ed) {
        return this.educationService.saveEducation(ed);
    }

    // === EDUCATION ===
    

    // === TEST ===
    @GetMapping(path = "/test/skills")
    public List<Skill> getSkills() {
        return this.skillService.getHardSkills();
    }

    @GetMapping(path = "/test/education")
    public List<Education> geteducation() {
        return this.educationService.getAll();
    }

    @GetMapping(path = "/test/projects")
    public List<Project> getProjects() {
        return this.projectService.getAll();
    }
    
}
