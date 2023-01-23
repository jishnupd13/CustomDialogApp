package com.perl.customdialogapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class MainActivity extends AppCompatActivity {

    AppCompatButton buttonCompleteProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCompleteProfile = findViewById(R.id.btnOpenDialog);
        buttonCompleteProfile.setOnClickListener(view ->
                openCompleteProfileDialog()
        );

    }


    private void openCompleteProfileDialog(){
        View completeProfileAlertDialogView = getLayoutInflater().inflate(R.layout.alert_dialog_profile_complete,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(completeProfileAlertDialogView);
        builder.setCancelable(false);
        AlertDialog customAlertDialog = builder.create();
        AppCompatButton buttonCloseDialog  = completeProfileAlertDialogView.findViewById(R.id.btnOk);
        CircularProgressBar circularProgressBar = completeProfileAlertDialogView.findViewById(R.id.circularProgressBar);
        circularProgressBar.setProgressWithAnimation(65f, 2000L);
        buttonCloseDialog.setOnClickListener(v -> customAlertDialog.cancel());
        customAlertDialog.show();
    }
}