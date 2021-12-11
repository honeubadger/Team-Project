package com.byui.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.records.ShowRecords;
import com.byui.teamproject.register.RegisterActivity;
import com.byui.teamproject.startshift.StartShiftActivity;
import com.byui.teamproject.stopshift.StopShiftActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartShiftClicked(View view) {
        Intent intent = new Intent(this, StartShiftActivity.class);
        startActivity(intent);
    }

    public void onShowRecordsClicked(View view) {
        Intent intent = new Intent(this, ShowRecords.class);
        startActivity(intent);
    }
    public void onStopShiftClicked(View view) {
        Intent intent = new Intent(this, StopShiftActivity.class);
        startActivity(intent);
    }

    public void onRegisterClicked(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}