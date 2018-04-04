package com.example.gaffy.weatherapp.data.network.service;


import com.example.gaffy.weatherapp.data.network.model.Forecast;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by TAE on 09-Feb-18.
 */

public interface IRequestInterface {


    @GET(ApiList.Weather_LAT_LNG)
    Observable<Forecast> getForecast();

  //  @GET(ApiList.EVENT_DETAILS_URL)
   // Observable<Result<EventsDetails>> getEventsDetails(@Path("id") int id);

}
