package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NumbersFragment_Display extends Fragment {

    private static final String TAG = "NumbersFragment_Display";
    final long lim = 9_999_999_999L;
    TextView numberText;
    TextView progressText;
    CountDownTimer timer;
    long number;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_numbers_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        numberText = requireView().findViewById(R.id.Number);
        progressText = requireView().findViewById(R.id.progressText);
        number = (long) (Math.random() * lim);
        progressBar = requireView().findViewById(R.id.progressBar);
        countDown(5000, 1);
        String text = "" + number;
        numberText.setText(text);

    }

    private void countDown(long timeLeftInMillis, int countDownInterval) {
        timer = new CountDownTimer(timeLeftInMillis, countDownInterval) {
            final int timeInSeconds = (int) (timeLeftInMillis / 1000);
            int secondsLeft;
            int progress;
            String timeLeftText;

            @Override
            public void onTick(long millisUntilFinished) {

                secondsLeft = (int) millisUntilFinished / 1000;
                progress = (int) millisUntilFinished / (countDownInterval * 10 * timeInSeconds);
                timeLeftText = "" + (secondsLeft + 1);
                progressText.setText(timeLeftText);
                progressBar.setProgress(progress, true);
            }

            @Override
            public void onFinish() {
                String timeUp = "Time's Up!";
                progressText.setText(timeUp);
                Bundle bundle = new Bundle();
                bundle.putLong("CorrectNum", number);
                NumbersFragment_Keypad keypad = new NumbersFragment_Keypad();
                keypad.setArguments(bundle);
                FragmentManager manager = requireActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction
                        .replace(R.id.frameLayout, keypad)
                        .commit();

            }
        }.start();
    }

}
