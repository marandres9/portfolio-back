package com.perez.portfolio.service.about;

import java.util.List;

import com.perez.portfolio.model.About;
import com.perez.portfolio.repository.AboutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements AboutServiceInterface {
    @Autowired
    AboutRepository aboutRepo;

    @Override
    public List<About> getAll() {
        return aboutRepo.findAll();
    }

    @Override
    public About getAbout() {
        return this.getAll().get(0);
    }

    @Override
    public About saveAbout(About about) {
        return aboutRepo.save(about);
    }

    @Override
    public About updateAbout(String description) {
         // get and check not null
         About about = this.getAbout();
         if(about == null) return null;
         // update values
         about.setDescription(description);
 
         // save changes
        return this.saveAbout(about);
 
    }
}
