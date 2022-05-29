package com.perez.portfolio.controller;

import com.perez.portfolio.model.About;
import com.perez.portfolio.service.about.AboutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://my-portfolio-65acc.web.app/", maxAge = 3600)
public class AboutController {
    @Autowired
    AboutService aboutService;

    @PutMapping(path = "/portfolio/edit/about/update")
    public About updateAbout(@RequestBody About about) {
        return this.aboutService.updateAbout(about.getDescription());
    }

    
}
