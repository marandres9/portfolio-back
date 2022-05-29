package com.perez.portfolio.controller;

import com.perez.portfolio.model.Home;
import com.perez.portfolio.service.home.HomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    HomeService homeService;
    
    @PutMapping(path = "/portfolio/edit/home/update")
    public Home updateHome(@RequestBody Home home) {
        System.out.println("received" + home.toString());
        return this.homeService.updateHome(home.getTitle(), home.getDescription());
    }

    @GetMapping(path = "/test/gethome")
    public Home getHome() {
        return homeService.getHome();
    }

}