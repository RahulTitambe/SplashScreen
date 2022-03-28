package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar prgProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prgProgressbar = findViewById(R.id.prgProgressBar);

        getSupportActionBar().hide();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=100; i++){
                   if(i==100){
                       Intent intent = new Intent(MainActivity.this, home.class);
                       startActivity(intent);
                   }
                   else {
                       prgProgressbar.setProgress(i);
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                }
            }
        }).start();

    }
}

