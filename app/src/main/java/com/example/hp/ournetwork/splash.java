package com.example.hp.ournetwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class splash extends AppCompatActivity {
    private ImageButton su,si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        su =findViewById(R.id.SignUp);
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actionIntent = new Intent(splash.this , register.class);
                startActivity(actionIntent);
            }
        });
        si =findViewById(R.id.Signin);
        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actionIntent = new Intent(splash.this , login.class);
                startActivity(actionIntent);
            }
        });

    }
}
