package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class ForcastWindEntity {

    @Expose
    private Double deg;
    @Expose
    private Double speed;
}
