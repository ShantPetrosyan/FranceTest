package com.shant.test.mytestapplication.model.currentweathermodels;

import java.io.Serializable;

import lombok.Data;

@Data
public class CurrentWindModel implements Serializable {

    private Long deg;
    private Double speed;
}
