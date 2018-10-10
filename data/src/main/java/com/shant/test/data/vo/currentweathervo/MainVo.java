package com.shant.test.data.vo.currentweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MainVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";
    @PrimaryKey
    private long id = System.currentTimeMillis();
    private Long humidity;
    private Long pressure;
    private Double temp;
    private Double tempMax;
    private Double tempMin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }
}
