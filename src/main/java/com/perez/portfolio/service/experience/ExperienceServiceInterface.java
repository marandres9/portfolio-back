package com.perez.portfolio.service.experience;

import java.util.List;

import com.perez.portfolio.model.Experience;

public interface ExperienceServiceInterface {
    public List<Experience> getAll();

    public Experience getExperience(int id);

    public Experience saveExperience(Experience exp);

    public void deleteExperience(int id);

    public Experience updateExperience(int id, String title, String period, String institution, String location, String description);
}
