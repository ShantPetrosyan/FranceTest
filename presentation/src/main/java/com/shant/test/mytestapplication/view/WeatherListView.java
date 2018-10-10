package com.shant.test.mytestapplication.view;

import com.shant.test.mytestapplication.model.currentweathermodels.CurrentWeatherMainModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastOneDayInfoModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastWeatherMainModel;

import java.util.List;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a forCastList of {@link ForcastWeatherMainModel}.
 */
public interface WeatherListView extends LoadDataView {

    /**
     * Render a user forCastList in the UI.
     *
     * @param forcastOneDayInfoModels       is type of {@link ForcastOneDayInfoModel} that will be shown.
     * @param currentWeatherMainModel is type of {@link CurrentWeatherMainModel} that will be shown
     */
    void renderWeatherInfo(List<ForcastOneDayInfoModel> forcastOneDayInfoModels, CurrentWeatherMainModel currentWeatherMainModel);

    /**
     *  Showing error message when in time of requesting data happening unknow error
     */
    void showErrorMessage();
}