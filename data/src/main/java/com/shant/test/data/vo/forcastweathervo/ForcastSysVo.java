package com.shant.test.data.vo.forcastweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ForcastSysVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";

    @PrimaryKey
    private long id;
    private String pod;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
