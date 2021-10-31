package com.example.carrot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnRegister;
    private final int MAIN_ACTIVITY_REQUEST = 100;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    btnRegister = findViewById(R.id.btn_register);
    etUsername = findViewById(R.id.etUsernameLogin);
    etPassword=findViewById(R.id.etPasswordLogin);

    btnRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivityForResult(register,MAIN_ACTIVITY_REQUEST);
        }
    });

    btnLogin = findViewById(R.id.btn_login);
    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent weather = new Intent(LoginActivity.this, WeatherActivity.class);
            startActivity(weather);
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MAIN_ACTIVITY_REQUEST){
            if (resultCode==RESULT_OK){
                if (data!=null){
                    Bundle newBundle = data.getBundleExtra("raspunsBundle");
                    User user = (User) newBundle.getSerializable("putUser");
                    etUsername.setText(user.getUsername());
                    etPassword.setText(user.getPassword());
                }
            }
        }
    }
}