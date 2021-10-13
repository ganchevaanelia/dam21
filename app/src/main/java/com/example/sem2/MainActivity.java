package com.example.sem2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("tagCautare","Found.");
        Log.e("tagCautare","Found. Error");
        Log.i("tagCautare","Found. Info");
        Log.d("tagCautare","Found. Debug");

        Toast.makeText(this,"Salut",Toast.LENGTH_LONG).show();
    }
}