package com.example.yudha.pemadamkebakaran;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       imageView = findViewById(R.id.imageView);
       if(imageView == null)throw new AssertionError();
       imageView.setBackgroundResource(R.drawable.animation_loading);
       anim = (AnimationDrawable)imageView.getBackground();
       anim.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 9000);
   }
}
