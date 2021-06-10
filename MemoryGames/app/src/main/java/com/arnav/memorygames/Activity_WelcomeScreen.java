package com.arnav.memorygames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_WelcomeScreen extends AppCompatActivity {

    ImageView sideCircleRight;
    ImageView sideCircleLeft;
    ImageView curvedWedgeLeft;
    ImageView curvedWedgesRight;

    TextView welcomeText;

    Animation slideInRightFadeIn;
    Animation slideInLeftFadeIn;
    Animation slideDownFromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        // Widgets
        sideCircleRight = findViewById(R.id.side_circle_right);
        sideCircleLeft = findViewById(R.id.side_circle_left);
        curvedWedgeLeft = findViewById(R.id.curved_wedge_left);
        curvedWedgesRight = findViewById(R.id.curved_wedges_right);
        welcomeText = findViewById(R.id.welcomeText);

        // Anims
        slideInRightFadeIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_right_fade_in);
        slideInLeftFadeIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_left_fade_in);
        slideDownFromTop = AnimationUtils.loadAnimation(this, R.anim.slide_down_from_top);

        sideCircleRight.setAnimation(slideInRightFadeIn);
        sideCircleLeft.setAnimation(slideInLeftFadeIn);
        curvedWedgesRight.setAnimation(slideInRightFadeIn);
        curvedWedgeLeft.setAnimation(slideInLeftFadeIn);
        welcomeText.setAnimation(slideDownFromTop);

    }
}