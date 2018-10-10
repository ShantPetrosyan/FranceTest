package com.shant.test.mytestapplication.view.adapter;

import com.shant.test.mytestapplication.R;
import com.shant.test.mytestapplication.model.forcastweathermodels.ForcastOneDayInfoModel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter that manages a collection of {@link ForcastOneDayInfoModel}.
 */
public class WeatherOfDaysAdapter extends RecyclerView.Adapter<WeatherOfDaysAdapter.WeatherDayViewHolder> {

    private List<ForcastOneDayInfoModel> weatherOfDayList;

    private final LayoutInflater layoutInflater;

    @Inject
    WeatherOfDaysAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.weatherOfDayList = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.weatherOfDayList != null) ? this.weatherOfDayList.size() : 0;
    }

    @NonNull
    @Override
    public WeatherDayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_weather_of_day, parent, false);
        return new WeatherDayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherDayViewHolder holder, final int position) {
        final ForcastOneDayInfoModel dayModel = this.weatherOfDayList.get(position);
        holder.initData(dayModel);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setWeatherDayList(List<ForcastOneDayInfoModel> dayModels) {
        this.validateWeatherCollection(dayModels);
        this.weatherOfDayList = dayModels;
        this.notifyDataSetChanged();
    }

    private void validateWeatherCollection(List<ForcastOneDayInfoModel> dayModels) {
        if (dayModels == null) {
            throw new IllegalArgumentException("The weather list can not be null");
        }
    }

    static class WeatherDayViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtWeekDay)
        TextView txtWeekDay;

        @BindView(R.id.txtDayTemp)
        TextView txtDayTemp;

        @BindView(R.id.txtNightTemp)
        TextView txtNightTemp;

        WeatherDayViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void initData(ForcastOneDayInfoModel dayModel) {
            if (dayModel != null) {
                txtWeekDay.setText(dayModel.getWeekName());
                txtDayTemp.setText(
                        txtDayTemp.getResources().getString(R.string.celsius, dayModel.getMaxTemperatura() + ""));
                txtNightTemp.setText(
                        txtNightTemp.getResources().getString(R.string.celsius, dayModel.getMinTemperatura() + ""));
            }
        }
    }
}