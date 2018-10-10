package com.shant.test.mytestapplication.presenter;

import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CurrentWeatherMainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWeatherMainResponseBo;
import com.shant.test.domain.exception.DefaultErrorBundle;
import com.shant.test.domain.exception.ErrorBundle;
import com.shant.test.domain.interactor.DefaultObserver;
import com.shant.test.domain.interactor.GetCurrentDayInfoUserCase;
import com.shant.test.domain.interactor.GetForcastWeatherUseCase;
import com.shant.test.mytestapplication.di.qualifiers.PerActivity;
import com.shant.test.mytestapplication.exception.ErrorMessageFactory;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentWeatherMainModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastOneDayInfoModel;
import com.shant.test.mytestapplication.model.mapper.CurWeatherModelDataMapper;
import com.shant.test.mytestapplication.model.mapper.ForcastModelDataMapper;
import com.shant.test.mytestapplication.utils.Constants;
import com.shant.test.mytestapplication.view.WeatherListView;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

@PerActivity
public class WeatherInfotPresenter implements Presenter {

    private WeatherListView viewListView;

    private final GetForcastWeatherUseCase mGetForcastWeatherUseCase;
    private GetCurrentDayInfoUserCase mGetCurrentDayInfoUserCase;

    private CurWeatherModelDataMapper curWeatherModelDataMapper;
    private ForcastModelDataMapper forcastModelDataMapper;
    private ForcastWeatherMainResponseBo weatherMainResponseBo;

    @Inject
    public WeatherInfotPresenter(GetForcastWeatherUseCase getForcastWeatherUseCase,
            GetCurrentDayInfoUserCase mGetCurrentDayInfoUserCase,
            CurWeatherModelDataMapper curWeatherModelDataMapper,
            ForcastModelDataMapper forcastModelDataMapper) {
        this.mGetForcastWeatherUseCase = getForcastWeatherUseCase;
        this.mGetCurrentDayInfoUserCase = mGetCurrentDayInfoUserCase;
        this.curWeatherModelDataMapper = curWeatherModelDataMapper;
        this.forcastModelDataMapper = forcastModelDataMapper;
    }

    public void setView(@NonNull WeatherListView view) {
        this.viewListView = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        this.mGetForcastWeatherUseCase.dispose();
        this.viewListView = null;
    }

    private void showViewLoading() {
        this.viewListView.showLoading();
    }

    private void hideViewLoading() {
        this.viewListView.hideLoading();
    }

    private void showViewRetry() {
        this.viewListView.showRetry();
    }

