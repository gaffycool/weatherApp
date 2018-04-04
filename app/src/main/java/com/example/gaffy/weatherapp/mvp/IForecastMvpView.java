package com.example.gaffy.weatherapp.mvp;

import com.example.gaffy.weatherapp.data.network.model.Forecast;
import com.example.gaffy.weatherapp.ui.base.MvpView;

import java.util.List;

public interface IForecastMvpView extends MvpView{

    void onFetchDataProgress();
    void onFetchDataSuccess(Forecast forecast);

    void onFetchDataError(String error);

}
