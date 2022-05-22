package com.perez.portfolio.controller;

import java.util.List;

import com.perez.portfolio.dto.PortfolioDTO;
import com.perez.portfolio.model.About;
import com.perez.portfolio.model.AuthRequest;
import com.perez.portfolio.model.AuthResponse;
import com.perez.portfolio.model.Education;
import com.perez.portfolio.model.Experience;
import com.perez.portfolio.model.Home;
import com.perez.portfolio.model.Skill;
import com.perez.portfolio.security.JwtUtil;
import com.perez.portfolio.security.PortfolioUserService;
import com.perez.portfolio.model.Project;
import com.perez.portfolio.service.about.AboutService;
import com.perez.portfolio.service.education.EducationService;
import com.perez.portfolio.service.experience.ExperienceService;
import com.perez.portfolio.service.home.HomeService;
import com.perez.portfolio.service.project.ProjectService;
import com.perez.portfolio.service.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin
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
    ExperienceService experienceService;
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
            experienceService.getAll(),
            projectService.getAll()
        );
    }

    // === HOME ===
    // @PutMapping(path = "/portfolio/edit/home/update")
    // public Home updateHome(@RequestParam String title, @RequestParam String description) {
    //     return this.homeService.updateHome(title, description);
    // }
    @PutMapping(path = "/portfolio/edit/home/update")
    public Home updateHome(@RequestBody Home home) {
        System.out.println("received:" + home.toString());
        return this.homeService.updateHome(home.getTitle(), home.getDescription());
    }
    
    // === ABOUT ===
    // @PutMapping(path = "/portfolio/edit/about/update")
    // public About updateAbout(@RequestParam String description) {
    //     return this.aboutService.updateAbout(description);
    // }
    @PutMapping(path = "/portfolio/edit/about/update")
    public About updateAbout(@RequestBody About about) {
        return this.aboutService.updateAbout(about.getDescription());
    }
    
    // === SKILLS ===
    @DeleteMapping(path = "/portfolio/edit/skills/delete/{id}")
    public void deleteSkill(@PathVariable int id) {
        this.skillService.deleteSkill(id);
    }

    // @PutMapping(path = "/portfolio/edit/skills/update/{id}")
    // public Skill updateSkill(@PathVariable int id, @RequestParam String title, @RequestParam byte value) {
    //     return this.skillService.updateSkill(id, title, value);
    // }
    @PutMapping(path = "/portfolio/edit/skills/update/{id}")
    public Skill updateSkill(@PathVariable int id, @RequestBody Skill skill) {
        return this.skillService.updateSkill(id, skill.getTitle(), skill.getValue());
    }

    @PostMapping(path = "/portfolio/edit/skills/save")
    public Skill saveSkill(@RequestBody Skill skill) {
        return this.skillService.saveSkill(skill);
    }
    
    // === EDUCATION ===
    @DeleteMapping(path = "/portfolio/edit/education/delete/{id}")
    public void deleteEducation(@PathVariable int id) {
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

    // === EXPERIENCE ===
    @DeleteMapping(path = "/portfolio/edit/experience/delete/{id}")
    public void deleteExperience(@PathVariable int id) {
        this.experienceService.deleteExperience(id);
    }

    @PutMapping(path = "/portfolio/edit/experience/update/{id}")
    public Experience updateExperience(
        @PathVariable int id,
        @RequestParam String title,
        @RequestParam String period,
        @RequestParam String institution,
        @RequestParam String location,
        @RequestParam String description) {
        return this.experienceService.updateExperience(id, title, period, institution, location, description);
    }

    @PostMapping(path = "/portfolio/edit/experience/save")
    public Experience saveExperience(@RequestBody Experience ed) {
        return this.experienceService.saveExperience(ed);
    }

    // === PROJECTS ===
    @DeleteMapping(path = "/portfolio/edit/projects/delete/{id}")
    public void deleteProject(@PathVariable int id) {
        this.projectService.deleteProject(id);
    }

    @PutMapping(path = "/portfolio/edit/projects/update/{id}")
    public Project updateProject(
        @PathVariable int id,
        @RequestParam String title,
        @RequestParam String description,
        @RequestParam String url) {
        return this.projectService.updateProject(id, title, description, url);
    }

    @PostMapping(path = "/portfolio/edit/projects/save")
    public Project saveProject(@RequestBody Project proj) {
        return this.projectService.saveProject(proj);
    }
    
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
    
    @GetMapping("/hello")
    public String helo() {
        return "Hello world!";
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PortfolioUserService userDetailsService;
    
    @Autowired
    private JwtUtil jwtTokenUtil;
    
    @PostMapping(path = "/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authReq) throws Exception {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authReq.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
