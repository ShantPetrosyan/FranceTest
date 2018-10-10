
package com.shant.test.data.entity.currentweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class MainEntity {

    @Expose
    private Long humidity;
    @Expose
    private Long pressure;
    @Expose
    private Double temp;
    @SerializedName("temp_max")
    private Double tempMax;
    @SerializedName("temp_min")
    private Double tempMin;
}
