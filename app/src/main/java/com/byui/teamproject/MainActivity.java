package com.byui.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.byui.teamproject.records.ShowRecords;
import com.byui.teamproject.startshift.StartShiftActivity;
import com.byui.teamproject.stopshift.StopShiftActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView logo = (ImageView) findViewById(R.id.logoImage);
        logo.setImageResource(R.drawable.company_logo);
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


}