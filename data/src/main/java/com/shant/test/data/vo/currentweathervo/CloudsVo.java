package com.shant.test.data.vo.currentweathervo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CloudsVo extends RealmObject {

    public static final String PRIMARY_KEY = "id";

    @PrimaryKey
    private long id = System.currentTimeMillis();
    private Long all;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAll() {
        return all;
    }

    public void setAll(Long all) {
        this.all = all;
    }
}
