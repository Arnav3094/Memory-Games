package com.arnav.memorygames;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class WinLoseDialog {
      Activity activity;
      AlertDialog dialog;
      TextView text;
      LottieAnimationView lottie;
      String textStr;
      int lottieRes;
      ImageView close;

      public WinLoseDialog(Activity activity, int lottieRes, String textStr) {
            this.activity = activity;
            this.textStr = textStr;
            this.lottieRes = lottieRes;
      }

      public void startDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            LayoutInflater inflater = activity.getLayoutInflater();
            View view = inflater.inflate(R.layout.win_lose_layout, null);
            builder.setView(view);
            builder.setCancelable(false);

            lottie = view.findViewById(R.id.lottie);
            text = view.findViewById(R.id.alertText);
            close = view.findViewById(R.id.close);

            close.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                        dialog.dismiss();
                  }
            });
            lottie.setAnimation(lottieRes);
            text.setText(textStr);

            dialog = builder.create();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      }

      public void show() {
            dialog.show();
      }

      public void dismiss() {
            dialog.dismiss();
      }

}
