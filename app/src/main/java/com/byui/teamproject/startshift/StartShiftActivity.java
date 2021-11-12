package com.byui.teamproject.startshift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.byui.teamproject.R;

public class StartShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_shift);

        setTitle("Start Shift");
    }
    public void onStartShiftloggedClicked(View view) {
        Intent intent = new Intent(this, WelcomeEmployee.class);
        startActivity(intent);
    }

    public void onLoginWithFaceIDClicked(View view) {
        Intent intent = new Intent(this, LoginWithFaceID.class);
        startActivity(intent);
    }
}