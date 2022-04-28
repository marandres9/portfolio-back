package com.perez.portfolio.service.project;

import java.util.List;

import com.perez.portfolio.model.Project;

public interface ProjectServiceInterface {
    public List<Project> getAll();
    public Project getProject();
    public Project createProject(Project project);
}
