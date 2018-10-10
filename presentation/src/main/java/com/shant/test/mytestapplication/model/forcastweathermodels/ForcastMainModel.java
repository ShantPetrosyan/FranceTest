package com.shant.test.mytestapplication.model.forcastweathermodels;

import lombok.Data;

@Data
public class ForcastMainModel {

    private Double grndLevel;
    private Long humidity;
    private Double pressure;
    private Double seaLevel;
    private Double temp;
    private Double tempKf;
    private Double tempMax;
    private Double tempMin;
}
