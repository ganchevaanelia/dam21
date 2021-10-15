package com.example.sem2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("tagCautare","Found.");
        Log.e("tagCautare","Found. Error");
        Log.i("tagCautare","Found. Info");
        Log.d("tagCautare","Found. Debug");

        Toast.makeText(this,"Salut",Toast.LENGTH_LONG).show();

        //sem3
        Log.v("Lifecycle","onCreate");

        btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Apasare buton",Toast.LENGTH_SHORT).show();
                Intent newWindow = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(newWindow);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Lifecycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Lifecycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Lifecycle","onDestroy");
    }
}