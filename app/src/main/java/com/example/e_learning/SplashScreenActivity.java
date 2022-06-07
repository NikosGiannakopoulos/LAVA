package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    private final static int SPLASH_SCREEN_TIMEOUT = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView title = findViewById(R.id.title);
        TextView description1 = findViewById(R.id.description1);
        TextView description2 = findViewById(R.id.description2);
        LottieAnimationView animatedSplashScreen = findViewById(R.id.animatedSplashScreen);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            finish();
        }, SPLASH_SCREEN_TIMEOUT);

        title.animate().translationX(-2000).setDuration(4000).setStartDelay(4000);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(3000);

        description1.setAnimation(animation);
        description2.setAnimation(animation);
        description1.animate().translationX(2000).setDuration(4000).setStartDelay(4000);
        description2.animate().translationX(-2000).setDuration(4000).setStartDelay(4000);

        animatedSplashScreen.animate().translationX(2000).setDuration(4000).setStartDelay(4000);
    }
}