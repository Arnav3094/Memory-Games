package com.arnav.memorygames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_WelcomeScreen extends AppCompatActivity {

    private static final String TAG = "Activity_WelcomeScreen";

    ImageView sideCircleRight, sideCircleLeft, curvedWedgeLeft, curvedWedgesRight;

    TextView welcomeText;

    Button playButton;

    Animation slideInRight, slideInLeft, slideDownFromTop, slideOutToBottom, slideOutToLeft, slideOutToRight, slideOutToTop;

    Intent intentWelcomeToMain;

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
        playButton = findViewById(R.id.playButton);

        // Anims
        slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        slideDownFromTop = AnimationUtils.loadAnimation(this, R.anim.slide_down_from_top);
        slideOutToBottom = AnimationUtils.loadAnimation(this, R.anim.slide_out_to_bottom);
        slideOutToLeft = AnimationUtils.loadAnimation(this, R.anim.slide_out_to_left);
        slideOutToRight = AnimationUtils.loadAnimation(this, R.anim.slide_out_to_right);
        slideOutToTop = AnimationUtils.loadAnimation(this, R.anim.slide_out_to_top);

        // Setting anims
        sideCircleRight.setAnimation(slideInRight);
        sideCircleLeft.setAnimation(slideInLeft);
        curvedWedgesRight.setAnimation(slideInRight);
        curvedWedgeLeft.setAnimation(slideInLeft);

        welcomeText.setAnimation(slideDownFromTop);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: button clicked");

                // Here you will put the anims for each element
                Log.d(TAG, "onClick: animations started");
                playButton.startAnimation(slideOutToBottom);
                curvedWedgeLeft.startAnimation(slideOutToLeft);
                curvedWedgesRight.startAnimation(slideOutToRight);
                welcomeText.startAnimation(slideOutToTop);
                sideCircleLeft.startAnimation(slideOutToLeft);
                sideCircleRight.startAnimation(slideOutToRight);

                intentWelcomeToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentWelcomeToMain);
                // This will take the actual view animation
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

    }
}