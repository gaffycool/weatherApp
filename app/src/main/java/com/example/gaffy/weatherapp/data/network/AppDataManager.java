package com.example.gaffy.weatherapp.data.network;



import com.example.gaffy.weatherapp.data.network.model.Forecast;

import java.util.List;

import io.reactivex.Observable;


public class AppDataManager implements DataManager{

    private IApiHelper iApiHelper;


    public AppDataManager() {
        iApiHelper = new AppApiHelper();
    }


    public Observable<Forecast> getForecast()
    {
        return iApiHelper.getForecast();
    }

   // public Observable<Result<EventsDetails>> getEventsDetails(int id) { return iApiHelper.getEventsDetails(id);}


}
