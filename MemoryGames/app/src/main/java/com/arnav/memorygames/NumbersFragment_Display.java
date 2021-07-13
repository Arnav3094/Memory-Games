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

import java.util.Random;

public class NumbersFragment_Display extends Fragment {
    private static final String TAG = "NumbersFragment_Display";
    //public interface Number1{
      //  void sendNumber(int numberToPass);
    //}
    TextView Number;
    TextView timerText;
    public CountDownTimer countDownTimer;
    public int remainingtime = 5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_numbers_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Number = getView().findViewById(R.id.Number);
        timerText = getView().findViewById(R.id.timerText);

        int[] random_integer = new int[0];
        Random rand = new Random();
        random_integer = new int[]{rand.nextInt(100000 - 9999 + 1) + 9999};
        int randomint = random_integer[0];
        Number.setText(String.valueOf(randomint));

        countDownTimer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingtime = (int)millisUntilFinished / 1000;
                timerText.setText(String.valueOf(remainingtime));
            }

            @Override
            public void onFinish() {
                timerText.setText("Finished");
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                NumbersFragment_Keypad NumbersKeypadFragment = new NumbersFragment_Keypad();

                Log.d(TAG, "onFinish: Sending Number");
                Bundle bundle = new Bundle();
                bundle.putInt("CorrectNumber", randomint);
                NumbersKeypadFragment.setArguments(bundle);

                transaction.replace(R.id.frameLayout, NumbersKeypadFragment);
                transaction.commit();
                //Number1.sendNumber(randomint);
            }
        };
        countDownTimer.start();
    }
}
