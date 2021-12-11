package com.byui.teamproject.startshift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.R;
import com.byui.teamproject.fingerprint.Fingerprint;

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

    public void onLoginWithFingerprintClicked(View view) {
        Intent intent = new Intent(this, Fingerprint.class);
        startActivity(intent);
    }

    public void onLoginWithFaceIDClicked(View view) {
        Intent intent = new Intent(this, LoginWithFaceID.class);
        startActivity(intent);
    }
}