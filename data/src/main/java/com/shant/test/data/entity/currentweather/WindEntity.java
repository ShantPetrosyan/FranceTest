package com.shant.test.data.entity.currentweather;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class WindEntity {

    @Expose
    private Long deg;
    @Expose
    private Double speed;
}
