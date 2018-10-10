package com.shant.test.domain.repository;

import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CurrentWeatherMainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWeatherMainResponseBo;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting weather related data.
 */
public interface WeatherRepository {

    /**
     * Get an {@link Observable} which will emit a data of {@link RSSMainBo}.
     */
    Observable<ForcastWeatherMainResponseBo> getForcastWeatherData(WeatherRequestBo weatherRequestBo);

    /**
     * Get an {@link Observable} which will emit a data of {@link CurrentWeatherMainResponseBo}.
     */
    Observable<CurrentWeatherMainResponseBo> getCurrentDayData(WeatherRequestBo weatherRequestBo);
}
