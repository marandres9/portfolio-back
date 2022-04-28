package com.perez.portfolio.dto;

import com.perez.portfolio.model.About;
import com.perez.portfolio.model.Home;

public class PortfolioDTO {
    private String home_title;
    private String home_description;
    private String about_description;

    public PortfolioDTO(Home home, About about) {
        this.home_title = home.getTitle();
        this.home_description = home.getDescription();
        this.about_description = about.getDescription();
    }

    public String getHome_title() {
        return this.home_title;
    }

    public void setHome_title(String home_title) {
        this.home_title = home_title;
    }

    public String getHome_description() {
        return this.home_description;
    }

    public void setHome_description(String home_description) {
        this.home_description = home_description;
    }

    public String getAbout_description() {
        return this.about_description;
    }

    public void setAbout_description(String about_description) {
        this.about_description = about_description;
    }

}
