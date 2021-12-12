package com.byui.teamproject.startshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.byui.teamproject.R;

public class WelcomeEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_employee);
        ImageView welcomeImage = (ImageView) findViewById(R.id.anonymous1);
        welcomeImage.setImageResource(R.drawable.anonymous);

        ImageView welcomeLogo = (ImageView) findViewById(R.id.logoImage3);
        welcomeLogo.setImageResource(R.drawable.company_logo);

    }
}