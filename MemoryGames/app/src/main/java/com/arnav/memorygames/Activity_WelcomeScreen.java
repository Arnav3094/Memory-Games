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

import java.lang.reflect.Method;

public class Activity_WelcomeScreen extends AppCompatActivity {

    private static final String TAG = "Activity_WelcomeScreen";

    ImageView sideCircleRight, sideCircleLeft, curvedWedgeLeft, curvedWedgesRight;

    TextView welcomeText;

    Button playButton;

    Animation slideInRight, slideInLeft, slideDownFromTop, slideOutToBottom;

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



        // Setting anims
        sideCircleRight.setAnimation(slideInRight);
        sideCircleLeft.setAnimation(slideInLeft);
        curvedWedgesRight.setAnimation(slideInRight);
        curvedWedgeLeft.setAnimation(slideInLeft);

        welcomeText.setAnimation(slideDownFromTop);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideOutToBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_to_bottom);
                // Here you will put the anims for each element
                playButton.setAnimation(slideOutToBottom);
                Log.d(TAG, "onClick: button clicked");
//                curvedWedgeLeft.setAnimation();
//                curvedWedgesRight.setAnimation();
//                welcomeText.setAnimation();
//                sideCircleLeft.setAnimation();
//                sideCircleRight.setAnimation();

//                Thread intentThread = new Thread(){
//                    public void run(){
//                        try {
//                            Thread.sleep(2000);
//                            startActivity(intentWelcomeToMain);
//                            Log.d(TAG, "Thread Started");
//                        } catch(Exception e){
//                            Log.d(TAG, "thread run: Exception -> " + e);
//                        }
//                    }
//                };

/*                intentWelcomeToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentWelcomeToMain);

                // This will take the actual view anims
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

                //TODO: Set Animations for all elements to leave the screen when activity is changing

            }
        });

    }
}