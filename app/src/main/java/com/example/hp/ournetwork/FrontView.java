package com.example.hp.ournetwork;

import android.content.Intent;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontView extends AppCompatActivity {
    private Button left, right, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_view);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        back = (Button) findViewById(R.id.back);

        //onClick();

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left:
                Intent ileft = new Intent(FrontView.this, BackView.class);
                startActivity(ileft);

                break;
            case R.id.right:

                //layout.removeAllViews();
                //openChart();

                // show data in chart
                break;

            case R.id.back:


            default:
                break;
        }

    }
}
