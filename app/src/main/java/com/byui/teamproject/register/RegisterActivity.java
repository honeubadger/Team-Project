package com.byui.teamproject.register;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onRegisterButtonClicked(View view) {
        EditText n = findViewById(R.id.nameInput);
        String name = n.getText().toString();

        EditText e = findViewById(R.id.emailInput);
        String email = e.getText().toString();

        EditText i = findViewById(R.id.idInput);
        String id = i.getText().toString();

        Log.i("Information : ", name + ", " + email + ", " + id);

    }


}