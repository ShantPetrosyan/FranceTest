package com.shant.test.data.request;

import lombok.Data;

@Data
public class WeatherRequestInfo {

    private String city;
    private String countryCode;
    private String temperatureType;
    private String appId;
}
