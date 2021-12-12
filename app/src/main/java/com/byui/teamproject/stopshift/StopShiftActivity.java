package com.byui.teamproject.stopshift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.R;
import com.byui.teamproject.database.MyDatabase;
import com.byui.teamproject.fingerprint.Fingerprint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        String formattedDate = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());
        MyDatabase.currentUser.lastLoggedIn = formattedDate;
        MyDatabase.currentUser = null;

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