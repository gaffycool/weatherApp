package com.example.gaffy.weatherapp.data.network;


import com.example.gaffy.weatherapp.data.network.model.Forecast;
import com.example.gaffy.weatherapp.data.network.service.IRequestInterface;
import com.example.gaffy.weatherapp.data.network.service.ServiceConnection;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public class AppApiHelper implements IApiHelper{

    private IRequestInterface iRequestInterface;


    public AppApiHelper() {
        iRequestInterface = ServiceConnection.getConnection();
    }

    public Observable<Forecast> getForecast()
    {
        return iRequestInterface.getForecast();
    }


    //public Observable<Result<EventsDetails>> getEventsDetails(int id){
      //  return iRequestInterface.getEventsDetails(id);
    //}

}
