package com.shant.test.domain.bean.boundary.response.currentweather;

import lombok.Data;

@Data
public class SysResponseBo {

    private String country;
    private Double message;
    private Long sunrise;
    private Long sunset;
    private Long type;
    private Long id;
}
