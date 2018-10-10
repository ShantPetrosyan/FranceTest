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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CurWeatherEntitiesDataMapperTest {

    private static final String FAKE_BASE = "fake_base";
    private static final Long FAKE_ALL = 12L;
    private static final Long FAKE_COD = 15L;
    private static final Double FAKE_TALITUDE = 10.1;
    private static final Double FAKE_LONGITUDE = 10.1;
    private static final Long FAKE_DATE_AND_TIME = 16L;
    private static final Long FAKE_ID = 18L;
    private static final Double FAKE_MESSAGE = 15.5;
    private static final String FAKE_NAME = "fake_name";
    private static final Long FAKE_VISIBALITY = 20L;
    private static final Long FAKE_DEG = 21L;
    private static final Double FAKE_SPEED = 22.5;
    private static final String FAKE_COUNTRY = "fake_country";
    private static final Long FAKE_SYS_ID = 23L;
    private static final Double FAKE_SYS_MESSAGE = 24.0;
    private static final Long FAKE_SUNRISE = 25L;
    private static final Long FAKE_SUNSET = 26L;
    private static final Long FAKE_TYPE = 27L;
    private static final Long FAKE_HUMIDITY = 28L;
    private static final Long FAKE_PRESSURE = 29L;
    private static final Double FAKE_TEMP = 30.0;
    private static final Double FAKE_TEMP_MAX = 35.0;
    private static final Double FAKE_TEMP_MIN = 35.0;
    private static final String FAKE_WEATHER_DESCRIPTION1 = "fake_weather_description1";
    private static final String FAKE_ICON1 = "fake_icon1";
    private static final Long FAKE_ID_1 = 15L;
    private static final String FAKE_WEATHER_MAIN1 = "fake_weather_main1";
    private static final String FAKE_WEATHER_DESCRIPTION2 = "fake_weather_description2";
    private static final String FAKE_ICON2 = "fake_icon2";
    private static final Long FAKE_ID_2 = 16L;
    private static final String FAKE_WEATHER_MAIN2 = "fake_weather_main2";

    private CurWeatherEntitiesDataMapper curWeatherEntitiesDataMapper;

    @Before
    public void setUp() throws Exception {
        curWeatherEntitiesDataMapper = new CurWeatherEntitiesDataMapper();
    }

    @Test
    public void testToBoEntity() {
        CurrentWeatherMainEntity currentWeatherEntity = createFakeCurrentWeatherEntity();
        CurrentWeatherMainResponseBo currentWeatherMainResponseBo = curWeatherEntitiesDataMapper.toBo(currentWeatherEntity);

        assertThat(currentWeatherMainResponseBo, is(instanceOf(CurrentWeatherMainResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getBase(), is(FAKE_BASE));
        assertThat(currentWeatherMainResponseBo.getCod(), is(FAKE_COD));
        assertThat(currentWeatherMainResponseBo.getDt(), is(FAKE_DATE_AND_TIME));
        assertThat(currentWeatherMainResponseBo.getId(), is(FAKE_ID));
        assertThat(currentWeatherMainResponseBo.getName(), is(FAKE_NAME));
        assertThat(currentWeatherMainResponseBo.getVisibility(), is(FAKE_VISIBALITY));

        assertThat(currentWeatherMainResponseBo.getClouds(), is(instanceOf(CloudsResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getClouds().getAll(), is(FAKE_ALL));

        assertThat(currentWeatherMainResponseBo.getCoord(), is(instanceOf(CoordResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getCoord().getLat(), is(FAKE_TALITUDE));
        assertThat(currentWeatherMainResponseBo.getCoord().getLon(), is(FAKE_LONGITUDE));

        assertThat(currentWeatherMainResponseBo.getMain(), is(instanceOf(MainResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getMain().getHumidity(), is(FAKE_HUMIDITY));
        assertThat(currentWeatherMainResponseBo.getMain().getPressure(), is(FAKE_PRESSURE));
        assertThat(currentWeatherMainResponseBo.getMain().getTemp(), is(FAKE_TEMP));
        assertThat(currentWeatherMainResponseBo.getMain().getTempMax(), is(FAKE_TEMP_MAX));
        assertThat(currentWeatherMainResponseBo.getMain().getTempMin(), is(FAKE_TEMP_MIN));

        assertThat(currentWeatherMainResponseBo.getSys(), is(instanceOf(SysResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getSys().getCountry(), is(FAKE_COUNTRY));
        assertThat(currentWeatherMainResponseBo.getSys().getMessage(), is(FAKE_SYS_MESSAGE));
        assertThat(currentWeatherMainResponseBo.getSys().getId(), is(FAKE_SYS_ID));
        assertThat(currentWeatherMainResponseBo.getSys().getSunrise(), is(FAKE_SUNRISE));
        assertThat(currentWeatherMainResponseBo.getSys().getSunset(), is(FAKE_SUNSET));
        assertThat(currentWeatherMainResponseBo.getSys().getType(), is(FAKE_TYPE));

        assertThat(currentWeatherMainResponseBo.getWind(), is(instanceOf(WindResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getWind().getDeg(), is(FAKE_DEG));
        assertThat(currentWeatherMainResponseBo.getWind().getSpeed(), is(FAKE_SPEED));

        assertThat(currentWeatherMainResponseBo.getWeatherList(), is(instanceOf(ArrayList.class)));
        assertThat(currentWeatherMainResponseBo.getWeatherList().size(), is(2));

        assertThat(currentWeatherMainResponseBo.getWeatherList().get(0), is(instanceOf(WeatherResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(0).getDescription(), is(FAKE_WEATHER_DESCRIPTION1));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(0).getIcon(), is(FAKE_ICON1));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(0).getId(), is(FAKE_ID_1));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(0).getMain(), is(FAKE_WEATHER_MAIN1));

        assertThat(currentWeatherMainResponseBo.getWeatherList().get(1), is(instanceOf(WeatherResponseBo.class)));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(1).getDescription(), is(FAKE_WEATHER_DESCRIPTION2));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(1).getIcon(), is(FAKE_ICON2));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(1).getId(), is(FAKE_ID_2));
        assertThat(currentWeatherMainResponseBo.getWeatherList().get(1).getMain(), is(FAKE_WEATHER_MAIN2));
    }

    private CurrentWeatherMainEntity createFakeCurrentWeatherEntity() {
        CurrentWeatherMainEntity currentWeatherMainEntity = new CurrentWeatherMainEntity();
        currentWeatherMainEntity.setBase(FAKE_BASE);
        currentWeatherMainEntity.setClouds(getFakeClouds());
        currentWeatherMainEntity.setCod(FAKE_COD);
        currentWeatherMainEntity.setCoord(getFakeCoord());
        currentWeatherMainEntity.setDt(FAKE_DATE_AND_TIME);
        currentWeatherMainEntity.setId(FAKE_ID);
        currentWeatherMainEntity.setMessage(FAKE_MESSAGE);
        currentWeatherMainEntity.setName(FAKE_NAME);
        currentWeatherMainEntity.setVisibility(FAKE_VISIBALITY);
        currentWeatherMainEntity.setWind(getFakeWind());
        currentWeatherMainEntity.setSys(getFakeSys());
        currentWeatherMainEntity.setMain(getFakeMain());
        currentWeatherMainEntity.setWeatherList(getFakeListOfWeather());
        return currentWeatherMainEntity;
    }

    private List<WeatherEntity> getFakeListOfWeather() {
        List<WeatherEntity> weatherEntities = new ArrayList<>();
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setDescription(FAKE_WEATHER_DESCRIPTION1);
        weatherEntity.setIcon(FAKE_ICON1);
        weatherEntity.setId(FAKE_ID_1);
        weatherEntity.setMain(FAKE_WEATHER_MAIN1);
        weatherEntities.add(weatherEntity);

        weatherEntity = new WeatherEntity();
        weatherEntity.setDescription(FAKE_WEATHER_DESCRIPTION2);
        weatherEntity.setIcon(FAKE_ICON2);
        weatherEntity.setId(FAKE_ID_2);
        weatherEntity.setMain(FAKE_WEATHER_MAIN2);
        weatherEntities.add(weatherEntity);

        return weatherEntities;
    }

    private MainEntity getFakeMain() {
        MainEntity mainEntity = new MainEntity();
        mainEntity.setHumidity(FAKE_HUMIDITY);
        mainEntity.setPressure(FAKE_PRESSURE);
        mainEntity.setTemp(FAKE_TEMP);
        mainEntity.setTempMax(FAKE_TEMP_MAX);
        mainEntity.setTempMin(FAKE_TEMP_MIN);
        return mainEntity;
    }

    private SysEntity getFakeSys() {
        SysEntity sysEntity = new SysEntity();
        sysEntity.setCountry(FAKE_COUNTRY);
        sysEntity.setId(FAKE_SYS_ID);
        sysEntity.setMessage(FAKE_SYS_MESSAGE);
        sysEntity.setSunrise(FAKE_SUNRISE);
        sysEntity.setSunset(FAKE_SUNSET);
        sysEntity.setType(FAKE_TYPE);
        return sysEntity;
    }

    private WindEntity getFakeWind() {
        WindEntity windEntity = new WindEntity();
        windEntity.setDeg(FAKE_DEG);
        windEntity.setSpeed(FAKE_SPEED);
        return windEntity;
    }

    private CoordEntity getFakeCoord() {
        CoordEntity coordEntity = new CoordEntity();
        coordEntity.setLat(FAKE_TALITUDE);
        coordEntity.setLon(FAKE_LONGITUDE);
        return coordEntity;
    }

    private CloudsEntity getFakeClouds() {
        CloudsEntity cloudsEntity = new CloudsEntity();
        cloudsEntity.setAll(FAKE_ALL);
        return cloudsEntity;
    }
}
