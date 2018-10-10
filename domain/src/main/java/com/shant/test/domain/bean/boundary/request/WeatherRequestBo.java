package com.shant.test.domain.bean.boundary.request;

import lombok.Data;

@Data
public class WeatherRequestBo {

    private String city;
    private String countryCode;
    private String temperatureType;
    private String appId;
    private boolean loadFromDB;
}
