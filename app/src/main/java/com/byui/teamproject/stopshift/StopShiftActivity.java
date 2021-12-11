package com.byui.teamproject.stopshift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.R;
import com.byui.teamproject.fingerprint.Fingerprint;

public class StopShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_shift);

        setTitle("End Shift");
    }

    public void onStopShiftloggedClicked(View view) {
        Intent intent = new Intent(this, GoodbyeEmployee.class);
        startActivity(intent);
    }

    /*public void onStopShiftFaceIDClicked(View view) {
        Intent intent = new Intent(this, LogoutWithFaceID.class);
        startActivity(intent);
    }*/

    public void onStopShiftFingerprintClicked(View view) {
        Intent intent = new Intent(this, Fingerprint.class);
        startActivity(intent);
    }


}