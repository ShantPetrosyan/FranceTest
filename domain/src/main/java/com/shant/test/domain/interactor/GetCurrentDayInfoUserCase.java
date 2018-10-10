package com.shant.test.domain.interactor;

import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CurrentWeatherMainResponseBo;
import com.shant.test.domain.executor.PostExecutionThread;
import com.shant.test.domain.executor.ThreadExecutor;
import com.shant.test.domain.repository.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetCurrentDayInfoUserCase extends UseCase<CurrentWeatherMainResponseBo, WeatherRequestBo> {

    private final WeatherRepository mWeatherRepository;

    @Inject
    public GetCurrentDayInfoUserCase(WeatherRepository weatherRepository, ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mWeatherRepository = weatherRepository;
    }

    @Override
    protected Observable<CurrentWeatherMainResponseBo> buildUseCaseObservable(WeatherRequestBo weatherRequestBo) {
        return this.mWeatherRepository.getCurrentDayData(weatherRequestBo);
    }
}
