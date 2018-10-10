package com.shant.test.data.vo.currentweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WeatherVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";
    @PrimaryKey
    private Long id;
    private String description;
    private String icon;
    private String main;

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
