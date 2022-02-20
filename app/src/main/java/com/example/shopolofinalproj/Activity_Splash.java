package com.example.shopolofinalproj;


import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Activity_Splash extends AppCompatActivity {

    private final int ANIMATION_DURATION = 2000;
    private TextView splash_LBL_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViews();
        initViews();
        startAnimation(splash_LBL_name);
    }

    private void startAnimation(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        view.setY(-height / 2);
        view.animate()
                .translationY(0)
                .setDuration(ANIMATION_DURATION)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                    }
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Intent myIntent = new Intent(Activity_Splash.this, Activity_Login.class);
                        startActivity(myIntent);
                        finish();
                    }
                    @Override
                    public void onAnimationCancel(Animator animator) { }
                    @Override
                    public void onAnimationRepeat(Animator animator) { }
                });

    }

    private void initViews() {
    }

    private void findViews() {
        splash_LBL_name = findViewById(R.id.splash_LBL_name);
    }


}