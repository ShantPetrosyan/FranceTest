package com.shant.test.mytestapplication.model.mapper;

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
import com.shant.test.mytestapplication.di.qualifiers.PerActivity;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForCastByHoursModels;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastCityModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastCloudsModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastCoordModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastMainModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastOneDayInfoModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastRainModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastSysModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastWeatherMainModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastWeatherModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastWindModel;
import com.shant.test.mytestapplication.utils.DateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform current weather enities (in the data layer) to Business Objects (Bo) in the
 * domain layer.
 */
@PerActivity
public final class ForcastModelDataMapper {

    @Inject
    public ForcastModelDataMapper() {
    }

    public List<ForcastOneDayInfoModel> toModel(ForcastWeatherMainResponseBo weatherMainResponseBo) {
        List<ForcastOneDayInfoModel> forcastOneDayInfoModels = new ArrayList<>();

        if (weatherMainResponseBo != null && weatherMainResponseBo.getForCastByHoursResponseBosList() != null
                && weatherMainResponseBo.getForCastByHoursResponseBosList().size() > 0) {
            String dayOrNightType = "";
            LinkedHashMap<String, ForcastOneDayInfoModel> myMap = new LinkedHashMap<>();
            for (ForCastByHoursResponseBos item : weatherMainResponseBo.getForCastByHoursResponseBosList()) {
                String tempDayOrNightType = item.getForcastSysResponseBo().getPod();
                if (tempDayOrNightType != null && !tempDayOrNightType.equals(dayOrNightType)) {
                    dayOrNightType = tempDayOrNightType;
                    String weekName = DateUtils.getDayOfWeekName(item.getDtTxt());
                    ForcastOneDayInfoModel forcastOneDayInfoModel = null;
                    if (myMap.containsKey(weekName)) {
                        forcastOneDayInfoModel = myMap.get(weekName);
                        if (dayOrNightType.equals("d")) {
                            forcastOneDayInfoModel.setMaxTemperatura((int) Math.round(item.getForcastMainResponseBo().getTemp()));
                        } else {
                            forcastOneDayInfoModel.setMinTemperatura((int) Math.round(item.getForcastMainResponseBo().getTemp()));
                        }
                    } else {
                        forcastOneDayInfoModel = getInfoFromHours(dayOrNightType, item);
                    }

                    forcastOneDayInfoModel.setWeekName(weekName);
                    myMap.put(weekName, forcastOneDayInfoModel);
                }
            }

            forcastOneDayInfoModels.addAll(myMap.values());
        }

        return forcastOneDayInfoModels;
    }

    private ForcastOneDayInfoModel getInfoFromHours(String dayOrNight, ForCastByHoursResponseBos item) {
        ForcastOneDayInfoModel forcastOneDayInfoModel = new ForcastOneDayInfoModel();
        forcastOneDayInfoModel.setDateTime(item.getDt());
        forcastOneDayInfoModel.setDayWeatherCode(item.getForcastWeatherResponseBos().get(0).getId());
        if (dayOrNight.equals("d")) {
            forcastOneDayInfoModel.setMaxTemperatura((int) Math.round(item.getForcastMainResponseBo().getTemp()));
        } else {
            forcastOneDayInfoModel.setMinTemperatura((int) Math.round(item.getForcastMainResponseBo().getTemp()));
        }

        return forcastOneDayInfoModel;
    }

