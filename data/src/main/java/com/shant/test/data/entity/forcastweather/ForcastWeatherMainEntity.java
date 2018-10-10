package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class ForcastWeatherMainEntity {

    @SerializedName("city")
    private ForcastCityEntity forcastCityEntity;
    @Expose
    private Long cnt;
    @Expose
    private String cod;
    @SerializedName("list")
    private List<ForCastByHoursEntity> forCastByHoursEntity;
    @Expose
    private Double message;
}
