package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ForcastMainEntity {

    @SerializedName("grnd_level")
    private Double grndLevel;
    @Expose
    private Long humidity;
    @Expose
    private Double pressure;
    @SerializedName("sea_level")
    private Double seaLevel;
    @Expose
    private Double temp;
    @SerializedName("temp_kf")
    private Double tempKf;
    @SerializedName("temp_max")
    private Double tempMax;
    @SerializedName("temp_min")
    private Double tempMin;
}
