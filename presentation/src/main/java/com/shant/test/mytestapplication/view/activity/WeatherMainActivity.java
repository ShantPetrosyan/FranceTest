package com.shant.test.mytestapplication.view.activity;

import com.shant.test.mytestapplication.R;
import com.shant.test.mytestapplication.di.HasComponent;
import com.shant.test.mytestapplication.di.components.DaggerWeatherComponent;
import com.shant.test.mytestapplication.di.components.WeatherComponent;
import com.shant.test.mytestapplication.model.currentweathermodels.CurrentWeatherMainModel;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastWeatherMainModel;
import com.shant.test.mytestapplication.utils.DateUtils;
import com.shant.test.mytestapplication.utils.NetworkHelper;
import com.shant.test.mytestapplication.view.fragment.WeatherListFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.shant.test.mytestapplication.utils.Constants.POS_CONTENT;
import static com.shant.test.mytestapplication.utils.Constants.POS_ERROR;
import static com.shant.test.mytestapplication.utils.Constants.POS_LOADING;

/**
 * Activity that shows a forCastList of RSS data.
 */
public class WeatherMainActivity extends BaseActivity implements WeatherListFragment.WeatherListListener, HasComponent<WeatherComponent> {

    private static String fragmentTag = "WeatherListFragment";
    @BindView(R.id.txtCityName)
    TextView txtCityName;
    @BindView(R.id.txtWeatherDescription)
    TextView txtWeatherDescription;
    @BindView(R.id.txtTemperature)
    TextView txtTemperature;
    @BindView(R.id.txtSunrise)
    TextView txtSunrise;
    @BindView(R.id.txtSunset)
    TextView txtSunset;
    @BindView(R.id.txtClouds)
    TextView txtClouds;
    @BindView(R.id.txtRain)
    TextView txtRain;
    @BindView(R.id.txtHumidity)
    TextView txtHumidity;
    @BindView(R.id.txtPression)
    TextView txtPression;

    @BindView(R.id.viewFlipper)
    ViewFlipper viewFlipper;
    private WeatherComponent weatherComponent;

    WeatherListFragment mWeatherListFragment;

    @Inject
    NetworkHelper networkHelper;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, WeatherMainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        ButterKnife.bind(this);

        this.initializeInjector();
        getComponent().inject(this);

        if (!networkHelper.isNetworkAvailable()) {
            NetworkHelper.showNoInternetSnakeBar(getWindow().getDecorView().getRootView(), this);
        }

        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, mWeatherListFragment = new WeatherListFragment(), fragmentTag);
        } else {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();

            if (fragments != null && fragments.size() > 0) {
                final WeatherListFragment fragment = (WeatherListFragment) fragments.get(0);
                new Handler().postDelayed(() -> fragment.hideLoading(), 500);
            }
        }
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        if (mWeatherListFragment != null) {
            mWeatherListFragment.requestDataFromNetwork();
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onCurrentDayDataReceived(CurrentWeatherMainModel currentWeatherMainModel) {
        if (currentWeatherMainModel != null) {
            txtCityName.setText(currentWeatherMainModel.getName());
            if (currentWeatherMainModel.getWeatherList() != null && currentWeatherMainModel.getWeatherList().size() > 0)
                txtWeatherDescription.setText(currentWeatherMainModel.getWeatherList().get(0).getMain());
            txtTemperature.setText(getResources().getString(R.string.celsius, Math.round(currentWeatherMainModel.getMain().getTemp()) + ""));
            txtSunrise.setText(DateUtils.getDayOfWeekName(currentWeatherMainModel.getSys().getSunrise()));
            txtSunset.setText(DateUtils.getDayOfWeekName(currentWeatherMainModel.getSys().getSunset()));
            txtClouds.setText(getString(R.string.percent, currentWeatherMainModel.getClouds().getAll() + ""));
            txtRain.setText(getString(R.string.rain_in_mm, currentWeatherMainModel.getRain() + ""));
            txtHumidity.setText(getString(R.string.percent, currentWeatherMainModel.getMain().getHumidity() + ""));
            txtPression.setText(getString(R.string.pression_unit, currentWeatherMainModel.getMain().getPressure() + ""));
        }

    }

    @Override
    public void showLoading() {
        viewFlipper.setDisplayedChild(POS_LOADING);
    }

    @Override
    public void hideLoading() {
        viewFlipper.setDisplayedChild(POS_CONTENT);
    }

    @Override
    public void showRetry() {
        viewFlipper.setDisplayedChild(POS_ERROR);
    }

    @Override
    public void hideRetry() {
        viewFlipper.setDisplayedChild(POS_CONTENT);
    }

    private void initializeInjector() {
        this.weatherComponent = DaggerWeatherComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public WeatherComponent getComponent() {
        return weatherComponent;
    }
}
