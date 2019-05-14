package com.example.hp.ournetwork;

import android.content.Intent;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.Random;


public class FrontView extends AppCompatActivity {
    private Button left, right, back;
    private String userID;

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_view);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        back = (Button) findViewById(R.id.back);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actionIntent = new Intent(FrontView.this, BackView.class);
                startActivity(actionIntent);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                AccelData test=GenerateData();

                rootRef.child("users").child(userID).child("left Shoulder").setValue(test);
                toastMessage("Press start to display sensor Data");
                //rootRef.child("testData").child("Left Shoulder").setValue(test);


                Intent actionIntent2 = new Intent(FrontView.this, RealTime.class);
                startActivity(actionIntent2);
            }
        });

        //onClick();
        //FirebaseUser user = mAuth.getCurrentUser();

        //test.add(adat);
        //test.add("Steve");
        //test.add("Anna");


    }


    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private AccelData GenerateData(){
        Random rn = new Random();
        long date = new Date().getTime();
        AccelData adat = new AccelData(
                date,
                0.15 + rn.nextInt(9 - 0 + 1) * 0.172,
                0.15 + rn.nextInt(9 - 0 + 1) * 0.172
                , 0.15 + rn.nextInt(9 - 0 + 1) * 0.172);

        return adat;


    }








}
