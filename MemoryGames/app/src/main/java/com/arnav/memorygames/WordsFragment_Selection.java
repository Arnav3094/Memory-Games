package com.arnav.memorygames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Dictionary;

public class WordsFragment_Selection extends Fragment {

    int count = 0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Button button17;
    Button button18;
    String[] TotalWords;
    Button[] buttonArray;
    Button[] correctButtonArray;
    String[] UserWords;
    String[] words;
    Dictionary wordsDictionary;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_words_selection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TotalWords = new String[]{
                "consider", "minute", "accord", "evident", "practice", "intend", "conduct", "engage", "obtain", "scarce", "policy", "straight",
                "stock", "apparent", "property", "fancy", "concept", "court", "appoint", "passage", "vain", "instance", "coast", "project",
                "commission", "constant", "circumstances", "constitute", "level", "affect", "institute", "render", "appeal", "generate",
                "theory", "range", "campaign", "league", "labor", "confer", "grant", "dwell", "entertain", "contract", "earnest","yield",
                "wander", "insist", "knight", "convince", "inspire", "convention", "skill", "harry", "financial", "reflect", "novel", "furnish",
                "compel", "venture", "territory", "temper", "bent", "intimate", "undertake", "majority", "crew", "chamber", "humble", "scheme",
                "keen", "liberal", "despair", "tide", "attitude", "justify", "flag", "merit", "manifest", "notion", "scale", "formal",
                "resource", "persist", "contempt","bat","ball","cricket","watch"
        }; //90

        button1 = getView().findViewById(R.id.button1);
        button2 = getView().findViewById(R.id.button2);
        button3 = getView().findViewById(R.id.button3);
        button4 = getView().findViewById(R.id.button4);
        button5 = getView().findViewById(R.id.button5);
        button6 = getView().findViewById(R.id.button6);
        button7 = getView().findViewById(R.id.button7);
        button8 = getView().findViewById(R.id.button8);
        button9 = getView().findViewById(R.id.button9);
        button10 = getView().findViewById(R.id.button10);
        button11 = getView().findViewById(R.id.button11);
        button12 = getView().findViewById(R.id.button12);
        button13 = getView().findViewById(R.id.button13);
        button14 = getView().findViewById(R.id.button14);
        button15 = getView().findViewById(R.id.button15);
        button16 = getView().findViewById(R.id.button16);
        button17 = getView().findViewById(R.id.button17);
        button18 = getView().findViewById(R.id.button18);

        buttonArray[0] = button1;
        buttonArray[1] = button2;
        buttonArray[2] = button3;
        buttonArray[3] = button4;
        buttonArray[4] = button5;
        buttonArray[5] = button6;
        buttonArray[6] = button7;
        buttonArray[7] = button8;
        buttonArray[8] = button9;
        buttonArray[9] = button10;
        buttonArray[10] = button11;
        buttonArray[11] = button12;
        buttonArray[12] = button13;
        buttonArray[13] = button14;
        buttonArray[14] = button15;
        buttonArray[15] = button16;
        buttonArray[16] = button17;
        buttonArray[17] = button18;

        for (int i = 0; i < 9; i ++ ){
            correctButtonArray[i] = buttonArray[Integer.parseInt(String.valueOf(Math.random() * 19))];
        }

        for (int x = 0; x < 19; x++){
            String word = TotalWords[Integer.parseInt(String.valueOf(Math.random() * 19))];
            wordsDictionary.put(buttonArray[x],word);
            buttonArray[x].setText(word);
        }

        for (int j = 0; j < 9; j++){
            wordsDictionary.remove(correctButtonArray[j]);
            wordsDictionary.put(correctButtonArray[j], words[j]);
            correctButtonArray[j].setText(words[j]);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button1));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button2));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button3));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button4));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button5));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button6));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button7));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button8));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button9));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button10));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button11));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button12));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button13));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button14));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button15));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button16));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button17));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWords[count] = String.valueOf(wordsDictionary.get(button18));
                count++;
                if (count >= 8){
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
                    transaction.replace(R.id.frameLayout, WordsFragmentStart);
                    transaction.commit();
                }
            }
        });


        Bundle bundle = this.getArguments();
        words = bundle.getStringArray("CorrectWords");

        super.onViewCreated(view, savedInstanceState);
    }
}
