package com.example.mob2041_ph28509.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mob2041_ph28509.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;

import androidx.core.view.WindowCompat;

public class WellcomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(WellcomeActivity.this.getWindow(), false);
        setContentView(R.layout.activity_wellcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(WellcomeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}