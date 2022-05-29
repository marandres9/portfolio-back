package com.perez.portfolio.controller;

import com.perez.portfolio.model.Project;
import com.perez.portfolio.service.project.ProjectService;

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
public class ProjectsController {
    @Autowired
    ProjectService projectService;
    
    @DeleteMapping(path = "/portfolio/edit/projects/delete/{id}")
    public void deleteProject(@PathVariable int id) {
        this.projectService.deleteProject(id);
    }

    @PutMapping(path = "/portfolio/edit/projects/update/{id}")
    public Project updateProject(
            @PathVariable int id,
            @RequestBody Project proj) {
        return this.projectService.updateProject(
            id,
            proj.getTitle(),
            proj.getDescription(),
            proj.getUrl());
    }

    @PostMapping(path = "/portfolio/edit/projects/save")
    public Project saveProject(@RequestBody Project proj) {
        return this.projectService.saveProject(proj);
    }

}
