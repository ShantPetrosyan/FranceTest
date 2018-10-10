package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class ForcastWeatherEntity {

    @Expose
    private String description;
    @Expose
    private String icon;
    @Expose
    private Long id;
    @Expose
    private String main;
}
