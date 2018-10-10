package com.shant.test.domain.bean.boundary.response.currentweather;

import lombok.Data;

@Data
public class MainResponseBo {

    private Double tempMax;
    private Double tempMin;
    private Long pressure;
    private Long humidity;
    private Double temp;
}
