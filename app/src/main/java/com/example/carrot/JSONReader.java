package com.example.carrot;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {

    public void read(String urlpath, IResponse response){
        try {
            URL url = new URL(urlpath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream input = connection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(inputReader);

            StringBuilder result = new StringBuilder();
            String line = "";

            while((line=reader.readLine())!=null) {
                result.append(line);
            }
            Log.v("rezWeather",result.toString());

            reader.close();
            inputReader.close();
            input.close();

            List<Weather> list = parsare(result.toString());

            response.onSucces(list);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<Weather> parsare(String jsonString)
    {
        List<Weather> lista = new ArrayList<>();
        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            JSONArray array = jsonObj.getJSONArray("weather");

            for(int i=0; i<array.length(); i++)
            {
                JSONObject currentObj = array.getJSONObject(i);
                String day = currentObj.getString("day");
                int min = currentObj.getInt("min");
                int max = currentObj.getInt("max");

                Weather w = new Weather(day, min, max);
                lista.add(w);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
