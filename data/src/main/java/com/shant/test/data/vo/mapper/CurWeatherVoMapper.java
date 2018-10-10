package com.shant.test.data.vo.mapper;

import com.shant.test.data.entity.currentweather.CloudsEntity;
import com.shant.test.data.entity.currentweather.CoordEntity;
import com.shant.test.data.entity.currentweather.CurrentWeatherMainEntity;
import com.shant.test.data.entity.currentweather.MainEntity;
import com.shant.test.data.entity.currentweather.SysEntity;
import com.shant.test.data.entity.currentweather.WeatherEntity;
import com.shant.test.data.entity.currentweather.WindEntity;
import com.shant.test.data.vo.currentweathervo.CloudsVo;
import com.shant.test.data.vo.currentweathervo.CoordVo;
import com.shant.test.data.vo.currentweathervo.CurrentWeatherMainVo;
import com.shant.test.data.vo.currentweathervo.MainVo;
import com.shant.test.data.vo.currentweathervo.SysVo;
import com.shant.test.data.vo.currentweathervo.WeatherVo;
import com.shant.test.data.vo.currentweathervo.WindVo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.RealmList;

/**
 * Mapper class used to transform current weather enities (in the data layer) to Business Objects (Bo) in the
 * domain layer.
 */
@Singleton
public class CurWeatherVoMapper {

    @Inject
    public CurWeatherVoMapper() {
    }

    /**
     *  Converting from {@link CurrentWeatherMainEntity} to {@link CurrentWeatherMainVo}
     * @param currentWeatherMainEntity
     * @return
     */
    public CurrentWeatherMainVo toVo(CurrentWeatherMainEntity currentWeatherMainEntity) {
        CurrentWeatherMainVo weatherMainVo = new CurrentWeatherMainVo();

        if (currentWeatherMainEntity != null) {
            weatherMainVo.setBase(currentWeatherMainEntity.getBase());
            weatherMainVo.setClouds(toVo(currentWeatherMainEntity.getClouds()));
            weatherMainVo.setCod(currentWeatherMainEntity.getCod());
            weatherMainVo.setCoord(toVo(currentWeatherMainEntity.getCoord()));
            weatherMainVo.setDt(currentWeatherMainEntity.getDt());
            weatherMainVo.setId(currentWeatherMainEntity.getId());
            weatherMainVo.setMain(toVo(currentWeatherMainEntity.getMain()));
            weatherMainVo.setName(currentWeatherMainEntity.getName());
            weatherMainVo.setSys(toVo(currentWeatherMainEntity.getSys()));
            weatherMainVo.setVisibility(currentWeatherMainEntity.getVisibility());
            weatherMainVo.setWind(toVo(currentWeatherMainEntity.getWind()));
            weatherMainVo.setWeatherList(toVoList(currentWeatherMainEntity.getWeatherList()));
        }

        return weatherMainVo;
    }

    /**
     *  Converting from type of {@link CurrentWeatherMainVo} to {@link CurrentWeatherMainEntity}
     * @param mainVo
     * @return
     */
    public CurrentWeatherMainEntity toEntity(CurrentWeatherMainVo mainVo) {
        CurrentWeatherMainEntity mainEntity = new CurrentWeatherMainEntity();

        if (mainVo != null) {
            mainEntity.setBase(mainVo.getBase());
            mainEntity.setClouds(toEntity(mainVo.getClouds()));
            mainEntity.setCod(mainVo.getCod());
            mainEntity.setCoord(toEntity(mainVo.getCoord()));
            mainEntity.setDt(mainVo.getDt());
            mainEntity.setId(mainVo.getId());
            mainEntity.setMain(toEntity(mainVo.getMain()));
            mainEntity.setName(mainVo.getName());
            mainEntity.setSys(toEntity(mainVo.getSys()));
            mainEntity.setVisibility(mainVo.getVisibility());
            mainEntity.setWind(toEntity(mainVo.getWind()));
            mainEntity.setWeatherList(toEntityList(mainVo.getWeatherList()));
        }

        return mainEntity;
    }

    /**
     *  Converting list of entities type of {@link WeatherEntity} to list of {@link WeatherVo}
     * @param weatherList
     * @return
     */
    private RealmList<WeatherVo> toVoList(List<WeatherEntity> weatherList) {
        RealmList<WeatherVo> weatherVos = new RealmList<>();
        if (weatherList != null) {
            for (WeatherEntity weatherEntity : weatherList) {
                weatherVos.add(toVo(weatherEntity));
            }
        }

        return weatherVos;
    }

    /**
     *  Converting from RealmList of {@link WeatherVo} to list of {@link WeatherEntity}
     * @param voList
     * @return
     */
    private List<WeatherEntity> toEntityList(RealmList<WeatherVo> voList) {
        List<WeatherEntity> weatherEntities = new ArrayList<>();
        if (voList != null) {
            for (WeatherVo item : voList) {
                weatherEntities.add(toEntity(item));
            }
        }

        return weatherEntities;
    }

    /**
     *  Converting entity of type {@link CloudsEntity} to {@link CloudsVo}
     * @param clouds
     * @return
     */
    private CloudsVo toVo(CloudsEntity clouds) {
        CloudsVo cloudsVo = new CloudsVo();
        if (clouds != null) {
            cloudsVo.setAll(clouds.getAll());
        }
        return cloudsVo;
    }

