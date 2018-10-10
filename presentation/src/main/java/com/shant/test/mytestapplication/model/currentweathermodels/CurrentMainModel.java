package com.shant.test.mytestapplication.model.currentweathermodels;

import java.io.Serializable;

import lombok.Data;

@Data
public class CurrentMainModel implements Serializable {

    private Double tempMax;
    private Double tempMin;
    private Long pressure;
    private Long humidity;
    private Double temp;
}
