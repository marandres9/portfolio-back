package com.perez.portfolio.service.home;

import java.util.List;

import com.perez.portfolio.model.Home;

public interface HomeServiceInterface {
    public List<Home> getAll();
    
    public Home getHome();
    
    public Home saveHome(Home home);

    public Home updateHome(String title, String description);
}
