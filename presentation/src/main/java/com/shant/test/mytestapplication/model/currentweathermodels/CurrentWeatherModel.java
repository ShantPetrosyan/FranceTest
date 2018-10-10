package com.shant.test.mytestapplication.model.currentweathermodels;

import java.io.Serializable;

import lombok.Data;

public class CurrentWeatherModel implements Serializable {

    private String description;
    private String icon;
    private String main;
    private Long id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
