package com.arnav.memorygames;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;

public class WinLoseDialog {
      Activity activity;
      AlertDialog dialog;

      public WinLoseDialog(Activity activity) {
            this.activity = activity;
      }

      public void startDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            LayoutInflater inflater = activity.getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.win_lose_layout, null));
            builder.setCancelable(false);

            dialog = builder.create();
            dialog.show();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      }

      public void dismissDialog() {
            dialog.dismiss();
      }

}
