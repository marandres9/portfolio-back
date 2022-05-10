package com.perez.portfolio.service.home;

import java.util.List;

import com.perez.portfolio.model.Home;
import com.perez.portfolio.repository.HomeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService implements HomeServiceInterface {
    @Autowired
    HomeRepository homeRepo;

    @Override
    public List<Home> getAll() {
        return homeRepo.findAll();
    }

    @Override
    public Home getHome() {
        return getAll().get(0);
    }

    @Override
    public Home saveHome(Home home) {
        return homeRepo.save(home);
    }

    @Override
    public Home updateHome(String title, String description) {
        // get and check not null
        Home home = this.getHome();
        if(home == null) return null;
        // update values
        home.setTitle(title);
        home.setDescription(description);

        // save changes
        this.saveHome(home);

        return home;
    }

}
