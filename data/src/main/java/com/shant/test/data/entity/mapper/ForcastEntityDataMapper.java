package com.shant.test.data.entity.mapper;

import com.shant.test.data.entity.forcastweather.ForCastByHoursEntity;
import com.shant.test.data.entity.forcastweather.ForcastCityEntity;
import com.shant.test.data.entity.forcastweather.ForcastCloudsEntity;
import com.shant.test.data.entity.forcastweather.ForcastCoordEntity;
import com.shant.test.data.entity.forcastweather.ForcastMainEntity;
import com.shant.test.data.entity.forcastweather.ForcastRainEntity;
import com.shant.test.data.entity.forcastweather.ForcastSysEntity;
import com.shant.test.data.entity.forcastweather.ForcastWeatherEntity;
import com.shant.test.data.entity.forcastweather.ForcastWeatherMainEntity;
import com.shant.test.data.entity.forcastweather.ForcastWindEntity;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForCastByHoursResponseBos;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastCityResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastCloudsResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastCoordResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastMainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastRainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastSysResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWeatherMainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWeatherResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWindResponseBo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform current weather enities (in the data layer) to Business Objects (Bo) in the
 * domain layer.
 */
@Singleton
public class ForcastEntityDataMapper {

    @Inject
    public ForcastEntityDataMapper() {
    }

    public ForcastWeatherMainResponseBo toBo(ForcastWeatherMainEntity forcastWeatherMainEntity) {
        ForcastWeatherMainResponseBo forcastWeatherMainResponseBo = new ForcastWeatherMainResponseBo();

        if (forcastWeatherMainEntity != null) {
            forcastWeatherMainResponseBo.setCnt(forcastWeatherMainEntity.getCnt());
            forcastWeatherMainResponseBo.setCod(forcastWeatherMainEntity.getCod());
            forcastWeatherMainResponseBo.setMessage(forcastWeatherMainEntity.getMessage());
            forcastWeatherMainResponseBo.setForcastCityResponseBo(toBo(forcastWeatherMainEntity.getForcastCityEntity()));
            forcastWeatherMainResponseBo
                    .setForCastByHoursResponseBosList(toBoList(forcastWeatherMainEntity.getForCastByHoursEntity()));
        }

        return forcastWeatherMainResponseBo;
    }

    public List<ForCastByHoursResponseBos> toBoList(List<ForCastByHoursEntity> forCastByHoursEntity) {
        List<ForCastByHoursResponseBos> forCastByHoursResponseBos = new ArrayList<>();
        if (forCastByHoursEntity != null) {
            for (ForCastByHoursEntity item : forCastByHoursEntity) {
                forCastByHoursResponseBos.add(toBo(item));
            }
        }

        return forCastByHoursResponseBos;
    }

    public ForCastByHoursResponseBos toBo(ForCastByHoursEntity forCastByHoursEntity) {
        ForCastByHoursResponseBos forCastByHoursResponseBos = new ForCastByHoursResponseBos();
        if (forCastByHoursEntity != null) {
            forCastByHoursResponseBos.setDt(forCastByHoursEntity.getDt());
            forCastByHoursResponseBos.setDtTxt(forCastByHoursEntity.getDtTxt());
            forCastByHoursResponseBos.setForcastCloudsResponseBo(toBo(forCastByHoursEntity.getForcastCloudsEntity()));
            forCastByHoursResponseBos.setForcastMainResponseBo(toBo(forCastByHoursEntity.getForcastMainEntity()));
            forCastByHoursResponseBos.setForcastRainResponseBo(toBo(forCastByHoursEntity.getForcastRainEntity()));
            forCastByHoursResponseBos.setForcastSysResponseBo(toBo(forCastByHoursEntity.getForcastSysEntity()));
            forCastByHoursResponseBos.setForcastWindResponseBo(toBo(forCastByHoursEntity.getForcastWindEntity()));
            forCastByHoursResponseBos.setForcastWeatherResponseBos(toBoWeatherList(forCastByHoursEntity.getForcastWeatherEntity()));
        }
        return forCastByHoursResponseBos;
    }

    public List<ForcastWeatherResponseBo> toBoWeatherList(List<ForcastWeatherEntity> forcastWeatherEntities) {
        List<ForcastWeatherResponseBo> forcastWeatherResponseBos = new ArrayList<>();

        if (forcastWeatherEntities != null) {
            for (ForcastWeatherEntity item : forcastWeatherEntities) {
                forcastWeatherResponseBos.add(toBo(item));
            }
        }
        return forcastWeatherResponseBos;
    }

