package com.shant.test.data.vo.mapper;

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
import com.shant.test.data.vo.forcastweathervo.ForCastByHoursVo;
import com.shant.test.data.vo.forcastweathervo.ForcastCityVo;
import com.shant.test.data.vo.forcastweathervo.ForcastCloudsVo;
import com.shant.test.data.vo.forcastweathervo.ForcastCoordVo;
import com.shant.test.data.vo.forcastweathervo.ForcastMainVo;
import com.shant.test.data.vo.forcastweathervo.ForcastRainVo;
import com.shant.test.data.vo.forcastweathervo.ForcastSysVo;
import com.shant.test.data.vo.forcastweathervo.ForcastWeatherMainVo;
import com.shant.test.data.vo.forcastweathervo.ForcastWeatherVo;
import com.shant.test.data.vo.forcastweathervo.ForcastWindVo;

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
public class ForcastVoMapper {

    @Inject
    public ForcastVoMapper() {
    }

    /**
     * Converting type of {@link ForcastWeatherMainEntity} to type of {@link ForcastWeatherMainVo}
     */
    public ForcastWeatherMainVo toVo(ForcastWeatherMainEntity forcastWeatherMainEntity) {
        ForcastWeatherMainVo forcastWeatherMainVo = new ForcastWeatherMainVo();

        if (forcastWeatherMainEntity != null) {
            forcastWeatherMainVo.setCnt(forcastWeatherMainEntity.getCnt());
            forcastWeatherMainVo.setCod(forcastWeatherMainEntity.getCod());
            forcastWeatherMainVo.setMessage(forcastWeatherMainEntity.getMessage());
            forcastWeatherMainVo.setForcastCityVo(toVo(forcastWeatherMainEntity.getForcastCityEntity()));
            forcastWeatherMainVo
                    .setForCastByHoursVos(toVoList(forcastWeatherMainEntity.getForCastByHoursEntity()));
        }

        return forcastWeatherMainVo;
    }

    /**
     * Converting type of {@link ForcastWeatherMainVo} to type {@link ForcastWeatherMainEntity}
     */
    public ForcastWeatherMainEntity toEntity(ForcastWeatherMainVo weatherMainVo) {
        ForcastWeatherMainEntity weatherMainEntity = new ForcastWeatherMainEntity();

        if (weatherMainVo != null) {
            weatherMainEntity.setCnt(weatherMainVo.getCnt());
            weatherMainEntity.setCod(weatherMainVo.getCod());
            weatherMainEntity.setMessage(weatherMainVo.getMessage());
            weatherMainEntity.setForcastCityEntity(toEntity(weatherMainVo.getForcastCityVo()));
            weatherMainEntity
                    .setForCastByHoursEntity(toEntityList(weatherMainVo.getForCastByHoursVos()));
        }

        return weatherMainEntity;
    }

    /**
     * Converting list of type {@link ForCastByHoursEntity} to list of type {@link ForCastByHoursVo}
     */
    public RealmList<ForCastByHoursVo> toVoList(List<ForCastByHoursEntity> forCastByHoursEntity) {
        RealmList<ForCastByHoursVo> castByHoursVos = new RealmList<>();
        if (forCastByHoursEntity != null) {
            int index = 1;
            for (ForCastByHoursEntity item : forCastByHoursEntity) {
                ForCastByHoursVo forCastByHoursVo = toVo(item);
                forCastByHoursVo.setId(index);
                forCastByHoursVo.getForcastCloudsVo().setId(index);
                forCastByHoursVo.getForcastMainVo().setId(index);
                forCastByHoursVo.getForcastRainVo().setId(index);
                forCastByHoursVo.getForcastSysVo().setId(index);
                forCastByHoursVo.getForcastWindVo().setId(index);
                index++;
                castByHoursVos.add(forCastByHoursVo);
            }
        }

        return castByHoursVos;
    }

