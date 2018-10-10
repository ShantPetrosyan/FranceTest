package com.shant.test.data.vo.forcastweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ForcastWindVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";

    @PrimaryKey
    private int id;
    private Double deg;
    private Double speed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
