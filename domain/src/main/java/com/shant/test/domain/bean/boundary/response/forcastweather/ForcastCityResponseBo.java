package com.shant.test.domain.bean.boundary.response.forcastweather;

import lombok.Data;

@Data
public class ForcastCityResponseBo {

    private ForcastCoordResponseBo coord;
    private Long population;
    private String country;
    private String name;
    private Long id;
}
