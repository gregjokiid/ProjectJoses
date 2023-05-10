package com.joses.uts.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.joses.uts.R;

public class SplashActivity extends AppCompatActivity {

    private int loading_time = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(home);
                finish();
            }
        },loading_time);
    }
}