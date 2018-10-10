package com.shant.test.mytestapplication.model.currentweathermodels;

import java.io.Serializable;

import lombok.Data;

@Data
public class CurrentSysModel implements Serializable {

    private String country;
    private Double message;
    private Long sunrise;
    private Long sunset;
    private Long type;
    private Long id;
}
