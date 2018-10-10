package com.shant.test.data.entity.currentweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class CurrentWeatherMainEntity {

    @Expose
    private String base;
    @Expose
    private CloudsEntity clouds;
    @Expose
    private Long cod;
    @Expose
    private CoordEntity coord;
    @Expose
    private Long dt;
    @Expose
    private Long id;
    @Expose
    private MainEntity main;
    @Expose
    private String name;
    @Expose
    private SysEntity sys;
    @Expose
    private Long visibility;
    @SerializedName("weather")
    private List<WeatherEntity> weatherList;
    @Expose
    private WindEntity wind;
    @Expose
    private Double message;
}
