package com.example.gaffy.weatherapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gaffy.weatherapp.data.network.AppDataManager;
import com.example.gaffy.weatherapp.data.network.model.Forecast;
import com.example.gaffy.weatherapp.mvp.ForecastImpl;
import com.example.gaffy.weatherapp.mvp.IForecastMvpView;
import com.example.gaffy.weatherapp.ui.base.BaseFragment;
import com.example.gaffy.weatherapp.ui.utils.rx.AppSchedulerProvider;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends BaseFragment
implements IForecastMvpView{


    RecyclerView recyclerView;


    ForecastImpl<ForecastFragment> forecastFragmentPresenter;

    public ForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forecast, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        forecastFragmentPresenter = new ForecastImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());

        forecastFragmentPresenter.onAttach(this);

        recyclerView = view.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //callService();
        forecastFragmentPresenter.loadForecast();


    }

    public void callService() {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean isConnected) throws Exception {
                        if (isConnected) {
                            forecastFragmentPresenter.loadForecast();
                        } else {
                            Toast.makeText(getActivity(), "No internet connection!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(Forecast forecast) {
      //  hideLoading();
        recyclerView.setAdapter(new Forecast_Adapter(getActivity().getApplicationContext(), forecast.getResult(), R.layout.forecast_row));


        //Toast.makeText(getActivity(), "" + forecast.getResult(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFetchDataError(String error) {

    }
}
