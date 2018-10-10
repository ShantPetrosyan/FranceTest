package com.shant.test.mytestapplication.view.fragment;

import com.shant.test.mytestapplication.R;
import com.shant.test.mytestapplication.di.components.WeatherComponent;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentWeatherMainModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastOneDayInfoModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastWeatherMainModel;
import com.shant.test.mytestapplication.presenter.WeatherInfotPresenter;
import com.shant.test.mytestapplication.view.WeatherListView;
import com.shant.test.mytestapplication.view.adapter.WeatherLayoutManager;
import com.shant.test.mytestapplication.view.adapter.WeatherOfDaysAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment that shows near 5 days weather.
 */
public class WeatherListFragment extends BaseFragment implements WeatherListView {

    private static final String FORCAST_DATA = "forcast_data";
    private static final String CURRENT_DAY_DATA = "current_day_data";
    private View rootView;
    private List<ForcastOneDayInfoModel> forcastOneDayInfoModels;
    private CurrentWeatherMainModel currentWeatherMainModel;

    /**
     * Interface for listening weather events.
     */
    public interface WeatherListListener {

        void onCurrentDayDataReceived(CurrentWeatherMainModel currentWeatherMainModel);

        void showLoading();

        void hideLoading();

        void showRetry();

        void hideRetry();
    }

    @Inject
    WeatherInfotPresenter mWeatherInfotPresenter;

    @Inject
    WeatherOfDaysAdapter mWeatherOfDaysAdapter;

    @BindView(R.id.rvWeatherDayList)
    RecyclerView rvWeatherDayList;

    Unbinder bind;

    private WeatherListListener mWeatherListListener;

    public WeatherListFragment() {
        // blank constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof WeatherListListener) {
            this.mWeatherListListener = (WeatherListListener) activity;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.getComponent(WeatherComponent.class).inject(this);

        this.mWeatherInfotPresenter.setView(this);
        bind = ButterKnife.bind(this, rootView);
        setupRecyclerView();

        if (savedInstanceState == null) {
            requestDataFromNetwork();
        } else if (savedInstanceState.containsKey(FORCAST_DATA) && savedInstanceState.containsKey(CURRENT_DAY_DATA)) {
            loadData(savedInstanceState);
        }
    }

    /**
     *  Getting data from Saved State if there is
     *
     * @param savedInstanceState represents {@Link Bundle} where been stored data
     */
    private void loadData(Bundle savedInstanceState) {
        forcastOneDayInfoModels = (List<ForcastOneDayInfoModel>) savedInstanceState.getSerializable(FORCAST_DATA);
        currentWeatherMainModel = (CurrentWeatherMainModel) savedInstanceState.getSerializable(CURRENT_DAY_DATA);
        renderWeatherInfo(forcastOneDayInfoModels, currentWeatherMainModel);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // saving data to restore later for excample in case of rotation
        if (forcastOneDayInfoModels != null) {
            outState.putSerializable(FORCAST_DATA, new ArrayList<>(forcastOneDayInfoModels));
        }

        if (currentWeatherMainModel != null) {
            outState.putSerializable(CURRENT_DAY_DATA, currentWeatherMainModel);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return rootView = inflater.inflate(R.layout.fragment_weather_list, container, false);
    }

    @Override
    public void renderWeatherInfo(List<ForcastOneDayInfoModel> forcastOneDayInfoModels,
            CurrentWeatherMainModel currentWeatherMainModel) {
        if (forcastOneDayInfoModels != null
                && currentWeatherMainModel != null
                && forcastOneDayInfoModels.size() > 0) {
            this.forcastOneDayInfoModels = forcastOneDayInfoModels;
            this.mWeatherOfDaysAdapter.setWeatherDayList(forcastOneDayInfoModels);
            mWeatherOfDaysAdapter.notifyDataSetChanged();

            this.currentWeatherMainModel = currentWeatherMainModel;
            this.mWeatherListListener.onCurrentDayDataReceived(currentWeatherMainModel);
        } else {
            showRetry();
        }
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getActivity(), getResources().getString(R.string.error_to_load),
                Toast.LENGTH_LONG).show();
    }

    /**
     * Loads Weather data.
     */
    @Override
    protected void requestData(boolean isOffline) {
        this.mWeatherInfotPresenter.getForcastWeatherInfo(isOffline);
    }

    @Override
    public void showLoading() {
        mWeatherListListener.showLoading();
    }

    @Override
    public void hideLoading() {
        mWeatherListListener.hideLoading();
    }

    @Override
    public void showRetry() {
        mWeatherListListener.showRetry();
    }

    @Override
    public void hideRetry() {
        mWeatherListListener.hideRetry();
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void setupRecyclerView() {
        if (getActivity() != null) {
            rvWeatherDayList.addItemDecoration(new DividerItemDecoration(getActivity(),
                    DividerItemDecoration.VERTICAL));
            this.rvWeatherDayList.setLayoutManager(new WeatherLayoutManager(context()));
            this.rvWeatherDayList.setAdapter(mWeatherOfDaysAdapter);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mWeatherInfotPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.mWeatherInfotPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rvWeatherDayList.setAdapter(null);
        bind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mWeatherInfotPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mWeatherListListener = null;
    }
}
