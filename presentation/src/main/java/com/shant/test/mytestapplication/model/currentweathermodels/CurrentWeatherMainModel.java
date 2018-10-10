package com.shant.test.mytestapplication.model.currentweathermodels;

import java.io.Serializable;
import java.util.List;

public class CurrentWeatherMainModel implements Serializable {

    private String base;
    private CurrentCloudsModel clouds;
    private Long cod;
    private CurrentCoordModel coord;
    private Long dt;
    private Long id;
    private CurrentMainModel main;
    private String name;
    private CurrentSysModel sys;
    private Long visibility;
    private List<CurrentWeatherModel> weatherList;
    private CurrentWindModel wind;
    private int rain;

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public CurrentCloudsModel getClouds() {
        return clouds;
    }

    public void setClouds(CurrentCloudsModel clouds) {
        this.clouds = clouds;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public CurrentCoordModel getCoord() {
        return coord;
    }

    public void setCoord(CurrentCoordModel coord) {
        this.coord = coord;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrentMainModel getMain() {
        return main;
    }

    public void setMain(CurrentMainModel main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentSysModel getSys() {
        return sys;
    }

    public void setSys(CurrentSysModel sys) {
        this.sys = sys;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public List<CurrentWeatherModel> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<CurrentWeatherModel> weatherList) {
        this.weatherList = weatherList;
    }

    public CurrentWindModel getWind() {
        return wind;
    }

    public void setWind(CurrentWindModel wind) {
        this.wind = wind;
    }
}
