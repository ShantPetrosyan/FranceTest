package com.shant.test.domain.interactor;

import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWeatherMainResponseBo;
import com.shant.test.domain.executor.PostExecutionThread;
import com.shant.test.domain.executor.ThreadExecutor;
import com.shant.test.domain.repository.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetForcastWeatherUseCase extends UseCase<ForcastWeatherMainResponseBo, WeatherRequestBo> {

    private final WeatherRepository mWeatherRepository;

    @Inject
    public GetForcastWeatherUseCase(WeatherRepository weatherRepository, ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mWeatherRepository = weatherRepository;
    }

    @Override
    protected Observable<ForcastWeatherMainResponseBo> buildUseCaseObservable(WeatherRequestBo weatherRequestBo) {
        return this.mWeatherRepository.getForcastWeatherData(weatherRequestBo);
    }
}