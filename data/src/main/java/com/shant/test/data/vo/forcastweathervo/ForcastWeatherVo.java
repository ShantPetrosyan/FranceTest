package com.shant.test.data.vo.forcastweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ForcastWeatherVo extends RealmObject {

    public static final String PRIMARY_KEY = "dataId";

    @PrimaryKey
    private int dataId;
    private Long id;
    private String description;
    private String icon;
    private String main;

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
