package com.shant.test.data.entity.currentweather;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class SysEntity {

    @Expose
    private String country;
    @Expose
    private Long id;
    @Expose
    private Double message;
    @Expose
    private Long sunrise;
    @Expose
    private Long sunset;
    @Expose
    private Long type;
}
