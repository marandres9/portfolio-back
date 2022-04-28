package com.perez.portfolio.service.education;

import java.util.List;

import com.perez.portfolio.model.Education;

public interface EducationServiceInterface {
    public List<Education> getAll();
    public Education getEducation();
    public Education createEducation(Education education);
}
