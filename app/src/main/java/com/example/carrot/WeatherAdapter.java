package com.example.carrot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WeatherAdapter extends BaseAdapter {

    private List<Weather> lista;

    public WeatherAdapter(List<Weather> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View itemView = inflate.inflate(R.layout.item_weather, parent, false);
        TextView day = itemView.findViewById(R.id.item_day);
        TextView min = itemView.findViewById(R.id.item_min);
        TextView max = itemView.findViewById(R.id.item_max);
        Weather current = lista.get(position);
        day.setText(current.getDay());
        min.setText(String.valueOf(current.getMin()));
        max.setText(current.getMax());

        ImageView imageView=itemView.findViewById(R.id.imageViewWeather);

        if(day.getText().toString().equals("TUE "))
        {
            imageView.setBackgroundResource(R.drawable.rainy);
        }
        else {
            imageView.setBackgroundResource(R.drawable.cloudy);
        }

        return itemView;
    }
}
