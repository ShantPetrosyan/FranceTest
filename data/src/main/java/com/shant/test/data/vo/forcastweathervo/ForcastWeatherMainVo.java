package com.shant.test.data.vo.forcastweathervo;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ForcastWeatherMainVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";

    @PrimaryKey
    private long id = System.currentTimeMillis();
    private ForcastCityVo forcastCityVo;
    private Long cnt;
    private String cod;
    private RealmList<ForCastByHoursVo> forCastByHoursVos;
    private Double message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ForcastCityVo getForcastCityVo() {
        return forcastCityVo;
    }

    public void setForcastCityVo(ForcastCityVo forcastCityVo) {
        this.forcastCityVo = forcastCityVo;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public RealmList<ForCastByHoursVo> getForCastByHoursVos() {
        return forCastByHoursVos;
    }

    public void setForCastByHoursVos(RealmList<ForCastByHoursVo> forCastByHoursVos) {
        this.forCastByHoursVos = forCastByHoursVos;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }
}
