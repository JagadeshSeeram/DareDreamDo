package com.justsmartapps.daredreamdo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

import com.justsmartapps.daredreamdo.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        View rocketImage = findViewById(R.id.rocket);
        Animation ranim = AnimationUtils.loadAnimation(this, R.anim.tilt_anim);
        ranim.setFillAfter(true);
        rocketImage.startAnimation(ranim);
    }

    public  void goNext(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
