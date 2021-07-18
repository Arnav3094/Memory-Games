package com.arnav.memorygames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class WordsFragment_Selection extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Bundle bundle = this.getArguments();
        //words = bundle.getInt("CorrectWords") ;

        return inflater.inflate(R.layout.fragment_words_selection, container, false);
    }

}
