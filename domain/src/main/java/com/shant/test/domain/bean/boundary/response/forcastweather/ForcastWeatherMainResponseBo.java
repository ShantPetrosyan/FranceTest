package com.shant.test.domain.bean.boundary.response.forcastweather;

import java.util.List;

import lombok.Data;

@Data
public class ForcastWeatherMainResponseBo {

    private List<ForCastByHoursResponseBos> forCastByHoursResponseBosList;
    private ForcastCityResponseBo forcastCityResponseBo;
    private Double message;
    private String cod;
    private Long cnt;
}
