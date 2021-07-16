package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.DialogTitle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NumbersFragment_Keypad extends Fragment {
    private static final String TAG = "NumbersFragment_Keypad";

    int count = 0;
    int points = 0;
    int correctNumber;
    String UserNumber = "";
    TextView timerText;
    TextView keypadText;
    String correctnum;
    String check = "";
    public CountDownTimer countDownTimer;
    public int remainingtime = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        correctNumber = bundle.getInt("CorrectNumber") ;

        return inflater.inflate(R.layout.fragment_numbers_keypad, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        timerText = getView().findViewById(R.id.timerText);
        keypadText = getView().findViewById(R.id.keypadText);
        Button b1 = getView().findViewById(R.id.keypad1);
        Button b2 = getView().findViewById(R.id.keypad2);
        Button b3 = getView().findViewById(R.id.keypad3);
        Button b4 = getView().findViewById(R.id.keypad4);
        Button b5 = getView().findViewById(R.id.keypad5);
        Button b6 = getView().findViewById(R.id.keypad6);
        Button b7 = getView().findViewById(R.id.keypad7);
        Button b8 = getView().findViewById(R.id.keypad8);
        Button b9 = getView().findViewById(R.id.keypad9);
        Button b0 = getView().findViewById(R.id.keypad0);
        Button deleteButton = getView().findViewById(R.id.deleteButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "1";
                updateKeypadText();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "2";
                updateKeypadText();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "3";
                updateKeypadText();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "4";
                updateKeypadText();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "5";
                updateKeypadText();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "6";
                updateKeypadText();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "7";
                updateKeypadText();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "8";
                updateKeypadText();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "9";
                updateKeypadText();
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNumber = UserNumber + "0";
                updateKeypadText();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserNumber != null && UserNumber.length() > 0) {
                    UserNumber = UserNumber.substring(0, UserNumber.length() - 1);
                }
                keypadText.setText(UserNumber);
            }
        });

        countDownTimer = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingtime = (int) millisUntilFinished / 1000;
                timerText.setText(String.valueOf(remainingtime));
            }

            @Override
            public void onFinish() {
                timerText.setText("Time Up");
                correctnum = "" + correctNumber;
                if (UserNumber.equals(correctnum)) {
                    UserNumber = "";
                    keypadText.setText("Correct");
                } else if (UserNumber.equals(correctnum)) {
                    UserNumber = "";
                    keypadText.setText("Incorrect");
                }
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                NumbersFragment_Display NumbersDisplayFragment = new NumbersFragment_Display();
                transaction.replace(R.id.frameLayout, NumbersDisplayFragment);
                transaction.commit();
            }

        };
        countDownTimer.start();
    }
    public void updateKeypadText() {
        keypadText.setText(UserNumber);
        //if (!correctnum.equals("")) {
        //  keypadText.setText(correctnum);
        //}
    }
}