    /**
     * Converting list of type {@link ForCastByHoursVo} to list of type {@link ForCastByHoursEntity}
     */
    public List<ForCastByHoursEntity> toEntityList(RealmList<ForCastByHoursVo> vos) {
        List<ForCastByHoursEntity> castByHoursVos = new ArrayList<>();
        if (vos != null) {
            for (ForCastByHoursVo item : vos) {
                castByHoursVos.add(toEntity(item));
            }
        }

        return castByHoursVos;
    }

    /**
     * Converting type of {@link ForCastByHoursEntity} to type of {@link ForCastByHoursVo}
     */
    public ForCastByHoursVo toVo(ForCastByHoursEntity forCastByHoursEntity) {
        ForCastByHoursVo castByHoursVo = new ForCastByHoursVo();

        if (forCastByHoursEntity != null) {
            castByHoursVo.setDt(forCastByHoursEntity.getDt());
            castByHoursVo.setDtTxt(forCastByHoursEntity.getDtTxt());
            castByHoursVo.setForcastCloudsVo(toVo(forCastByHoursEntity.getForcastCloudsEntity()));
            castByHoursVo.setForcastMainVo(toVo(forCastByHoursEntity.getForcastMainEntity()));
            castByHoursVo.setForcastRainVo(toVo(forCastByHoursEntity.getForcastRainEntity()));
            castByHoursVo.setForcastSysVo(toVo(forCastByHoursEntity.getForcastSysEntity()));
            castByHoursVo.setForcastWindVo(toVo(forCastByHoursEntity.getForcastWindEntity()));
            castByHoursVo
                    .setForcastWeatherVos(toVoWeatherList(forCastByHoursEntity.getForcastWeatherEntity()));
        }
        return castByHoursVo;
    }

    /**
     * Converting from type of {@link ForCastByHoursVo} to type of {@link ForCastByHoursEntity}
     */
    public ForCastByHoursEntity toEntity(ForCastByHoursVo hoursVo) {
        ForCastByHoursEntity hoursEntity = new ForCastByHoursEntity();
        if (hoursVo != null) {
            hoursEntity.setDt(hoursVo.getDt());
            hoursEntity.setDtTxt(hoursVo.getDtTxt());
            hoursEntity.setForcastCloudsEntity(toEntity(hoursVo.getForcastCloudsVo()));
            hoursEntity.setForcastMainEntity(toEntity(hoursVo.getForcastMainVo()));
            hoursEntity.setForcastRainEntity(toEntity(hoursVo.getForcastRainVo()));
            hoursEntity.setForcastSysEntity(toEntity(hoursVo.getForcastSysVo()));
            hoursEntity.setForcastWindEntity(toEntity(hoursVo.getForcastWindVo()));
            hoursEntity
                    .setForcastWeatherEntity(toEntityWeatherList(hoursVo.getForcastWeatherVos()));
        }
        return hoursEntity;
    }

    /**
     * Converting from list of type {@link ForcastWeatherEntity} to list of type {@link ForcastWeatherVo}
     */
    public RealmList<ForcastWeatherVo> toVoWeatherList(List<ForcastWeatherEntity> forcastWeatherEntities) {
        RealmList<ForcastWeatherVo> weatherVos = new RealmList<>();

        if (forcastWeatherEntities != null) {
            int index = 1;
            for (ForcastWeatherEntity item : forcastWeatherEntities) {
                ForcastWeatherVo forcastWeatherVo = toVo(item);
                forcastWeatherVo.setDataId(index++);
                weatherVos.add(forcastWeatherVo);
            }
        }
        return weatherVos;
    }

    /**
     * Converting from list of type {@link ForcastWeatherVo} to list of type {@link ForcastWeatherEntity}
     */
    public List<ForcastWeatherEntity> toEntityWeatherList(RealmList<ForcastWeatherVo> vos) {
        List<ForcastWeatherEntity> weatherVos = new ArrayList<>();

        if (vos != null) {
            for (ForcastWeatherVo item : vos) {
                weatherVos.add(toEntity(item));
            }
        }
        return weatherVos;
    }

