package com.byui.teamproject.stopshift;

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
import com.byui.teamproject.startshift.WelcomeEmployee;

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
        String email = ((EditText) findViewById(R.id.editTextTextPersonName4)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextTextPassword4)).getText().toString();

        for (User user : MyDatabase.users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                String formattedDate = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());

                user.lastLoggedOut = formattedDate;
                MyDatabase.currentUser = user;

                Toast.makeText(getApplicationContext(), "Shift Ended", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
        }

//        String formattedDate = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());
//        MyDatabase.currentUser.lastLoggedOut = formattedDate;
//        MyDatabase.currentUser = null;

//        Intent intent = new Intent(this, GoodbyeEmployee.class);
//        startActivity(intent);
    }

    /*public void onStopShiftFaceIDClicked(View view) {
        Intent intent = new Intent(this, LogoutWithFaceID.class);
        startActivity(intent);
    }*/

    public void onStopShiftFingerprintClicked(View view) {
        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.login_details), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("log", "logout");

        editor.apply();

        Intent intent = new Intent(this, Fingerprint.class);
        startActivity(intent);
    }


}