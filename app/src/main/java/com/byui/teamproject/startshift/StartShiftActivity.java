package com.byui.teamproject.startshift;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.R;
import com.byui.teamproject.database.MyDatabase;
import com.byui.teamproject.database.User;
import com.byui.teamproject.fingerprint.Fingerprint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StartShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_shift);
        ImageView startLogo = (ImageView) findViewById(R.id.logoImage1);
        startLogo.setImageResource(R.drawable.company_logo);

        setTitle("Start Shift");
    }

    public void onStartShiftloggedClicked(View view) {
        String email = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextTextPassword)).getText().toString();

        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.login_details), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("log", "login");
        editor.putString("email", email);
        editor.putString("password", password);

        editor.apply();

        for (User user : MyDatabase.users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                String formattedDate = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());

                user.lastLoggedIn = formattedDate;
                MyDatabase.currentUser = user;
                Intent intent = new Intent(this, WelcomeEmployee.class);
                startActivity(intent);
                return;
            }
        }
        Toast.makeText(getApplicationContext(), "Email or Password Invalid", Toast.LENGTH_SHORT).show();
    }

    public void onLoginWithFingerprintClicked(View view) {

        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.login_details), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("log", "login");

        editor.apply();

        Intent intent = new Intent(this, Fingerprint.class);
        startActivity(intent);
    }

    public void onLoginWithFaceIDClicked(View view) {
        Intent intent = new Intent(this, LoginWithFaceID.class);
        startActivity(intent);
    }


}