package com.shant.test.domain.bean.boundary.response.forcastweather;

import lombok.Data;

@Data
public class ForcastMainResponseBo {

    private Double grndLevel;
    private Long humidity;
    private Double pressure;
    private Double seaLevel;
    private Double temp;
    private Double tempKf;
    private Double tempMax;
    private Double tempMin;
}
