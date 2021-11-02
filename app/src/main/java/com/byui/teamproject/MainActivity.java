package com.byui.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.byui.teamproject.startshift.StartShiftActivity;

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
}