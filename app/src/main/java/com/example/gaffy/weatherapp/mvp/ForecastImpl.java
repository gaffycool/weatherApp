package com.example.gaffy.weatherapp.mvp;

import com.example.gaffy.weatherapp.data.network.DataManager;
import com.example.gaffy.weatherapp.data.network.model.Forecast;
import com.example.gaffy.weatherapp.ui.base.BasePresenter;
import com.example.gaffy.weatherapp.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ForecastImpl <V extends IForecastMvpView>
extends BasePresenter<V>
implements IForecastPresenter<V>{

    public ForecastImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadForecast() {


       // getMvpView().showLoading();
        getCompositeDisposable()
                .add(getDataManager().getForecast()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<Forecast>() {
                            @Override
                            public void accept(Forecast forecast) throws Exception {
                                getMvpView().onFetchDataSuccess(forecast);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                getMvpView().onFetchDataError(throwable.getMessage());

                            }
                        }));
    }
}
