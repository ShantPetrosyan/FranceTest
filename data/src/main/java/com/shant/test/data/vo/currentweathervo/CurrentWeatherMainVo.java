package com.shant.test.data.vo.currentweathervo;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CurrentWeatherMainVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";

    @PrimaryKey
    private Long id;
    private String base;
    private CloudsVo clouds;
    private Long cod;
    private CoordVo coord;
    private Long dt;
    private MainVo main;
    private String name;
    private SysVo sys;
    private Long visibility;
    private RealmList<WeatherVo> weatherList;
    private WindVo wind;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public CloudsVo getClouds() {
        return clouds;
    }

    public void setClouds(CloudsVo clouds) {
        this.clouds = clouds;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public CoordVo getCoord() {
        return coord;
    }

    public void setCoord(CoordVo coord) {
        this.coord = coord;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public MainVo getMain() {
        return main;
    }

    public void setMain(MainVo main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysVo getSys() {
        return sys;
    }

    public void setSys(SysVo sys) {
        this.sys = sys;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public RealmList<WeatherVo> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(RealmList<WeatherVo> weatherList) {
        this.weatherList = weatherList;
    }

    public WindVo getWind() {
        return wind;
    }

    public void setWind(WindVo wind) {
        this.wind = wind;
    }
}
