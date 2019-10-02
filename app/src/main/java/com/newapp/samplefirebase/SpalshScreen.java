package com.newapp.samplefirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SpalshScreen extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);

        mAuth= FirebaseAuth.getInstance();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(SpalshScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }else{
                    Intent intent = new Intent(SpalshScreen.this, Main2Activity.class);
                    startActivity(intent);
                    finish();



                }
            }
        },3000);
    }
}
