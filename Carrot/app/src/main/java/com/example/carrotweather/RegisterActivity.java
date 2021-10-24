package com.example.carrotweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnOk;
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnOk = findViewById(R.id.btn_ok);
        etEmail = findViewById(R.id.et_email);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid())
                {
                    User user = new User();
                    user.setUsername(etUsername.getText().toString());
                    user.setEmail(etEmail.getText().toString());
                    user.setPassword(etPassword.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("putUser",user);
                    Intent intent = new Intent();
                    intent.putExtra("raspunsBundle",bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private Boolean isValid() {
        if (etUsername.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Enter a username", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Enter a password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Enter an email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(RegisterActivity.this, "Enter a valid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}