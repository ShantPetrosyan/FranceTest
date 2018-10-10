package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class ForcastCityEntity {

    @Expose
    private ForcastCoordEntity coord;
    @Expose
    private String country;
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private Long population;
}