    /*public ForcastWeatherMainModel toModel(ForcastWeatherMainResponseBo weatherMainResponseBo) {
        ForcastWeatherMainModel weatherMainModel = new ForcastWeatherMainModel();

        if (weatherMainResponseBo != null) {
            weatherMainModel.setCnt(weatherMainResponseBo.getCnt());
            weatherMainModel.setCod(weatherMainResponseBo.getCod());
            weatherMainModel.setMessage(weatherMainResponseBo.getMessage());
            weatherMainModel.setForcastCityModel(toModel(weatherMainResponseBo.getForcastCityResponseBo()));
            weatherMainModel
                    .setForCastByHoursModels(toModelList(weatherMainResponseBo.getForCastByHoursResponseBosList()));
        }

        return weatherMainModel;
    }

    public List<ForCastByHoursModels> toModelList(List<ForCastByHoursResponseBos> hoursResponseBos) {
        List<ForCastByHoursModels> castByHoursModels = new ArrayList<>();
        if (hoursResponseBos != null) {
            for (ForCastByHoursResponseBos item : hoursResponseBos) {
                castByHoursModels.add(toModel(item));
            }
        }

        return castByHoursModels;
    }

    public ForCastByHoursModels toModel(ForCastByHoursResponseBos responseBos) {
        ForCastByHoursModels hoursModels = new ForCastByHoursModels();
        if (responseBos != null) {
            hoursModels.setDateAndTime(responseBos.getDt());
            hoursModels.setDtTxt(responseBos.getDtTxt());
            hoursModels.setForcastCloudsModel(toModel(responseBos.getForcastCloudsResponseBo()));
            hoursModels.setForcastMainModel(toModel(responseBos.getForcastMainResponseBo()));
            hoursModels.setForcastRainModel(toModel(responseBos.getForcastRainResponseBo()));
            hoursModels.setForcastSysModel(toModel(responseBos.getForcastSysResponseBo()));
            hoursModels.setForcastWindModel(toModel(responseBos.getForcastWindResponseBo()));
            hoursModels
                    .setForcastWeatherModels(toBoWeatherList(responseBos.getForcastWeatherResponseBos()));
        }
        return hoursModels;
    }

    public List<ForcastWeatherModel> toBoWeatherList(List<ForcastWeatherResponseBo> responseBos) {
        List<ForcastWeatherModel> weatherModels = new ArrayList<>();

        if (responseBos != null) {
            for (ForcastWeatherResponseBo item : responseBos) {
                weatherModels.add(toModel(item));
            }
        }
        return weatherModels;
    }

    public ForcastWeatherModel toModel(ForcastWeatherResponseBo weatherResponseBo) {
        ForcastWeatherModel weatherModel = new ForcastWeatherModel();

        if (weatherResponseBo != null) {
            weatherModel.setId(weatherResponseBo.getId());
            weatherModel.setDescription(weatherResponseBo.getDescription());
            weatherModel.setIcon(weatherResponseBo.getIcon());
            weatherModel.setMain(weatherResponseBo.getMain());
        }

        return weatherModel;
    }

    public ForcastWindModel toModel(ForcastWindResponseBo responseBo) {
        ForcastWindModel windModel = new ForcastWindModel();
        if (responseBo != null) {
            windModel.setDeg(responseBo.getDeg());
            windModel.setSpeed(responseBo.getSpeed());
        }

        return windModel;
    }

    public ForcastSysModel toModel(ForcastSysResponseBo responseBo) {
        ForcastSysModel sysModel = new ForcastSysModel();

        if (responseBo != null) {
            sysModel.setPod(responseBo.getPod());
        }

        return sysModel;
    }

    public ForcastRainModel toModel(ForcastRainResponseBo rainResponseBo) {
        ForcastRainModel rainModel = new ForcastRainModel();

        if (rainResponseBo != null) {
            rainModel.setThreeHour(rainResponseBo.getThreeHour());
        }

        return rainModel;
    }

    public ForcastMainModel toModel(ForcastMainResponseBo responseBo) {
        ForcastMainModel mainModel = new ForcastMainModel();
        if (responseBo != null) {
            mainModel.setGrndLevel(responseBo.getGrndLevel());
            mainModel.setHumidity(responseBo.getHumidity());
            mainModel.setPressure(responseBo.getPressure());
            mainModel.setSeaLevel(responseBo.getSeaLevel());
            mainModel.setTemp(responseBo.getTemp());
            mainModel.setTempKf(responseBo.getTempKf());
            mainModel.setTempMax(responseBo.getTempMax());
            mainModel.setTempMin(responseBo.getTempMin());
        }

        return mainModel;
    }

    public ForcastCloudsModel toModel(ForcastCloudsResponseBo responseBo) {
        ForcastCloudsModel cloudsModel = new ForcastCloudsModel();
        if (responseBo != null) {
            cloudsModel.setAll(responseBo.getAll());
        }

        return cloudsModel;
    }

    public ForcastCityModel toModel(ForcastCityResponseBo responseBo) {
        ForcastCityModel cityModel = new ForcastCityModel();
        if (responseBo != null) {
            cityModel.setId(responseBo.getId());
            cityModel.setCoord(toModel(responseBo.getCoord()));
            cityModel.setName(responseBo.getName());
            cityModel.setCountry(responseBo.getCountry());
            cityModel.setPopulation(responseBo.getPopulation());
        }

        return cityModel;
    }

    public ForcastCoordModel toModel(ForcastCoordResponseBo responseBo) {
        ForcastCoordModel coordModel = new ForcastCoordModel();

        if (responseBo != null) {
            coordModel.setLat(responseBo.getLat());
            coordModel.setLon(responseBo.getLon());
        }

        return coordModel;
    }

    public void toModelList(ForcastWeatherMainResponseBo weatherMainResponseBo) {

    }*/
}
