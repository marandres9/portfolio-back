package com.perez.portfolio.service.about;

import java.util.List;

import com.perez.portfolio.model.About;

public interface AboutServiceInterface {
    public List<About> getAll();

    public About getAbout();

    public About saveAbout(About about);

    public About updateAbout(String description);
}
