package com.perez.portfolio.service;

import java.util.List;

import com.perez.portfolio.model.About;

public interface AboutServiceInterface {
    public List<About> getAll();

    public About getAbout();

    public About createAbout(About about);
}