    public ForcastWeatherResponseBo toBo(ForcastWeatherEntity forcastWeatherEntity) {
        ForcastWeatherResponseBo forcastWeatherResponseBo = new ForcastWeatherResponseBo();

        if (forcastWeatherEntity != null) {
            forcastWeatherResponseBo.setId(forcastWeatherEntity.getId());
            forcastWeatherResponseBo.setDescription(forcastWeatherEntity.getDescription());
            forcastWeatherResponseBo.setIcon(forcastWeatherEntity.getIcon());
            forcastWeatherResponseBo.setMain(forcastWeatherEntity.getMain());
        }

        return forcastWeatherResponseBo;
    }

    public ForcastWindResponseBo toBo(ForcastWindEntity forcastWindEntity) {
        ForcastWindResponseBo forcastWindResponseBo = new ForcastWindResponseBo();
        if (forcastWindEntity != null) {
            forcastWindResponseBo.setDeg(forcastWindEntity.getDeg());
            forcastWindResponseBo.setSpeed(forcastWindEntity.getSpeed());
        }

        return forcastWindResponseBo;
    }

    public ForcastSysResponseBo toBo(ForcastSysEntity forcastSysEntity) {
        ForcastSysResponseBo forcastSysResponseBo = new ForcastSysResponseBo();

        if (forcastSysEntity != null) {
            forcastSysResponseBo.setPod(forcastSysEntity.getPod());
        }

        return forcastSysResponseBo;
    }

    public ForcastRainResponseBo toBo(ForcastRainEntity forcastRainEntity) {
        ForcastRainResponseBo forcastRainResponseBo = new ForcastRainResponseBo();

        if (forcastRainEntity != null) {
            forcastRainResponseBo.setThreeHour(forcastRainEntity.getThreeHour());
        }

        return forcastRainResponseBo;
    }

    public ForcastMainResponseBo toBo(ForcastMainEntity forcastMainEntity) {
        ForcastMainResponseBo forcastMainResponseBo = new ForcastMainResponseBo();
        if (forcastMainEntity != null) {
            forcastMainResponseBo.setGrndLevel(forcastMainEntity.getGrndLevel());
            forcastMainResponseBo.setHumidity(forcastMainEntity.getHumidity());
            forcastMainResponseBo.setPressure(forcastMainEntity.getPressure());
            forcastMainResponseBo.setSeaLevel(forcastMainEntity.getSeaLevel());
            forcastMainResponseBo.setTemp(forcastMainEntity.getTemp());
            forcastMainResponseBo.setTempKf(forcastMainEntity.getTempKf());
            forcastMainResponseBo.setTempMax(forcastMainEntity.getTempMax());
            forcastMainResponseBo.setTempMin(forcastMainEntity.getTempMin());
        }

        return forcastMainResponseBo;
    }

    public ForcastCloudsResponseBo toBo(ForcastCloudsEntity forcastCloudsEntity) {
        ForcastCloudsResponseBo forcastCloudsResponseBo = new ForcastCloudsResponseBo();
        if (forcastCloudsEntity != null) {
            forcastCloudsResponseBo.setAll(forcastCloudsEntity.getAll());
        }

        return forcastCloudsResponseBo;
    }

    public ForcastCityResponseBo toBo(ForcastCityEntity forcastCityEntity) {
        ForcastCityResponseBo forcastCityResponseBo = new ForcastCityResponseBo();
        if (forcastCityEntity != null) {
            forcastCityResponseBo.setId(forcastCityEntity.getId());
            forcastCityResponseBo.setCoord(toBo(forcastCityEntity.getCoord()));
            forcastCityResponseBo.setName(forcastCityEntity.getName());
            forcastCityResponseBo.setCountry(forcastCityEntity.getCountry());
            forcastCityResponseBo.setPopulation(forcastCityEntity.getPopulation());
        }

        return forcastCityResponseBo;
    }

    public ForcastCoordResponseBo toBo(ForcastCoordEntity forcastCoordEntity) {
        ForcastCoordResponseBo forcastCoordResponseBo = new ForcastCoordResponseBo();

        if (forcastCoordEntity != null) {
            forcastCoordResponseBo.setLat(forcastCoordEntity.getLat());
            forcastCoordResponseBo.setLon(forcastCoordEntity.getLon());
        }

        return forcastCoordResponseBo;
    }
}
