package com.byui.teamproject.fingerprint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import com.byui.teamproject.MainActivity;
import com.byui.teamproject.R;
import com.byui.teamproject.database.MyDatabase;
import com.byui.teamproject.database.User;
import com.byui.teamproject.startshift.WelcomeEmployee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Executor;

public class Fingerprint extends AppCompatActivity {

    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    public Button authBtn;
    public TextView txt;
    public String email;
    public String password;
    public String log;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);
        txt = findViewById(R.id.txt);

        context = this;
        SharedPreferences shared = context.getSharedPreferences(getString(R.string.login_details), Context.MODE_PRIVATE);

        email = shared.getString("email", "null");
        password = shared.getString("password", "null");
        log = shared.getString("log", "null");

        Log.i("Informations :", email + " " + password + " " + log);

        Executor executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(Fingerprint.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                txt.setText("An error occurred : " + errString + "\nYour fingerprint was not recognized");
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                txt.setText("Authentication Success, you are now logged in");

                if(log=="login") {
                    for (User user : MyDatabase.users) {
                        if (user.email.equals(email) && user.password.equals(password)) {
                            String formattedDate = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());

                            user.lastLoggedIn = formattedDate;
                            MyDatabase.currentUser = user;
                            Intent intent = new Intent(context, WelcomeEmployee.class);
                            startActivity(intent);
                            return;
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Email or Password Invalid", Toast.LENGTH_SHORT).show();
                } else if(log=="logout") {
                    String formattedDate = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());
                    MyDatabase.currentUser.lastLoggedIn = formattedDate;
                    MyDatabase.currentUser = null;

                    Toast.makeText(getApplicationContext(), "You are successfully logged out", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    return;
                }
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Authenticate using fingerprint")
                .setSubtitle("Your fingerprint is required to Authenticate you")
                .setNegativeButtonText("Cancel").build();

        authBtn = findViewById(R.id.authBut);
        authBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
            }
        });
    }
}