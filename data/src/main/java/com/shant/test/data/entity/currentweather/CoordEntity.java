package com.shant.test.data.entity.currentweather;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class CoordEntity {

    @Expose
    private Double lat;
    @Expose
    private Double lon;
}
