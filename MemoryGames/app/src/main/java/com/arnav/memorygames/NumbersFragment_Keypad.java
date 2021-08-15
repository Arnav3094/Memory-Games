package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersFragment_Keypad extends Fragment {

      private static final String TAG = "NumbersFragment_Keypad";
      long number;
      Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, del;
      Button[] keysArray;
      ProgressBar progressBar;
      ArrayList<Button> keys;
      TextView progressText, keypadText, timeRemainingText;
      CountDownTimer timer;
      WinLoseDialog dialog;
      ConstraintLayout constraint;

      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_numbers_keypad, container, false);
      }

      @Override
      public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            assert this.getArguments() != null;
            number = this.getArguments().getLong("CorrectNum");

            progressText = requireView().findViewById(R.id.progressText);
            keypadText = requireView().findViewById(R.id.keypadText);
            progressBar = requireView().findViewById(R.id.progressBar);
            progressText = requireView().findViewById(R.id.progressText);
            constraint = requireView().findViewById(R.id.constraint);
            timeRemainingText = requireView().findViewById(R.id.timeRemainingText);

            b1 = requireView().findViewById(R.id.keypad1);
            b2 = requireView().findViewById(R.id.keypad2);
            b3 = requireView().findViewById(R.id.keypad3);
            b4 = requireView().findViewById(R.id.keypad4);
            b5 = requireView().findViewById(R.id.keypad5);
            b6 = requireView().findViewById(R.id.keypad6);
            b7 = requireView().findViewById(R.id.keypad7);
            b8 = requireView().findViewById(R.id.keypad8);
            b9 = requireView().findViewById(R.id.keypad9);
            b0 = requireView().findViewById(R.id.keypad0);
            del = requireView().findViewById(R.id.deleteButton);
            Log.d(TAG, "onViewCreated: ");

            keysArray = new Button[]{b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
            Log.d(TAG, "onViewCreated: " + Arrays.toString(keysArray));
            keys = new ArrayList<>();
            keys.addAll(Arrays.asList(keysArray));
            Log.d(TAG, "onViewCreated: " + keys.toString());

            for (int i = 0; i <= 9; i++) {
                  keys.get(i).setOnClickListener(onClick(i));
            }

            del.setOnClickListener(v -> {
                  String text = (String) keypadText.getText();
                  if (text.length() > 0) {
                        text = text.substring(0, text.length() - 1);
                  }
                  keypadText.setText(text);
            });


            countDown(15000, 1);
      }

      private void countDown(long timeLeftInMillis, int countDownInterval) {
            timer = new CountDownTimer(timeLeftInMillis, countDownInterval) {
                  final int timeInSeconds = (int) (timeLeftInMillis / 1000);
                  int secondsLeft;
                  int progress;
                  String timeLeftText;

                  @Override
                  public void onTick(long millisUntilFinished) {
                        progress = (int) millisUntilFinished / (countDownInterval * 10 * timeInSeconds);
                        secondsLeft = (int) millisUntilFinished / 1000;
                        timeLeftText = "" + (secondsLeft + 1);
                        progressText.setText(timeLeftText);
                        progressBar.setProgress(progress, true);
                  }

                  @Override
                  public void onFinish() {
                        String timeUp = "Time's Up!";
                        progressText.setText(timeUp);
                        if (keypadText.getText().toString().equals(Long.toString(number))) {
                              onWin();
                        } else {
                              onLose();
                        }
                  }

            }.start();
      }

      private void onLose() {
            String msg = "Oh No!\n" +
                    "\nThe Correct Number was:" +
                    "\n" + number +
                    "\n\n You entered:" +
                    "\n" + keypadText.getText().toString();
            dialog = new WinLoseDialog(getActivity(), R.raw.error_animation, msg);
            dialog.startDialog();
            dialog.show();
            onEnd();
      }

      private void onWin() {
            dialog = new WinLoseDialog(getActivity(), R.raw.check_animation, "Yay!\nYou got it correct!");
            dialog.startDialog();
            dialog.show();
            onEnd();
      }

      private void onEnd() {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, new NumbersFragment_Start())
                    .commit();
            timeRemainingText.setVisibility(View.GONE);
            timer.cancel();
            new Handler().postDelayed(() -> dialog.dismiss(), 10000);
      }

      public View.OnClickListener onClick(int num) {
            return v -> addToKeypadText("" + num);
      }

      public void addToKeypadText(String str) {
            if (keypadText.getText().toString().length() < 12) {
                  String newText = keypadText.getText().toString() + str;
                  keypadText.setText(newText);
            } else {
                  Log.d(TAG, "addToKeypadText: Toast");
                  Snackbar.make(constraint, "The number isn't that long", 900)
                          .setAnimationMode(Snackbar.ANIMATION_MODE_FADE)
                          .show();
//                  Toast.makeText(requireActivity().getBaseContext(), "The number isn't that long", Toast.LENGTH_SHORT).show();
            }
      }

}

