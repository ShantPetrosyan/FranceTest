package com.shant.test.mytestapplication.model.forcastweathermodels;

import lombok.Data;

@Data
public class ForcastWeatherModel {

    private String description;
    private String icon;
    private String main;
    private Long id;
}
