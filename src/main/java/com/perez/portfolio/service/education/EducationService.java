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
    public Education getEducation(int id) {
        return educationRepo.findById(id).orElse(null);
    }

    @Override
    public Education saveEducation(Education education) {
        return educationRepo.save(education);
    }

    @Override
    public void deleteEducation(int id) {
        educationRepo.deleteById(id);
    }

    @Override
    public Education updateEducation(int id, String title, String period, String institution, String location, String description) {
        // get and check not null
        Education ed = this.getEducation(id);
        if(ed == null) return null;
        // update values
        ed.setTitle(title);
        ed.setPeriod(period);
        ed.setInstitution(institution);
        ed.setLocation(location);
        ed.setDescription(description);

        // save changes
        return this.saveEducation(ed);
    }
}
