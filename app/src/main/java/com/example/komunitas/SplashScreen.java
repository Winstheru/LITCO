package com.example.komunitas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MapsActivity.class)
                .withSplashTimeOut(4000)
                .withLogo(R.drawable.logo);


        View easySplashScreen = config.create();
        setContentView(easySplashScreen);

        //untuk nampilin tulisan kerjain di action bar
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.tulisankerjain);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
