package com.shant.test.data.vo.forcastweathervo;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ForCastByHoursVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";

    @PrimaryKey
    private int id;
    private Long dt;
    private ForcastCloudsVo forcastCloudsVo;
    private String dtTxt;
    private ForcastMainVo forcastMainVo;
    private ForcastRainVo forcastRainVo;
    private ForcastSysVo forcastSysVo;
    private RealmList<ForcastWeatherVo> forcastWeatherVos;
    private ForcastWindVo forcastWindVo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ForcastCloudsVo getForcastCloudsVo() {
        return forcastCloudsVo;
    }

    public void setForcastCloudsVo(ForcastCloudsVo forcastCloudsVo) {
        this.forcastCloudsVo = forcastCloudsVo;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public ForcastMainVo getForcastMainVo() {
        return forcastMainVo;
    }

    public void setForcastMainVo(ForcastMainVo forcastMainVo) {
        this.forcastMainVo = forcastMainVo;
    }

    public ForcastRainVo getForcastRainVo() {
        return forcastRainVo;
    }

    public void setForcastRainVo(ForcastRainVo forcastRainVo) {
        this.forcastRainVo = forcastRainVo;
    }

    public ForcastSysVo getForcastSysVo() {
        return forcastSysVo;
    }

    public void setForcastSysVo(ForcastSysVo forcastSysVo) {
        this.forcastSysVo = forcastSysVo;
    }

    public RealmList<ForcastWeatherVo> getForcastWeatherVos() {
        return forcastWeatherVos;
    }

    public void setForcastWeatherVos(RealmList<ForcastWeatherVo> forcastWeatherVos) {
        this.forcastWeatherVos = forcastWeatherVos;
    }

    public ForcastWindVo getForcastWindVo() {
        return forcastWindVo;
    }

    public void setForcastWindVo(ForcastWindVo forcastWindVo) {
        this.forcastWindVo = forcastWindVo;
    }
}
