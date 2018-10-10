package com.shant.test.data.vo.currentweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SysVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";
    @PrimaryKey
    private Long id;
    private String country;
    private Double message;
    private Long sunrise;
    private Long sunset;
    private Long type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
