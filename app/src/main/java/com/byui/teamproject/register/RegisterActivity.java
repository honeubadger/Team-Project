package com.byui.teamproject.register;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.R;
import com.byui.teamproject.database.MyDatabase;
import com.byui.teamproject.database.User;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView reglogo = (ImageView) findViewById(R.id.logoImage5);
        reglogo.setImageResource(R.drawable.company_logo);
    }

    public void onRegisterButtonClicked(View view) {
        EditText n = findViewById(R.id.nameInput);
        String name = n.getText().toString();

        EditText e = findViewById(R.id.emailInput);
        String email = e.getText().toString();

        EditText p = findViewById(R.id.passwordInput);
        String password = p.getText().toString();

        EditText positionInput = findViewById(R.id.positionInput);
        String position = p.getText().toString();

        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.login_details), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("email", email);
        editor.putString("password", password);

        editor.apply();

        MyDatabase.users.add(new User(name, email, password, position));
        finish();
    }
}