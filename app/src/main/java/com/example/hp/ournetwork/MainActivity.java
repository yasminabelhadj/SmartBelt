package com.example.hp.ournetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton Eentre = (ImageButton)findViewById(R.id.Eentre_id);
        Eentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actionIntent = new Intent(MainActivity.this,splash.class);
                startActivity(actionIntent);
            }
        });
    }
}