    /**
     * Converting from type of {@link ForcastWeatherEntity} to type of {@link ForcastWeatherVo}
     */
    public ForcastWeatherVo toVo(ForcastWeatherEntity forcastWeatherEntity) {
        ForcastWeatherVo weatherVo = new ForcastWeatherVo();

        if (forcastWeatherEntity != null) {
            weatherVo.setId(forcastWeatherEntity.getId());
            weatherVo.setDescription(forcastWeatherEntity.getDescription());
            weatherVo.setIcon(forcastWeatherEntity.getIcon());
            weatherVo.setMain(forcastWeatherEntity.getMain());
        }

        return weatherVo;
    }

    /**
     * Converting type of {@link ForcastWeatherVo} to type of {@link ForcastWeatherEntity}
     */
    public ForcastWeatherEntity toEntity(ForcastWeatherVo vo) {
        ForcastWeatherEntity entity = new ForcastWeatherEntity();

        if (vo != null) {
            entity.setId(vo.getId());
            entity.setDescription(vo.getDescription());
            entity.setIcon(vo.getIcon());
            entity.setMain(vo.getMain());
        }

        return entity;
    }

    /**
     * Converting from type of {@link ForcastWindEntity} to type of {@link ForcastWindVo}
     */
    public ForcastWindVo toVo(ForcastWindEntity forcastWindEntity) {
        ForcastWindVo forcastWindVo = new ForcastWindVo();
        if (forcastWindEntity != null) {
            forcastWindVo.setDeg(forcastWindEntity.getDeg());
            forcastWindVo.setSpeed(forcastWindEntity.getSpeed());
        }

        return forcastWindVo;
    }

    /**
     * Converting from type of {@link ForcastWindVo} to type of {@link ForcastWindEntity}
     */
    public ForcastWindEntity toEntity(ForcastWindVo windVo) {
        ForcastWindEntity windEntity = new ForcastWindEntity();
        if (windVo != null) {
            windEntity.setDeg(windVo.getDeg());
            windEntity.setSpeed(windVo.getSpeed());
        }

        return windEntity;
    }

    /**
     * Converting from type of {@link ForcastSysEntity} to type of {@link ForcastSysVo}
     */
    public ForcastSysVo toVo(ForcastSysEntity forcastSysEntity) {
        ForcastSysVo forcastSysVo = new ForcastSysVo();

        if (forcastSysEntity != null) {
            forcastSysVo.setPod(forcastSysEntity.getPod());
        }

        return forcastSysVo;
    }

    /**
     * Converting from type of {@link ForcastSysVo} to type of {@link ForcastSysEntity}
     */
    public ForcastSysEntity toEntity(ForcastSysVo sysVo) {
        ForcastSysEntity sysEntity = new ForcastSysEntity();

        if (sysVo != null) {
            sysEntity.setPod(sysVo.getPod());
        }

        return sysEntity;
    }

    /**
     * Converting from type of {@link ForcastRainEntity} to type of {@link ForcastRainVo}
     */
    public ForcastRainVo toVo(ForcastRainEntity forcastRainEntity) {
        ForcastRainVo rainVo = new ForcastRainVo();

        if (forcastRainEntity != null) {
            rainVo.setThreeHour(forcastRainEntity.getThreeHour());
        }

        return rainVo;
    }

    /**
     * Converting from type of {@link ForcastRainVo} to type of {@link ForcastRainEntity}
     */
    public ForcastRainEntity toEntity(ForcastRainVo vo) {
        ForcastRainEntity rainVo = new ForcastRainEntity();

        if (vo != null) {
            rainVo.setThreeHour(vo.getThreeHour());
        }

        return rainVo;
    }

    /**
     * Converting from type {@link ForcastMainEntity} to type of {@link ForcastMainVo}
     */
    public ForcastMainVo toVo(ForcastMainEntity forcastMainEntity) {
        ForcastMainVo mainVo = new ForcastMainVo();
        if (forcastMainEntity != null) {
            mainVo.setGrndLevel(forcastMainEntity.getGrndLevel());
            mainVo.setHumidity(forcastMainEntity.getHumidity());
            mainVo.setPressure(forcastMainEntity.getPressure());
            mainVo.setSeaLevel(forcastMainEntity.getSeaLevel());
            mainVo.setTemp(forcastMainEntity.getTemp());
            mainVo.setTempKf(forcastMainEntity.getTempKf());
            mainVo.setTempMax(forcastMainEntity.getTempMax());
            mainVo.setTempMin(forcastMainEntity.getTempMin());
        }

        return mainVo;
    }

