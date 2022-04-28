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
    public Project getProject() {
        return getAll().get(0);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepo.save(project);
    }
}
