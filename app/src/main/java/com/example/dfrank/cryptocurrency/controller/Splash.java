package com.example.dfrank.cryptocurrency.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dfrank.cryptocurrency.R;

/**
 * Created by dfrank on 11/1/17.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
//        TextView textView = (TextView)findViewById(R.id.splash);
//        ImageView imageView = (ImageView) findViewById(R.id.splashImage);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
//        Animation display = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
//        imageView.startAnimation(display);
//        textView.startAnimation(animation);
        Thread time = new Thread(){
            public void run(){
                try {
                    TextView textView = findViewById(R.id.splash);
                    ImageView imageView = findViewById(R.id.splashImage);
                    Animation display = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    imageView.startAnimation(display);
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    textView.startAnimation(animation);
                    sleep(7000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent =new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        time.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }
}
