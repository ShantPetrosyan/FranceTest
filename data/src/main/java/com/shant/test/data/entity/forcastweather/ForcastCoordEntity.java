package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class ForcastCoordEntity {

    @Expose
    private Double lat;
    @Expose
    private Double lon;
}
