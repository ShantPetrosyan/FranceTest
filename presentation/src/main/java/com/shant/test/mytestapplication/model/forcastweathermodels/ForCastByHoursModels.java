package com.shant.test.mytestapplication.model.forcastweathermodels;

import java.util.List;

import lombok.Data;

@Data
public class ForCastByHoursModels {

    private List<ForcastWeatherModel> forcastWeatherModels;
    private ForcastCloudsModel forcastCloudsModel;
    private ForcastWindModel forcastWindModel;
    private ForcastMainModel forcastMainModel;
    private ForcastRainModel forcastRainModel;
    private ForcastSysModel forcastSysModel;
    private String dtTxt;
    private Long dateAndTime;
    private String weekName;
}
