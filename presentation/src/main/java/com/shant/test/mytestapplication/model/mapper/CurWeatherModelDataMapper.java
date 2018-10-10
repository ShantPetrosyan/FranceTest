package com.shant.test.mytestapplication.model.mapper;

import com.shant.test.domain.bean.boundary.response.currentweather.CloudsResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CoordResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CurrentWeatherMainResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.MainResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.SysResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.WeatherResponseBo;
import com.shant.test.domain.bean.boundary.response.currentweather.WindResponseBo;
import com.shant.test.mytestapplication.di.qualifiers.PerActivity;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentCloudsModel;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentCoordModel;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentMainModel;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentSysModel;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentWeatherMainModel;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentWeatherModel;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentWindModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Mapper class used to transform Business Objects
 * (in the domain layer) to Model in the
 * presentation layer.
 */
@PerActivity
public class CurWeatherModelDataMapper {

    @Inject
    public CurWeatherModelDataMapper() {
    }

    public CurrentWeatherMainModel toModel(CurrentWeatherMainResponseBo currentWeatherMainResponseBo) {
        CurrentWeatherMainModel currentWeatherMainModel = new CurrentWeatherMainModel();

        if (currentWeatherMainResponseBo != null) {
            currentWeatherMainModel.setBase(currentWeatherMainResponseBo.getBase());
            currentWeatherMainModel.setClouds(toModel(currentWeatherMainResponseBo.getClouds()));
            currentWeatherMainModel.setCod(currentWeatherMainResponseBo.getCod());
            currentWeatherMainModel.setCoord(toModel(currentWeatherMainResponseBo.getCoord()));
            currentWeatherMainModel.setDt(currentWeatherMainResponseBo.getDt());
            currentWeatherMainModel.setId(currentWeatherMainResponseBo.getId());
            currentWeatherMainModel.setMain(toModel(currentWeatherMainResponseBo.getMain()));
            currentWeatherMainModel.setName(currentWeatherMainResponseBo.getName());
            currentWeatherMainModel.setSys(toModel(currentWeatherMainResponseBo.getSys()));
            currentWeatherMainModel.setVisibility(currentWeatherMainResponseBo.getVisibility());
            currentWeatherMainModel.setWind(toModel(currentWeatherMainResponseBo.getWind()));
            currentWeatherMainModel.setWeatherList(toModelList(currentWeatherMainResponseBo.getWeatherList()));
        }

        return currentWeatherMainModel;
    }

    private List<CurrentWeatherModel> toModelList(List<WeatherResponseBo> weatherList) {
        List<CurrentWeatherModel> weatherModels = new ArrayList<>();
        if (weatherList != null) {
            for (WeatherResponseBo item : weatherList) {
                weatherModels.add(toModel(item));
            }
        }

        return weatherModels;
    }

    public CurrentCloudsModel toModel(CloudsResponseBo clouds) {
        CurrentCloudsModel currentCloudsModel = new CurrentCloudsModel();
        if (clouds != null) {
            currentCloudsModel.setAll(clouds.getAll());
        }
        return currentCloudsModel;
    }

    public CurrentWeatherModel toModel(WeatherResponseBo responseBo) {
        CurrentWeatherModel weatherModel = new CurrentWeatherModel();
        if (responseBo != null) {
            weatherModel.setDescription(responseBo.getDescription());
            weatherModel.setIcon(responseBo.getIcon());
            weatherModel.setId(responseBo.getId());
            weatherModel.setMain(responseBo.getMain());
        }
        return weatherModel;
    }

    public CurrentCoordModel toModel(CoordResponseBo responseBo) {
        CurrentCoordModel coordModel = new CurrentCoordModel();
        if (responseBo != null) {
            coordModel.setLat(responseBo.getLat());
            coordModel.setLon(responseBo.getLon());
        }
        return coordModel;
    }

    public CurrentMainModel toModel(MainResponseBo responseBo) {
        CurrentMainModel mainModel = new CurrentMainModel();
        if (responseBo != null) {
            mainModel.setHumidity(responseBo.getHumidity());
            mainModel.setPressure(responseBo.getPressure());
            mainModel.setTemp(responseBo.getTemp());
            mainModel.setTempMax(responseBo.getTempMax());
            mainModel.setTempMin(responseBo.getTempMin());
        }
        return mainModel;
    }

    public CurrentSysModel toModel(SysResponseBo responseBo) {
        CurrentSysModel sysModel = new CurrentSysModel();
        if (responseBo != null) {
            sysModel.setId(responseBo.getId());
            sysModel.setCountry(responseBo.getCountry());
            sysModel.setMessage(responseBo.getMessage());
            sysModel.setSunrise(responseBo.getSunrise());
            sysModel.setSunset(responseBo.getSunset());
            sysModel.setType(responseBo.getType());
        }
        return sysModel;
    }

    public CurrentWindModel toModel(WindResponseBo responseBo) {
        CurrentWindModel windModel = new CurrentWindModel();
        if (responseBo != null) {
            windModel.setDeg(responseBo.getDeg());
            windModel.setSpeed(responseBo.getSpeed());
        }

        return windModel;
    }
}
