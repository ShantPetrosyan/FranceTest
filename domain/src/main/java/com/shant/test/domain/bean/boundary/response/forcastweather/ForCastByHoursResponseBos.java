package com.shant.test.domain.bean.boundary.response.forcastweather;

import java.util.List;

import lombok.Data;

@Data
public class ForCastByHoursResponseBos {

    private List<ForcastWeatherResponseBo> forcastWeatherResponseBos;
    private ForcastCloudsResponseBo forcastCloudsResponseBo;
    private ForcastWindResponseBo forcastWindResponseBo;
    private ForcastMainResponseBo forcastMainResponseBo;
    private ForcastRainResponseBo forcastRainResponseBo;
    private ForcastSysResponseBo forcastSysResponseBo;
    private String dtTxt;
    private Long dt;
}
