package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import butterknife.BindView;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.tvSplash) TextView tvSplash;
    @BindView(R.id.imageSplash) ImageView imageSplash;

    private static final int DURATION = 3000;
    private static final int TIME_LATER = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(DURATION);
        fadeIn.setStartOffset(TIME_LATER);
        fadeIn.setFillAfter(true);

        final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(DURATION);
        fadeOut.setStartTime(TIME_LATER);
        fadeOut.setFillAfter(true);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                tvSplash.setText("LIKE NUUK");
                imageSplash.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tvSplash.startAnimation(fadeOut);
                imageSplash.startAnimation(fadeOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);

                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        tvSplash.startAnimation(fadeIn);
        imageSplash.startAnimation(fadeIn);

    }
}
