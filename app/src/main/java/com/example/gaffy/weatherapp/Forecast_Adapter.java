package com.example.gaffy.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaffy.weatherapp.data.network.model.Result;

import java.util.List;

public class Forecast_Adapter extends RecyclerView.Adapter<Forecast_Adapter.MyViewHolder> {

    private Context applicationContext;
    private int row;
    private List<Result> results;

    public Forecast_Adapter(Context applicationContext, List<Result> results, int row) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.results = results;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Forecast_Adapter.MyViewHolder((LayoutInflater.from(parent.getContext()).inflate(row, parent, false)));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tDate.setText(results.get(position).getDtTxt().toString());
        holder.tMinTemp.setText(results.get(position).getMain().getTempMin().toString() + "°C");
        holder.tMinTemp.setText(results.get(position).getMain().getTempMax().toString() + "°C");
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tDate, tMinTemp, tMaxTemp;

        public MyViewHolder(View itemView) {
            super(itemView);

            tDate = itemView.findViewById(R.id.tDay);
            tMinTemp = itemView.findViewById(R.id.tMinDeg);
            tMaxTemp = itemView.findViewById(R.id.tMaxDeg);
        }
    }
}
