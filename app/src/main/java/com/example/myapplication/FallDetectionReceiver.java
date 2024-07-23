package com.example.myapplication;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class FallDetectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.example.myapplication.FALL_DETECTED".equals(action)) {
            boolean fallDetected = intent.getBooleanExtra("fall_detected", false);
            if (fallDetected) {
                showFallDetectedNotification(context);
            }
        }
    }

    private void showFallDetectedNotification(Context context) {
        // Hiển thị thông báo khi phát hiện ngã
        new AlertDialog.Builder(context)
                .setTitle("Fall Detected")
                .setMessage("A fall has been detected. Please check the situation.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
