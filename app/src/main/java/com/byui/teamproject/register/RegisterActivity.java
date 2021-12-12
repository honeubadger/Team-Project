package com.byui.teamproject.register;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.byui.teamproject.R;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class RegisterActivity extends AppCompatActivity {

    private static final Random RANDOM = new SecureRandom();

    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

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

        EditText i = findViewById(R.id.idInput);
        String id = i.getText().toString();

        EditText p = findViewById(R.id.passwordInput);
        String pwd = p.getText().toString();
        String password = hashUserPassword(pwd);

        Log.i("Password : ", password);
    }

    private static byte[] getNextSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    private static byte[] getHash(char[] password, byte[] salt) throws Exception {

        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);

        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();

        return hash;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String hashUserPassword(String pwd) throws Exception {

        // Get the next random salt value to use for this password
        byte[] salt = getNextSalt();
        char[] password = pwd.toCharArray();

        boolean hasDigit = false;
        for (Character c : password) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        // Once we've generated the hash, clear the old password
        // from memory for security purposes
        byte[] hash = getHash(password, salt);
        Arrays.fill(password, Character.MIN_VALUE);

        if (hash != null) {

            // By Base64-encoding the raw bytes, we can store them as strings.
            // This allows us to save the values to a file or database if needed.
            // For more information on Base64 encoding, see:
            // http://stackoverflow.com/questions/201479/what-is-base-64-encoding-used-for
            // https://en.wikipedia.org/wiki/Base64
            String hashString = Base64.getEncoder().encodeToString(hash);

            return hashString;
        } else {
            return null;
        }
    }


}