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
import java.util.List;

public class WordsFragment_Display extends Fragment {
    private static final String TAG = "WordsFragment_Display";
    TextView timerText;
    public CountDownTimer countDownTimer;
    public int remainingtime;
    //List<String> list =new ArrayList<String>();
    //list = ["consider", "minute", "accord", "evident", "practice", "intend"];
    String[] TotalWords;
    String[] words;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TotalWords = new String[]{
                "consider", "minute", "accord", "evident", "practice", "intend", "conduct", "engage", "obtain", "scarce", "policy", "straight",
                "stock", "apparent", "property", "fancy", "concept", "court", "appoint", "passage", "vain", "instance", "coast", "project",
                "commission", "constant", "circumstances", "constitute", "level", "affect", "institute", "render", "appeal", "generate",
                "theory", "range", "campaign", "league", "labor", "confer", "grant", "dwell", "entertain", "contract", "earnest","yield",
                "wander", "insist", "knight", "convince", "inspire", "convention", "skill", "harry", "financial", "reflect", "novel", "furnish",
                "compel", "venture", "territory", "temper", "bent", "intimate", "undertake", "majority", "crew", "chamber", "humble", "scheme",
                "keen", "liberal", "despair", "tide", "attitude", "justify", "flag", "merit", "manifest", "notion", "scale", "formal",
                "resource", "persist", "contempt"
        };
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

                //Log.d(TAG, "onFinish: Sending Number");
                //Bundle bundle = new Bundle();
                //bundle.putCharSequenceArrayList("CorrectWords", words);
                //WordsFragment_Selection.setArguments(bundle);

                transaction.replace(R.id.frameLayout, WordsFragmentSelect);
                transaction.commit();
            }
        };
        countDownTimer.start();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words_display, container, false);
    }
}
