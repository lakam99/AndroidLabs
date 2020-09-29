package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private boolean switch_state = false;
    private Switch passed;
    String snack_text = "NO TEXT";

    public class Undo implements View.OnClickListener {
        @Override
        public void onClick(View s) {
            passed.setChecked(!switch_state);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        final Switch my_switch = findViewById(R.id.my_switch);

        Button my_btn = findViewById(R.id.click_btn);

        my_btn.setOnClickListener((e)->{
            Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message),
                    Toast.LENGTH_LONG).show();
        });

        my_switch.setOnCheckedChangeListener((eventClicked, newState)->{
            switch_state = newState;
            passed = my_switch;
            if (newState) {
                snack_text = getResources().getString(R.string.switch_on);
            } else {
                snack_text = getResources().getString(R.string.switch_off);
            }
            Snackbar.make(my_switch, snack_text, Snackbar.LENGTH_LONG).
                    setAction(getResources().getString(R.string.undo), new Undo()).show();
        });
    }
}