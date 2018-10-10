package com.shant.test.data.vo.currentweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WindVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";
    @PrimaryKey
    private long id = System.currentTimeMillis();
    private Long deg;
    private Double speed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getDeg() {
        return deg;
    }

    public void setDeg(Long deg) {
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
