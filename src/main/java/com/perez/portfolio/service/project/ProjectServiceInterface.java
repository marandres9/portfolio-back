package com.perez.portfolio.service.project;

import java.util.List;

import com.perez.portfolio.model.Project;

public interface ProjectServiceInterface {
    public List<Project> getAll();
    
    public Project getProject(int id);
    
    public Project saveProject(Project project);
    
    public void deleteProject(int id);

    public Project updateProject(int id, String title, String description, String url);
}
