package com.byui.teamproject.stopshift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.byui.teamproject.R;

public class StopShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_shift);
        ImageView endLogo = (ImageView) findViewById(R.id.logoImage2);
        endLogo.setImageResource(R.drawable.company_logo);

        setTitle("End Shift");
    }

    public void onStopShiftloggedClicked(View view) {
        Intent intent = new Intent(this, GoodbyeEmployee.class);
        startActivity(intent);
    }

    public void onStopShiftFaceIDClicked(View view) {
        Intent intent = new Intent(this, LogoutWithFaceID.class);
        startActivity(intent);
    }


}