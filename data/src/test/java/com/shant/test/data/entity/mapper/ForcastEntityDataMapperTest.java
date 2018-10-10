
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
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastCoordResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastMainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastSysResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWeatherMainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWindResponseBo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ForcastEntityDataMapperTest {

    private static final Long FAKE_COUNT = 10L;
    private static final String FAKE_COD = "fake_cod";
    private static final Double FAKE_MESSAGE = 10.0;
    private static final Long FAKE_CITY_ID = 11L;
    private static final String FAKE_CITY_NAME = "fake_city_name";
    private static final Long FAKE_CITY_POPULATION = 10000L;
    private static final String FAKE_COUNTRY = "fake_country";
    private static final Double FAKE_LAT = 12.0;
    private static final Double FAKE_LON = 3.5;
    private static final Long FAKE_DATE_AND_TIME = 15L;
    private static final String FAKE_DATE_AND_TIME_TEXT = "fake_date_and_time_in_text";
    private static final Long FAKE_ALL = 16L;
    private static final Double FAKE_GRND_LEVEL = 16.0;
    private static final Long FAKE_HUMIDITY = 17L;
    private static final Double FAKE_PRESSURE = 17.0;
    private static final Double FAKE_SEAT_LEVEL = 18.0;
    private static final Double FAKE_TEMP = 19.0;
    private static final Double FAKE_TEMP_KF = 20.0;
    private static final Double FAKE_TEMP_MAX = 21.0;
    private static final Double FAKE_TEMP_MIN = 22.0;
    private static final Double FAKE_3_HOURS = 23.0;
    private static final String FAKE_PROD = "fake_prod";
    private static final Double FAKE_DEG = 24.0;
    private static final Double FAKE_SPEED = 25.0;
    private static final String FAKE_WEATHER_DESCRIPTION_1 = "fake_weather_desc1";
    private static final String FAKE_ICON_1 = "fake_icon_1";
    private static final Long FAKE_WEATHER_ID_1 = 26L;
    private static final String FAKE_WEATHER_MAIN_1 = "fake_weather_main_1";
    private static final String FAKE_WEATHER_DESCRIPTION_2 = "fake_weather_desc2";
    private static final String FAKE_ICON_2 = "fake_icon_2";
    private static final Long FAKE_WEATHER_ID_2 = 27L;
    private static final String FAKE_WEATHER_MAIN_2 = "fake_weather_main_2";
    private ForcastEntityDataMapper forcastEntityDataMapper;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        forcastEntityDataMapper = new ForcastEntityDataMapper();
    }

    @Test
    public void testTransformUserEntityHappyCase() {
        ForcastWeatherMainEntity forcastWeatherMainEntity = createFakeForcastData();
        ForcastWeatherMainResponseBo forcastWeatherMainResponseBo = forcastEntityDataMapper.toBo(forcastWeatherMainEntity);

        assertThat(forcastWeatherMainResponseBo, is(instanceOf(ForcastWeatherMainResponseBo.class)));
        assertThat(forcastWeatherMainResponseBo.getCnt(), is(FAKE_COUNT));
        assertThat(forcastWeatherMainResponseBo.getCod(), is(FAKE_COD));
        assertThat(forcastWeatherMainResponseBo.getMessage(), is(FAKE_MESSAGE));

        //-------------
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo(), is(instanceOf(ForcastCityResponseBo.class)));
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo().getPopulation(), is(FAKE_CITY_POPULATION));
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo().getName(), is(FAKE_CITY_NAME));
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo().getId(), is(FAKE_CITY_ID));
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo().getCountry(), is(FAKE_COUNTRY));

        //-------------
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo().getCoord(),
                is(instanceOf(ForcastCoordResponseBo.class)));
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo().getCoord().getLat(), is(FAKE_LAT));
        assertThat(forcastWeatherMainResponseBo.getForcastCityResponseBo().getCoord().getLon(), is(FAKE_LON));

        //-------------
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList(), is(instanceOf(ArrayList.class)));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().size(), is(1));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0), is(instanceOf(
                ForCastByHoursResponseBos.class)));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getDt(), is(FAKE_DATE_AND_TIME));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getDtTxt(),
                is(FAKE_DATE_AND_TIME_TEXT));

        //-------------
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastWindResponseBo(),
                is(instanceOf(
                        ForcastWindResponseBo.class)));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastWindResponseBo().getDeg(),
                is(FAKE_DEG));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastWindResponseBo().getSpeed(),
                is(FAKE_SPEED));

        //-------------
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastSysResponseBo(),
                is(instanceOf(
                        ForcastSysResponseBo.class)));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastSysResponseBo().getPod(),
                is(FAKE_PROD));

        //-------------
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo(),
                is(instanceOf(
                        ForcastMainResponseBo.class)));
        assertThat(
                forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getGrndLevel(),
                is(FAKE_GRND_LEVEL));
        assertThat(
                forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getHumidity(),
                is(FAKE_HUMIDITY));
        assertThat(
                forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getPressure(),
                is(FAKE_PRESSURE));
        assertThat(
                forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getSeaLevel(),
                is(FAKE_SEAT_LEVEL));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getTemp(),
                is(FAKE_TEMP));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getTempKf(),
                is(FAKE_TEMP_KF));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getTempMax(),
                is(FAKE_TEMP_MAX));
        assertThat(forcastWeatherMainResponseBo.getForCastByHoursResponseBosList().get(0).getForcastMainResponseBo().getTempMin(),
                is(FAKE_TEMP_MIN));
    }

    private ForcastWeatherMainEntity createFakeForcastData() {
        ForcastWeatherMainEntity forcastWeatherMainEntity = new ForcastWeatherMainEntity();
        forcastWeatherMainEntity.setCnt(FAKE_COUNT);
        forcastWeatherMainEntity.setCod(FAKE_COD);
        forcastWeatherMainEntity.setMessage(FAKE_MESSAGE);
        forcastWeatherMainEntity.setForcastCityEntity(getFakeForcastData());
        forcastWeatherMainEntity.setForCastByHoursEntity(getFakeForcastByHoursDataList());
        return forcastWeatherMainEntity;
    }

    private List<ForCastByHoursEntity> getFakeForcastByHoursDataList() {
        List<ForCastByHoursEntity> forCastByHoursEntities = new ArrayList<>();

        ForCastByHoursEntity forCastByHoursEntity = new ForCastByHoursEntity();
        forCastByHoursEntity.setDt(FAKE_DATE_AND_TIME);
        forCastByHoursEntity.setDtTxt(FAKE_DATE_AND_TIME_TEXT);
        forCastByHoursEntity.setForcastCloudsEntity(getFakeForcastCloudsData());
        forCastByHoursEntity.setForcastMainEntity(getForcastMainData());
        forCastByHoursEntity.setForcastRainEntity(getForcastRainData());
        forCastByHoursEntity.setForcastSysEntity(getForcastSysRainData());
        forCastByHoursEntity.setForcastWindEntity(getForcastWindData());
        forCastByHoursEntity.setForcastWeatherEntity(getForcastWeatherListData());
        forCastByHoursEntities.add(forCastByHoursEntity);

        return forCastByHoursEntities;
    }

    private List<ForcastWeatherEntity> getForcastWeatherListData() {
        List<ForcastWeatherEntity> forcastWeatherEntities = new ArrayList<>();
        ForcastWeatherEntity forcastWeatherEntity = new ForcastWeatherEntity();
        forcastWeatherEntity.setDescription(FAKE_WEATHER_DESCRIPTION_1);
        forcastWeatherEntity.setIcon(FAKE_ICON_1);
        forcastWeatherEntity.setId(FAKE_WEATHER_ID_1);
        forcastWeatherEntity.setMain(FAKE_WEATHER_MAIN_1);
        forcastWeatherEntities.add(forcastWeatherEntity);

        forcastWeatherEntity = new ForcastWeatherEntity();
        forcastWeatherEntity.setDescription(FAKE_WEATHER_DESCRIPTION_2);
        forcastWeatherEntity.setIcon(FAKE_ICON_2);
        forcastWeatherEntity.setId(FAKE_WEATHER_ID_2);
        forcastWeatherEntity.setMain(FAKE_WEATHER_MAIN_2);
        forcastWeatherEntities.add(forcastWeatherEntity);

        return forcastWeatherEntities;
    }

    private ForcastWindEntity getForcastWindData() {
        ForcastWindEntity forcastWindEntity = new ForcastWindEntity();
        forcastWindEntity.setDeg(FAKE_DEG);
        forcastWindEntity.setSpeed(FAKE_SPEED);
        return forcastWindEntity;
    }

    private ForcastSysEntity getForcastSysRainData() {
        ForcastSysEntity forcastSysEntity = new ForcastSysEntity();
        forcastSysEntity.setPod(FAKE_PROD);
        return forcastSysEntity;
    }

    private ForcastRainEntity getForcastRainData() {
        ForcastRainEntity forcastRainEntity = new ForcastRainEntity();
        forcastRainEntity.setThreeHour(FAKE_3_HOURS);
        return forcastRainEntity;
    }

    private ForcastMainEntity getForcastMainData() {
        ForcastMainEntity forcastMainEntity = new ForcastMainEntity();
        forcastMainEntity.setGrndLevel(FAKE_GRND_LEVEL);
        forcastMainEntity.setHumidity(FAKE_HUMIDITY);
        forcastMainEntity.setPressure(FAKE_PRESSURE);
        forcastMainEntity.setSeaLevel(FAKE_SEAT_LEVEL);
        forcastMainEntity.setTemp(FAKE_TEMP);
        forcastMainEntity.setTempKf(FAKE_TEMP_KF);
        forcastMainEntity.setTempMax(FAKE_TEMP_MAX);
        forcastMainEntity.setTempMin(FAKE_TEMP_MIN);
        return forcastMainEntity;
    }

    private ForcastCloudsEntity getFakeForcastCloudsData() {
        ForcastCloudsEntity forcastCloudsEntity = new ForcastCloudsEntity();
        forcastCloudsEntity.setAll(FAKE_ALL);
        return forcastCloudsEntity;
    }

    private ForcastCityEntity getFakeForcastData() {
        ForcastCityEntity forcastCityEntity = new ForcastCityEntity();
        forcastCityEntity.setId(FAKE_CITY_ID);
        forcastCityEntity.setName(FAKE_CITY_NAME);
        forcastCityEntity.setPopulation(FAKE_CITY_POPULATION);
        forcastCityEntity.setCountry(FAKE_COUNTRY);
        forcastCityEntity.setCoord(getFakeCoordData());
        return forcastCityEntity;
    }

    private ForcastCoordEntity getFakeCoordData() {
        ForcastCoordEntity forcastCoordEntity = new ForcastCoordEntity();
        forcastCoordEntity.setLat(FAKE_LAT);
        forcastCoordEntity.setLon(FAKE_LON);
        return forcastCoordEntity;
    }


}
