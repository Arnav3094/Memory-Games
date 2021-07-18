package com.arnav.memorygames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WordsFragment_Selection extends Fragment {

    String[] words;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_words_selection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        words = bundle.getStringArray("CorrectWords");

        super.onViewCreated(view, savedInstanceState);
    }
}
