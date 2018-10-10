package com.shant.test.domain.bean.boundary.response.currentweather;

import java.util.List;

import lombok.Data;

@Data
public class CurrentWeatherMainResponseBo {

    private String base;
    private CloudsResponseBo clouds;
    private Long cod;
    private CoordResponseBo coord;
    private Long dt;
    private Long id;
    private MainResponseBo main;
    private String name;
    private SysResponseBo sys;
    private Long visibility;
    private List<WeatherResponseBo> weatherList;
    private WindResponseBo wind;
}
