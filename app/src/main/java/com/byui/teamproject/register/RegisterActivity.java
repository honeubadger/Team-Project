package com.byui.teamproject.register;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.Hash;
import com.byui.teamproject.R;
import com.byui.teamproject.database.MyDatabase;
import com.byui.teamproject.database.User;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onRegisterButtonClicked(View view) throws Exception {
        EditText n = findViewById(R.id.nameInput);
        String name = n.getText().toString();

        EditText e = findViewById(R.id.emailInput);
        String email = e.getText().toString();

        EditText p = findViewById(R.id.passwordInput);
        String password = Hash.hashUserPassword(p.getText().toString());

        EditText positionInput = findViewById(R.id.positionInput);
        String position = p.getText().toString();

        MyDatabase.users.add(new User(name, email, password, position));
        finish();
    }
}