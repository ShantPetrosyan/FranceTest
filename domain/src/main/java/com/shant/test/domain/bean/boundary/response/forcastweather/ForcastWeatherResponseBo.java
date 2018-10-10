package com.shant.test.domain.bean.boundary.response.forcastweather;

import lombok.Data;

@Data
public class ForcastWeatherResponseBo {

    private String description;
    private String icon;
    private String main;
    private Long id;
}
