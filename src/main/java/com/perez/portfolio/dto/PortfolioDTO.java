package com.perez.portfolio.dto;

import java.util.List;

import com.perez.portfolio.model.About;
import com.perez.portfolio.model.Education;
import com.perez.portfolio.model.Experience;
import com.perez.portfolio.model.Home;
import com.perez.portfolio.model.Skill;
import com.perez.portfolio.model.Project;

public class PortfolioDTO {
    private String home_title;
    private String home_description;
    private String about_description;
    private List<Skill> hardSkills;
    private List<Skill> softSkills;
    private List<Education> educations;
    private List<Experience> experiences;
    private List<Project> projects;
    
    public PortfolioDTO(Home home,
                        About about,
                        List<Skill> hardSkills,
                        List<Skill> softSkills,
                        List<Education> educations,
                        List<Experience> experiences,
                        List<Project> projects) {
        this.home_title = home.getTitle();
        this.home_description = home.getDescription();
        this.about_description = about.getDescription();
        this.hardSkills = hardSkills;
        this.softSkills = softSkills;
        this.educations = educations;
        this.experiences = experiences;
        this.projects = projects;
    }

    public List<Skill> getHardSkills() {
        return this.hardSkills;
    }

    public void setHardSkills(List<Skill> hardSkills) {
        this.hardSkills = hardSkills;
    }

    public List<Experience> getExperiences() {
        return this.experiences;
    }

    public void setExperiences(List<Experience> experience) {
        this.experiences = experience;
    }

    public List<Skill> getSoftSkills() {
        return this.softSkills;
    }

    public void setSoftSkills(List<Skill> softSkills) {
        this.softSkills = softSkills;
    }

    public String getHome_title() {
        return this.home_title;
    }

    public void setHome_title(String home_title) {
        this.home_title = home_title;
    }

    public List<Education> getEducations() {
        return this.educations;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public String getHome_description() {
        return this.home_description;
    }

    public void setHome_description(String home_description) {
        this.home_description = home_description;
    }

    public String getAbout_description() {
        return this.about_description;
    }

    public void setAbout_description(String about_description) {
        this.about_description = about_description;
    }
    
}
