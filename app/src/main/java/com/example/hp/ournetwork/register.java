package com.example.hp.ournetwork;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextClock;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class register extends AppCompatActivity {

  //private Map<String,Map<String,String>> users;
  //private List<Map<String,String>> listUsers=new ArrayList<>(users.values());

    private EditText mEmailField;
    private EditText mPasswordField;
    private ImageButton ssave;
    private String email ;
    private String pass;
    private EditText MDP , Username;
    private EditText mEmailField1;
    private ProgressDialog progressDialog;
    private String username;
    private  DatabaseReference myRef;
    private  DatabaseReference myRef1;

    FirebaseDatabase database;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users");
        ssave=findViewById(R.id.ssave);
        Username=findViewById(R.id.uusername);

        mEmailField=findViewById(R.id.eemail);
        mPasswordField = findViewById(R.id.mmdp);

        mAuth = FirebaseAuth.getInstance();
        ssave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=mEmailField.getText().toString();
                pass=mPasswordField.getText().toString();
                username=Username.getText().toString();
                mEmailField1 = findViewById(R.id.eemail1);
                MDP = findViewById(R.id.mmdp2);
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(register.this, "Please enter your Mail.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(register.this, "Please enter your Password.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(register.this, "Please enter your username.",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    username=Username.getText().toString();
                                    myRef1=myRef.push();
                                    myRef1.child("email").setValue(email);
                                    myRef1.child("password").setValue(pass);
                                    myRef1.child("user name").setValue(username);

                                    Toast.makeText(register.this, "Welcome To OUR_Network",
                                            Toast.LENGTH_SHORT).show();


                                }else if(!task.isSuccessful()){
                                    Toast.makeText(register.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        });
    }









}

