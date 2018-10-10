package com.shant.test.data.vo.forcastweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ForcastCityVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";

    @PrimaryKey
    private long id = System.currentTimeMillis();
    private ForcastCoordVo coord;
    private String country;
    private String name;
    private Long population;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ForcastCoordVo getCoord() {
        return coord;
    }

    public void setCoord(ForcastCoordVo coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
