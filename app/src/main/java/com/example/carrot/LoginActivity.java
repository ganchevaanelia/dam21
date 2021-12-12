package com.example.carrot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private Button btnRegister;
    private final int MAIN_ACTIVITY_REQUEST = 100;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private UserDao userDao;

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

                            userDao = Database.getInstance(LoginActivity.this).getDatabase().userDao();
                            userDao.insert(user);
                            writeToDatabase(user);
                            readFromDatabase(user);


                }
            }
        }
    }

    private void writeToDatabase(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(user.getUsername());

        myRef.child("Email").setValue(user.getEmail());
        myRef.child("Username").setValue(user.getUsername());
        myRef.child("Password").setValue(user.getPassword());
    }

    private void readFromDatabase(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(user.getUsername());
// Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User value = dataSnapshot.getValue(User.class);

                Log.d("readFirebase", "User is: " + value.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("cancelled", "Failed to read value.", error.toException());
            }
        });
    }
}