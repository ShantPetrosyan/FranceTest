package com.shant.test.data.entity.forcastweather;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ForcastRainEntity {

    @SerializedName("3h")
    private Double threeHour;
}
