package com.example.gaffy.weatherapp.data.network;


import com.example.gaffy.weatherapp.data.network.model.Forecast;

import java.util.List;

import io.reactivex.Observable;



public interface IApiHelper {


    Observable<Forecast> getForecast();

   // Observable<List<EventsDetails>> getEventsDetails(int id);

   // Observable<List<News>> getNews();

}
