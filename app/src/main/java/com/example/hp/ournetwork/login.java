package com.example.hp.ournetwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;
    private ImageButton Signin;
    private FirebaseAuth mAuth;
    private String email ;
    private String pass;
    private ImageButton mback;
    private TextView Forgpass;
    String ch="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mEmailField = findViewById(R.id.hemail);
        mPasswordField = findViewById(R.id.ppassword);
        Signin=findViewById(R.id.signin);
        mback= (ImageButton) findViewById(R.id.backtofutur);
        Forgpass=(TextView) findViewById(R.id.Forgot);

        mAuth = FirebaseAuth.getInstance();



        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email= mEmailField.getText().toString();
                pass=mPasswordField.getText().toString();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(login.this, "Please enter your Mail.",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(login.this, "Please enter your password.",Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    if(ch=="1"){
                                    Intent actionIntent1 = new Intent(login.this,events.class);
                                    startActivity(actionIntent1);}
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        });


        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backaway= new Intent(login.this,register.class);
                startActivity(backaway);
            }
        });

        Forgpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgot= new Intent(login.this,forgot.class);
                startActivity(forgot);
            }
        });

    }

}