    /**
     * Converting from type of {@link ForcastMainVo} to type of {@link ForcastMainEntity}
     */
    public ForcastMainEntity toEntity(ForcastMainVo vo) {
        ForcastMainEntity mainEntity = new ForcastMainEntity();
        if (vo != null) {
            mainEntity.setGrndLevel(vo.getGrndLevel());
            mainEntity.setHumidity(vo.getHumidity());
            mainEntity.setPressure(vo.getPressure());
            mainEntity.setSeaLevel(vo.getSeaLevel());
            mainEntity.setTemp(vo.getTemp());
            mainEntity.setTempKf(vo.getTempKf());
            mainEntity.setTempMax(vo.getTempMax());
            mainEntity.setTempMin(vo.getTempMin());
        }

        return mainEntity;
    }

    /**
     * Converting from type of {@link ForcastCloudsEntity} to type of {@link ForcastCloudsVo}
     */
    public ForcastCloudsVo toVo(ForcastCloudsEntity forcastCloudsEntity) {
        ForcastCloudsVo cloudsVo = new ForcastCloudsVo();
        if (forcastCloudsEntity != null) {
            cloudsVo.setAll(forcastCloudsEntity.getAll());
        }

        return cloudsVo;
    }

    /**
     * Converting from type of {@link ForcastCloudsVo} to type of {@link ForcastCloudsEntity}
     */
    public ForcastCloudsEntity toEntity(ForcastCloudsVo vo) {
        ForcastCloudsEntity cloudsEntity = new ForcastCloudsEntity();
        if (vo != null) {
            cloudsEntity.setAll(vo.getAll());
        }

        return cloudsEntity;
    }

    /**
     * Converting from type of {@link ForcastCityEntity} to type of {@link ForcastCityVo}
     */
    public ForcastCityVo toVo(ForcastCityEntity forcastCityEntity) {
        ForcastCityVo cityVo = new ForcastCityVo();
        if (forcastCityEntity != null) {
            cityVo.setId(forcastCityEntity.getId());
            cityVo.setCoord(toVo(forcastCityEntity.getCoord()));
            cityVo.setName(forcastCityEntity.getName());
            cityVo.setCountry(forcastCityEntity.getCountry());
            cityVo.setPopulation(forcastCityEntity.getPopulation());
        }

        return cityVo;
    }

    /**
     * Converting from type of {@link ForcastCityVo} to type of {@link ForcastCityEntity}
     */
    public ForcastCityEntity toEntity(ForcastCityVo vo) {
        ForcastCityEntity cityEntity = new ForcastCityEntity();
        if (vo != null) {
            cityEntity.setId(vo.getId());
            cityEntity.setCoord(toEntity(vo.getCoord()));
            cityEntity.setName(vo.getName());
            cityEntity.setCountry(vo.getCountry());
            cityEntity.setPopulation(vo.getPopulation());
        }

        return cityEntity;
    }

    /**
     * Converting from type of {@link ForcastCoordEntity} to type of {@link ForcastCoordVo}
     */
    public ForcastCoordVo toVo(ForcastCoordEntity forcastCoordEntity) {
        ForcastCoordVo forcastCoordVo = new ForcastCoordVo();

        if (forcastCoordEntity != null) {
            forcastCoordVo.setLat(forcastCoordEntity.getLat());
            forcastCoordVo.setLon(forcastCoordEntity.getLon());
        }

        return forcastCoordVo;
    }

    /**
     * Converting from type of {@link ForcastCoordVo} to type of {@link ForcastCoordEntity}
     */
    public ForcastCoordEntity toEntity(ForcastCoordVo coordVo) {
        ForcastCoordEntity coordEntity = new ForcastCoordEntity();

        if (coordVo != null) {
            coordEntity.setLat(coordVo.getLat());
            coordEntity.setLon(coordVo.getLon());
        }

        return coordEntity;
    }
}
