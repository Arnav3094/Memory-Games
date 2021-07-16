package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class WordsFragment_Display extends Fragment {
    private static final String TAG = "WordsFragment_Display";
    TextView timerText;
    public CountDownTimer countDownTimer;
    public int remainingtime;
    ArrayList words;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        timerText = getView().findViewById(R.id.timerText);


        countDownTimer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingtime = (int)millisUntilFinished / 1000;
                timerText.setText(String.valueOf(remainingtime));
            }

            @Override
            public void onFinish() {
                timerText.setText("Time Up");
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                WordsFragment_Selection WordsFragmentSelect = new WordsFragment_Selection();

                Log.d(TAG, "onFinish: Sending Number");
                Bundle bundle = new Bundle();
                //bundle.putInt("CorrectNumber", words);
                //WordsFragment_Selection.setArguments(bundle);

                //transaction.replace(R.id.frameLayout, WordsFragment_Selection);
                transaction.commit();
            }
        };
        countDownTimer.start();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words_display, container, false);
    }
}
