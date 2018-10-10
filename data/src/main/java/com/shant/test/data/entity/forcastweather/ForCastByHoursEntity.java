package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class ForCastByHoursEntity {

    @SerializedName("clouds")
    private ForcastCloudsEntity forcastCloudsEntity;
    @Expose
    private Long dt;
    @SerializedName("dt_txt")
    private String dtTxt;
    @SerializedName("main")
    private ForcastMainEntity forcastMainEntity;
    @SerializedName("rain")
    private ForcastRainEntity forcastRainEntity;
    @SerializedName("sys")
    private ForcastSysEntity forcastSysEntity;
    @SerializedName("weather")
    private List<ForcastWeatherEntity> forcastWeatherEntity;
    @SerializedName("wind")
    private ForcastWindEntity forcastWindEntity;
}
