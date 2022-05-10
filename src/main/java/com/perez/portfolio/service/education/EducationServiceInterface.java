package com.perez.portfolio.service.education;

import java.util.List;

import com.perez.portfolio.model.Education;

public interface EducationServiceInterface {
    public List<Education> getAll();

    public Education getEducation(int id);

    public Education saveEducation(Education education);

    public void deleteEducation(int id);

    public Education updateEducation(int id, String title, String period, String institution, String location, String description);
}
