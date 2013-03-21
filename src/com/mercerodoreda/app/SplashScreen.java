package com.mercerodoreda.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
 

public class SplashScreen extends Activity {
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
 
        // run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {
 
            @Override
            public void run() {
 
                
                finish();
 
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(intent);
 
            }
 
        }, 3000);
 
    }



 
}