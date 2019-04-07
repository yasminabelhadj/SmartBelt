package com.example.hp.ournetwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnreset;
    private Button backbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        inputEmail = (EditText) findViewById(R.id.MAIL);
        btnreset =(Button) findViewById(R.id.Sumbit);
        backbtn =(Button) findViewById(R.id.BACK);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(forgot.this,login.class));
                finish();
            }
        });

        mAuth=FirebaseAuth.getInstance();

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword(inputEmail.getText().toString());
                startActivity(new Intent(forgot.this,splash.class));
                finish();
            }
        });

    }
    private void resetPassword(final String email) {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast snackbar=Toast.makeText(forgot.this,"We have sent password to email : "+ email,Toast.LENGTH_SHORT);
                    snackbar.show();
                }else
                {
                    Toast snackbar=Toast.makeText(forgot.this,"Failed to send password to email : "+ email,Toast.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });
    }
}