    private void hideViewRetry() {
        this.viewListView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewListView.context(),
                errorBundle.getException());
        this.viewListView.showError(errorMessage);
    }

    /**
     * Requesting Forcast weather data for 5 days
     */
    public void getForcastWeatherInfo(boolean isOffline) {
        this.mGetForcastWeatherUseCase.execute(new ForcastWeatherDataObserver(isOffline), getRequestData(isOffline));
    }

    /**
     *  Requested feilds to send to server as query parameters
     *
     * @param loadFromDB this flag representing wheather we need to get data from local DB
     * @return object of {@link WeatherRequestBo} to send to Data layer
     */
    private WeatherRequestBo getRequestData(boolean loadFromDB) {
        WeatherRequestBo weatherRequestBo = new WeatherRequestBo();
        weatherRequestBo.setAppId(Constants.appId);
        weatherRequestBo.setCity(Constants.cityName);
        weatherRequestBo.setCountryCode(Constants.countryCode);
        weatherRequestBo.setTemperatureType(Constants.mesureUnit);
        weatherRequestBo.setLoadFromDB(loadFromDB);
        return weatherRequestBo;
    }

    /**
     * Getting all data needed to show current and feature 5 days weather and pushing it to fragment
     *
     * @param currentWeatherMainResponseBo current day weather
     */
    private void showCurrentWeatherInfo(CurrentWeatherMainResponseBo currentWeatherMainResponseBo) {
        CurrentWeatherMainModel currentWeatherMainModel = curWeatherModelDataMapper.toModel(currentWeatherMainResponseBo);
        List<ForcastOneDayInfoModel> forcastOneDayInfoModels = forcastModelDataMapper.toModel(weatherMainResponseBo);
        viewListView.renderWeatherInfo(forcastOneDayInfoModels, currentWeatherMainModel);
    }

    private void showForcastWeatherInfo(ForcastWeatherMainResponseBo weatherMainResponseBo, boolean loadFromDB) {
        this.weatherMainResponseBo = weatherMainResponseBo;
        mGetCurrentDayInfoUserCase.execute(new CurrentWeatherDataObserver(loadFromDB), getRequestData(loadFromDB));
    }

    private final class CurrentWeatherDataObserver extends DefaultObserver<CurrentWeatherMainResponseBo> {

        private final boolean loadFromDB;
        private CurrentWeatherMainResponseBo currentWeatherMainResponseBo;

        public CurrentWeatherDataObserver(boolean loadFromDB) {
            this.loadFromDB = loadFromDB;
        }

        @Override
        public void onComplete() {
            if (currentWeatherMainResponseBo != null) {
                WeatherInfotPresenter.this.hideViewLoading();
            } else {
                WeatherInfotPresenter.this.showViewRetry();
            }
        }

        @Override
        public void onError(Throwable e) {
            WeatherInfotPresenter.this.hideViewLoading();
            WeatherInfotPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            WeatherInfotPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(CurrentWeatherMainResponseBo currentWeatherMainResponseBo) {
            this.currentWeatherMainResponseBo = currentWeatherMainResponseBo;

            if (currentWeatherMainResponseBo == null || currentWeatherMainResponseBo.getCod() == null
                    || currentWeatherMainResponseBo.getCod() != 200) {
                if (!loadFromDB) {
                    viewListView.showErrorMessage();
                    WeatherInfotPresenter.this.showViewLoading();
                    // here must try to get from DB
                    mGetCurrentDayInfoUserCase.execute(new CurrentWeatherDataObserver(true), getRequestData(true));
                } else {
                    WeatherInfotPresenter.this.hideViewLoading();
                    viewListView.showErrorMessage();
                    WeatherInfotPresenter.this.showViewRetry();
                }
            } else {
                WeatherInfotPresenter.this.showCurrentWeatherInfo(currentWeatherMainResponseBo);
            }
        }
    }

    private final class ForcastWeatherDataObserver extends DefaultObserver<ForcastWeatherMainResponseBo> {

        private final boolean loadFromDB;
        private ForcastWeatherMainResponseBo weatherMainResponseBo;

        public ForcastWeatherDataObserver(boolean loadFromDB) {
            this.loadFromDB = loadFromDB;
        }

        @Override
        public void onComplete() {
            if (weatherMainResponseBo != null) {
                WeatherInfotPresenter.this.hideViewLoading();
            } else {
                WeatherInfotPresenter.this.showViewRetry();
            }
        }

        @Override
        public void onError(Throwable e) {
            WeatherInfotPresenter.this.hideViewLoading();
            WeatherInfotPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            WeatherInfotPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(ForcastWeatherMainResponseBo weatherMainResponseBo) {
            this.weatherMainResponseBo = weatherMainResponseBo;
            if (weatherMainResponseBo == null
                    || weatherMainResponseBo.getCod() == null
                    || !weatherMainResponseBo.getCod()
                    .equals("200")) {
                if (!loadFromDB) {
                    viewListView.showErrorMessage();
                    WeatherInfotPresenter.this.showViewLoading();
                    // here must try to get from DB
                    mGetForcastWeatherUseCase.execute(
                            new ForcastWeatherDataObserver(true), getRequestData(true));
                } else {
                    WeatherInfotPresenter.this.hideViewLoading();
                    viewListView.showErrorMessage();
                    WeatherInfotPresenter.this.showViewRetry();
                }
            } else {
                WeatherInfotPresenter.this.showForcastWeatherInfo(weatherMainResponseBo, loadFromDB);
            }
        }
    }
}