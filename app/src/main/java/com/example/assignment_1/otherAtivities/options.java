package com.example.assignment_1.otherAtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.assignment_1.R;
import com.example.assignment_1.database.LoginActivity;

public class options extends AppCompatActivity {

    public View login;
    public View about;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        login = findViewById(R.id.signinBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openLogin();
            }
        });

        about = findViewById(R.id.helpBtn);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void openAbout(){
        Intent intent = new Intent(this, About_us.class);
        startActivity(intent);
    }
}