package com.shant.test.mytestapplication.model.forcastweathermodels;

import java.io.Serializable;

import lombok.Data;

@Data
public class ForcastOneDayInfoModel implements Serializable {

    private Long dateTime;
    private String weekName;
    private int minTemperatura;
    private int maxTemperatura;
    private Long dayWeatherCode;
    private Long nightWeatherCode;
}
