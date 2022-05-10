package com.perez.portfolio.service.project;

import java.util.List;

import com.perez.portfolio.model.Project;
import com.perez.portfolio.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements ProjectServiceInterface {
    @Autowired
    ProjectRepository projectRepo;

    @Override
    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    @Override
    public Project getProject(int id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProject(int id) {
        projectRepo.deleteById(id);
    }
    
    @Override
    public Project saveProject(Project project) {
        return projectRepo.save(project);
    }
    
    @Override
    public Project updateProject(int id, String title, String description, String url) {
        // get and check not null
        Project proj = this.getProject(id);
        if(proj == null) return null;
        // update values
        proj.setTitle(title);
        proj.setDescription(description);
        proj.setUrl(url);

        // save changes
        return this.saveProject(proj);
    }
}
