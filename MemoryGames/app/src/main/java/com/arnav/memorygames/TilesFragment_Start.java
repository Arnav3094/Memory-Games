package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TilesFragment_Start extends Fragment {

    private static final String TAG = "TilesFragment_Start";
    Button startButton;
    CountDownTimer timer;
    ConstraintLayout constraintLayout;
    LinearLayout grid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tiles_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        startButton = requireView().findViewById(R.id.startButton);
        constraintLayout = requireView().findViewById(R.id.constraintLayout);
        grid = requireView().findViewById(R.id.grid);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Start Button Clicked");
                countDown(3000);
                startButton.setEnabled(false);
                startButton.setBackgroundResource(R.drawable.disabled_start_button);
            }
        });
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: constraint Layout");
                incorrectClick();
            }
        });
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: grid");
                incorrectClick();
            }
        });
    }

    void incorrectClick() {
        Log.d(TAG, "incorrectClick: ");
        Toast.makeText(requireActivity().getBaseContext(), "Please click the 'Start' button to begin", Toast.LENGTH_SHORT).show();
    }

    private void countDown(long timeLeftInMillis) {
        timer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int secondsLeft;
                secondsLeft = (int) millisUntilFinished / 1000;
                String timeLeftText = "" + (secondsLeft + 1);
                startButton.setText(timeLeftText);
            }

            @Override
            public void onFinish() {
                FragmentManager manager = requireActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Log.d(TAG, "onFinish: Moving to TilesFragment_Game Fragment");
                transaction
                        .replace(R.id.frameLayout, new TilesFragment_Game())
                        .commit();
            }

        }.start();
    }
}