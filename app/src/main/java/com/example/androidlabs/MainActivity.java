package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private SharedPreferences preferences;

    private void getPreferences() {
        String prefsFile = "lab3_prefs.o";
        preferences = getSharedPreferences(prefsFile, Context.MODE_PRIVATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        Button login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        getPreferences();
        email.setText(preferences.getString("email", ""));

        login.setOnClickListener((e)->{
            Intent next = new Intent(MainActivity.this, ProfileActivity.class);
            next.putExtra("email", email.getText().toString());
            startActivity(next);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", email.getText().toString());
        editor.apply();
    }
}