package com.shant.test.mytestapplication.model.currentweathermodels;

import java.io.Serializable;

import lombok.Data;

@Data
public class CurrentCoordModel implements Serializable {

    private Double lat;
    private Double lon;
}
