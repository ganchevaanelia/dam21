package com.example.carrot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

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
        //adapter = new WeatherAdapter(getWeather());
        //lista.setAdapter(adapter);

        JSONReader reader = new JSONReader();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reader.read("http://jsonkeeper.com/b/BBZZ",
                        new IResponse() {
                            @Override
                            public void onSucces(List<Weather> lst) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        adapter = new WeatherAdapter(lst);
                                        lista.setAdapter(adapter);
                                    }
                                });
                            }

                            @Override
                            public void onError(String msj) {
                                runOnUiThread(() -> Toast.makeText(WeatherActivity.this, msj,Toast.LENGTH_SHORT).show());
                            }
                        });
            }
        });
        thread.start();
    }

    /*
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
     */
}