package com.arnav.memorygames;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class WordsFragment_Start extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button startButton = getView().findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = requireActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                WordsFragment_Display WordsDisplayFragment = new WordsFragment_Display();
                transaction.replace(R.id.frameLayout, WordsDisplayFragment);
                transaction.commit();
            }
        });

        return inflater.inflate(R.layout.fragment_words_start, container, false);
    }
}