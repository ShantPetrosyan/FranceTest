package com.shant.test.data.entity.mapper;

import com.shant.test.data.entity.currentweather.CloudsEntity;
import com.shant.test.data.entity.currentweather.CoordEntity;
import com.shant.test.data.entity.currentweather.CurrentWeatherMainEntity;
import com.shant.test.data.entity.currentweather.MainEntity;
import com.shant.test.data.entity.currentweather.SysEntity;
import com.shant.test.data.entity.currentweather.WeatherEntity;
import com.shant.test.data.entity.currentweather.WindEntity;
import com.shant.test.domain.bean.boundary.response.currentweather.CloudsResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CoordResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CurrentWeatherMainResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.MainResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.SysResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.WeatherResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.WindResponseBo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform current weather enities (in the data layer) to Business Objects (Bo) in the
 * domain layer.
 */
@Singleton
public class CurWeatherEntitiesDataMapper {

    @Inject
    public CurWeatherEntitiesDataMapper() {
    }

    public CurrentWeatherMainResponseBo toBo(CurrentWeatherMainEntity currentWeatherMainEntity) {
        CurrentWeatherMainResponseBo currentWeatherMainResponseBo = new CurrentWeatherMainResponseBo();

        if (currentWeatherMainEntity != null) {
            currentWeatherMainResponseBo.setBase(currentWeatherMainEntity.getBase());
            currentWeatherMainResponseBo.setClouds(toBo(currentWeatherMainEntity.getClouds()));
            currentWeatherMainResponseBo.setCod(currentWeatherMainEntity.getCod());
            currentWeatherMainResponseBo.setCoord(toBo(currentWeatherMainEntity.getCoord()));
            currentWeatherMainResponseBo.setDt(currentWeatherMainEntity.getDt());
            currentWeatherMainResponseBo.setId(currentWeatherMainEntity.getId());
            currentWeatherMainResponseBo.setMain(toBo(currentWeatherMainEntity.getMain()));
            currentWeatherMainResponseBo.setName(currentWeatherMainEntity.getName());
            currentWeatherMainResponseBo.setSys(toBo(currentWeatherMainEntity.getSys()));
            currentWeatherMainResponseBo.setVisibility(currentWeatherMainEntity.getVisibility());
            currentWeatherMainResponseBo.setWind(toBo(currentWeatherMainEntity.getWind()));
            currentWeatherMainResponseBo.setWeatherList(toBoList(currentWeatherMainEntity.getWeatherList()));
        }

        return currentWeatherMainResponseBo;
    }

    private List<WeatherResponseBo> toBoList(List<WeatherEntity> weatherList) {
        List<WeatherResponseBo> weatherResponseBos = new ArrayList<>();
        if (weatherList != null) {
            for (WeatherEntity weatherEntity : weatherList) {
                weatherResponseBos.add(toBo(weatherEntity));
            }
        }

        return weatherResponseBos;
    }

    private CloudsResponseBo toBo(CloudsEntity clouds) {
        CloudsResponseBo cloudsResponseBo = new CloudsResponseBo();
        if (clouds != null) {
            cloudsResponseBo.setAll(clouds.getAll());
        }
        return cloudsResponseBo;
    }

    public WeatherResponseBo toBo(WeatherEntity weatherEntity) {
        WeatherResponseBo weatherResponseBo = new WeatherResponseBo();
        if (weatherEntity != null) {
            weatherResponseBo.setDescription(weatherEntity.getDescription());
            weatherResponseBo.setIcon(weatherEntity.getIcon());
            weatherResponseBo.setId(weatherEntity.getId());
            weatherResponseBo.setMain(weatherEntity.getMain());
        }
        return weatherResponseBo;
    }

    public CoordResponseBo toBo(CoordEntity coordEntity) {
        CoordResponseBo coordResponseBo = new CoordResponseBo();
        if (coordEntity != null) {
            coordResponseBo.setLat(coordEntity.getLat());
            coordResponseBo.setLon(coordEntity.getLon());
        }
        return coordResponseBo;
    }

    public MainResponseBo toBo(MainEntity mainEntity) {
        MainResponseBo mainResponseBo = new MainResponseBo();
        if (mainEntity != null) {
            mainResponseBo.setHumidity(mainEntity.getHumidity());
            mainResponseBo.setPressure(mainEntity.getPressure());
            mainResponseBo.setTemp(mainEntity.getTemp());
            mainResponseBo.setTempMax(mainEntity.getTempMax());
            mainResponseBo.setTempMin(mainEntity.getTempMin());
        }
        return mainResponseBo;
    }

    public SysResponseBo toBo(SysEntity sysEntity) {
        SysResponseBo sysResponseBo = new SysResponseBo();
        if (sysEntity != null) {
            sysResponseBo.setId(sysEntity.getId());
            sysResponseBo.setCountry(sysEntity.getCountry());
            sysResponseBo.setMessage(sysEntity.getMessage());
            sysResponseBo.setSunrise(sysEntity.getSunrise());
            sysResponseBo.setSunset(sysEntity.getSunset());
            sysResponseBo.setType(sysEntity.getType());
        }
        return sysResponseBo;
    }

    public WindResponseBo toBo(WindEntity windEntity) {
        WindResponseBo windResponseBo = new WindResponseBo();
        if (windEntity != null) {
            windResponseBo.setDeg(windEntity.getDeg());
            windResponseBo.setSpeed(windEntity.getSpeed());
        }

        return windResponseBo;
    }
}
