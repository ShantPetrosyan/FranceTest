package com.shant.test.mytestapplication.model.forcastweathermodels;

import java.util.List;

import lombok.Data;

@Data
public class ForcastWeatherMainModel {

    private List<ForCastByHoursModels> forCastByHoursModels;
    private ForcastCityModel forcastCityModel;
    private Double message;
    private String cod;
    private Long cnt;
}
