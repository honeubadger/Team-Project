package com.byui.teamproject.startshift;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.byui.teamproject.R;
import com.byui.teamproject.database.MyDatabase;

public class WelcomeEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_employee);
        ImageView welcomeImage = (ImageView) findViewById(R.id.anonymous1);
        welcomeImage.setImageResource(R.drawable.anonymous);

        ImageView welcomeLogo = (ImageView) findViewById(R.id.logoImage3);
        welcomeLogo.setImageResource(R.drawable.company_logo);

        ((TextView) findViewById(R.id.employeenamewelcome)).setText("Welcome " + MyDatabase.currentUser.name);
        ((TextView) findViewById(R.id.employeepositionwelkcome)).setText(MyDatabase.currentUser.position);

    }
}