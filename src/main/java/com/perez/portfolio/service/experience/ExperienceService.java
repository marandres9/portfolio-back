package com.perez.portfolio.service.experience;

import java.util.List;

import com.perez.portfolio.model.Experience;
import com.perez.portfolio.repository.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements ExperienceServiceInterface {
    @Autowired
    ExperienceRepository experienceRepo;

    @Override
    public List<Experience> getAll() {
        return experienceRepo.findAll();
    }

    @Override
    public Experience getExperience(int id) {
        return experienceRepo.findById(id).orElse(null);
    }

    @Override
    public Experience saveExperience(Experience exp) {
        return experienceRepo.save(exp);
    }

    @Override
    public void deleteExperience(int id) {
        experienceRepo.deleteById(id);
    }

    @Override
    public Experience updateExperience(int id, String title, String period, String institution, String location, String description) {
        // get and check not null
        Experience exp = this.getExperience(id);
        if(exp == null) return null;
        // update values
        exp.setTitle(title);
        exp.setPeriod(period);
        exp.setInstitution(institution);
        exp.setLocation(location);
        exp.setDescription(description);

        // save changes
        return this.saveExperience(exp);
    }
}
