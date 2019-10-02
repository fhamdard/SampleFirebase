package com.newapp.samplefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    EditText etEmail,etPassword;
    Button btnLogin;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mAuth=FirebaseAuth.getInstance();

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=etEmail.getText().toString();
                String password =etPassword.getText().toString();

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            Toast.makeText(Main2Activity.this, "Sign In SuccessFull", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(Main2Activity.this, "Incorrect Email and Password Try Again", Toast.LENGTH_SHORT).show();

                        }

                    }
                });




            }
        });

    }
}

//Code For The SignUp

//                mAuth.createUserWithEmailAndPassword("malik1@gmail.com","123456").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                    }
//                });