    /**
     *  Converting type of {@link CloudsVo} to {@link CloudsEntity}
     * @param vo
     * @return
     */
    private CloudsEntity toEntity(CloudsVo vo) {
        CloudsEntity cloudsEntity = new CloudsEntity();
        if (vo != null) {
            cloudsEntity.setAll(vo.getAll());
        }
        return cloudsEntity;
    }

    /**
     *  Converting from type of {@link WeatherEntity} to {@link WeatherVo}
     * @param weatherEntity
     * @return
     */
    public WeatherVo toVo(WeatherEntity weatherEntity) {
        WeatherVo weatherVo = new WeatherVo();
        if (weatherEntity != null) {
            weatherVo.setDescription(weatherEntity.getDescription());
            weatherVo.setIcon(weatherEntity.getIcon());
            weatherVo.setId(weatherEntity.getId());
            weatherVo.setMain(weatherEntity.getMain());
        }
        return weatherVo;
    }

    /**
     *  Converting type of {@link WeatherVo} to type {@link WeatherEntity}
     * @param vo
     * @return
     */
    public WeatherEntity toEntity(WeatherVo vo) {
        WeatherEntity weatherEntity = new WeatherEntity();
        if (vo != null) {
            weatherEntity.setDescription(vo.getDescription());
            weatherEntity.setIcon(vo.getIcon());
            weatherEntity.setId(vo.getId());
            weatherEntity.setMain(vo.getMain());
        }
        return weatherEntity;
    }

    /**
     *  Converting type of {@link CoordEntity} to {@link CoordVo}
     * @param coordEntity
     * @return
     */
    public CoordVo toVo(CoordEntity coordEntity) {
        CoordVo coordVo = new CoordVo();
        if (coordEntity != null) {
            coordVo.setLat(coordEntity.getLat());
            coordVo.setLon(coordEntity.getLon());
        }
        return coordVo;
    }

    /**
     *  Converting type of {@link CoordVo} to {@link CoordEntity}
     * @param vo
     * @return
     */
    public CoordEntity toEntity(CoordVo vo) {
        CoordEntity coordEntity = new CoordEntity();
        if (vo != null) {
            coordEntity.setLat(vo.getLat());
            coordEntity.setLon(vo.getLon());
        }
        return coordEntity;
    }

    /**
     *  Converting type of {@link MainEntity} to type {@link MainVo}
     * @param mainEntity
     * @return
     */
    public MainVo toVo(MainEntity mainEntity) {
        MainVo mainVo = new MainVo();
        if (mainEntity != null) {
            mainVo.setHumidity(mainEntity.getHumidity());
            mainVo.setPressure(mainEntity.getPressure());
            mainVo.setTemp(mainEntity.getTemp());
            mainVo.setTempMax(mainEntity.getTempMax());
            mainVo.setTempMin(mainEntity.getTempMin());
        }
        return mainVo;
    }

    /**
     *  Converting type of {@link MainVo} to type {@link MainEntity}
     * @param vo
     * @return
     */
    public MainEntity toEntity(MainVo vo) {
        MainEntity mainEntity = new MainEntity();
        if (vo != null) {
            mainEntity.setHumidity(vo.getHumidity());
            mainEntity.setPressure(vo.getPressure());
            mainEntity.setTemp(vo.getTemp());
            mainEntity.setTempMax(vo.getTempMax());
            mainEntity.setTempMin(vo.getTempMin());
        }
        return mainEntity;
    }

    /**
     *  Converting type of {@link SysEntity} to type {@link SysVo}
     * @param sysEntity
     * @return
     */
    public SysVo toVo(SysEntity sysEntity) {
        SysVo sysVo = new SysVo();
        if (sysEntity != null) {
            sysVo.setId(sysEntity.getId());
            sysVo.setCountry(sysEntity.getCountry());
            sysVo.setMessage(sysEntity.getMessage());
            sysVo.setSunrise(sysEntity.getSunrise());
            sysVo.setSunset(sysEntity.getSunset());
            sysVo.setType(sysEntity.getType());
        }
        return sysVo;
    }

    /**
     *  Converting type of {@link SysVo} to type {@link SysEntity}
     * @param vo
     * @return
     */
    public SysEntity toEntity(SysVo vo) {
        SysEntity sysEntity = new SysEntity();
        if (vo != null) {
            sysEntity.setId(vo.getId());
            sysEntity.setCountry(vo.getCountry());
            sysEntity.setMessage(vo.getMessage());
            sysEntity.setSunrise(vo.getSunrise());
            sysEntity.setSunset(vo.getSunset());
            sysEntity.setType(vo.getType());
        }
        return sysEntity;
    }

    /**
     *  Converting type of {@link WindEntity} to type {@link WindVo}
     * @param windEntity
     * @return
     */
    public WindVo toVo(WindEntity windEntity) {
        WindVo windVo = new WindVo();
        if (windEntity != null) {
            windVo.setDeg(windEntity.getDeg());
            windVo.setSpeed(windEntity.getSpeed());
        }

        return windVo;
    }

    /**
     *  Converting type of {@link WindVo} to type {@link WindEntity}
     * @param vo
     * @return
     */
    public WindEntity toEntity(WindVo vo) {
        WindEntity windEntity = new WindEntity();
        if (vo != null) {
            windEntity.setDeg(vo.getDeg());
            windEntity.setSpeed(vo.getSpeed());
        }

        return windEntity;
    }
}
