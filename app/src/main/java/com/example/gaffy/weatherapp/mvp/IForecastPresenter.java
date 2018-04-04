package com.example.gaffy.weatherapp.mvp;

import com.example.gaffy.weatherapp.ui.base.MvpPresenter;

public interface IForecastPresenter <V extends IForecastMvpView> extends MvpPresenter<V> {

    void loadForecast();
}
