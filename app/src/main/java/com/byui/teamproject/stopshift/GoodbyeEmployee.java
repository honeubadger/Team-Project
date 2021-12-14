package com.byui.teamproject.stopshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.byui.teamproject.R;

public class GoodbyeEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodbye_employee);
        ImageView goodByeImage = (ImageView) findViewById(R.id.anonymous2);
        goodByeImage.setImageResource(R.drawable.anonymous);

        ImageView goodbyeLogo = (ImageView) findViewById(R.id.logoImage4);
        goodbyeLogo.setImageResource(R.drawable.company_logo);

    }
}