package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsFragment_Display extends Fragment {
    private static final String TAG = "WordsFragment_Display";
    TextView timerText;
    public CountDownTimer countDownTimer;
    public int remainingtime;
    //List<String> list =new ArrayList<String>();
    //list = ["consider", "minute", "accord", "evident", "practice", "intend"];
    TextView word1;
    TextView word2;
    TextView word3;
    TextView word4;
    TextView word5;
    TextView word6;
    TextView word7;
    TextView word8;
    String[] TotalWords = new String[89];
    String[] wordPlaces = new String[8];
    String[] words = new String[8];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        word1 = getView().findViewById(R.id.word1);
        word2 = getView().findViewById(R.id.word2);
        word3 = getView().findViewById(R.id.word3);
        word4 = getView().findViewById(R.id.word4);
        word5 = getView().findViewById(R.id.word5);
        word6 = getView().findViewById(R.id.word6);
        word7 = getView().findViewById(R.id.word7);
        word8 = getView().findViewById(R.id.word8);

        TotalWords = new String[]{
                "consider", "minute", "accord", "evident", "practice", "intend", "conduct", "engage", "obtain", "scarce", "policy", "straight",
                "stock", "apparent", "property", "fancy", "concept", "court", "appoint", "passage", "vain", "instance", "coast", "project",
                "commission", "constant", "circumstances", "constitute", "level", "affect", "institute", "render", "appeal", "generate",
                "theory", "range", "campaign", "league", "labor", "confer", "grant", "dwell", "entertain", "contract", "earnest","yield",
                "wander", "insist", "knight", "convince", "inspire", "convention", "skill", "harry", "financial", "reflect", "novel", "furnish",
                "compel", "venture", "territory", "temper", "bent", "intimate", "undertake", "majority", "crew", "chamber", "humble", "scheme",
                "keen", "liberal", "despair", "tide", "attitude", "justify", "flag", "merit", "manifest", "notion", "scale", "formal",
                "resource", "persist", "contempt","bat","ball","cricket","watch"
        }; //89
        timerText = getView().findViewById(R.id.timerText);

        Random rand = new Random();
        for (int i = 0; i < 8; i ++ ){
            wordPlaces[i] = String.valueOf((Math.random() * 91));
            words[i] = TotalWords[rand.nextInt(80)];
        }
        word1.setText(words[0]);
        word2.setText(words[1]);
        word3.setText(words[2]);
        word4.setText(words[3]);
        word5.setText(words[4]);
        word6.setText(words[5]);
        word7.setText(words[6]);
        word8.setText(words[7]);

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
                bundle.putCharSequenceArray("CorrectWords", words);
                WordsFragmentSelect.setArguments(bundle);

                transaction.replace(R.id.frameLayout, WordsFragmentSelect);
                transaction.commit();
            }
        };
        countDownTimer.start();

        super.onViewCreated(view, savedInstanceState);
    }
}
