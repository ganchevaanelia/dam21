package com.example.carrot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    private ListView lista;
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        lista = findViewById(R.id.listviewWeather);
        adapter = new WeatherAdapter(getWeather());
        lista.setAdapter(adapter);
    }

    private List<Weather> getWeather() {
        List<Weather> list = new ArrayList<>();
        list.add(new Weather("Today","6","14"));
        list.add(new Weather("MON ","8","15"));
        list.add(new Weather("TUE ","6","14"));
        list.add(new Weather("WED ","6","18"));
        list.add(new Weather("THU ","8","20"));
        list.add(new Weather("FRI ","9","21"));
        return list;
    }
}