package com.shant.test.mytestapplication.model.forcastweathermodels;

import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastCoordResponseBo;

import lombok.Data;

@Data
public class ForcastCityModel {

    private ForcastCoordModel coord;
    private Long population;
    private String country;
    private String name;
    private Long id;
}
