package com.perez.portfolio.dto;

import java.util.List;

import com.perez.portfolio.model.About;
import com.perez.portfolio.model.Education;
import com.perez.portfolio.model.Home;
import com.perez.portfolio.model.Skill;

public class PortfolioDTO {
    private String home_title;
    private String home_description;
    private String about_description;
    private List<Skill> skills;
    private List<Education> education;

    public PortfolioDTO(Home home,
                        About about,
                        List<Skill> skills,
                        List<Education> education) {
        this.home_title = home.getTitle();
        this.home_description = home.getDescription();
        this.about_description = about.getDescription();
        this.skills = skills;
        this.education = education;
    }

    public String getHome_title() {
        return this.home_title;
    }

    public void setHome_title(String home_title) {
        this.home_title = home_title;
    }

    public List<Education> getEducation() {
        return this.education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
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

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
