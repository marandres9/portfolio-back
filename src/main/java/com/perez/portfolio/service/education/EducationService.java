package com.perez.portfolio.service.education;

import java.util.List;

import com.perez.portfolio.model.Education;
import com.perez.portfolio.repository.EducationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements EducationServiceInterface {
    @Autowired
    EducationRepository educationRepo;

    @Override
    public List<Education> getAll() {
        return educationRepo.findAll();
    }

    @Override
    public Education getEducation() {
        return getAll().get(0);
    }

    @Override
    public Education createEducation(Education education) {
        return educationRepo.save(education);
    }
}
