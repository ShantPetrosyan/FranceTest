package com.shant.test.domain.bean.boundary.response.currentweather;

import lombok.Data;

@Data
public class WeatherResponseBo {

    private String description;
    private String icon;
    private String main;
    private Long id;
}
