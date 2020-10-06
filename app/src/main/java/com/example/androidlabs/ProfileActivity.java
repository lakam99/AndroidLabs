package com.example.androidlabs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageButton btn;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";

    private void log(String functionName) {
        Log.e(ACTIVITY_NAME, "In function " + functionName + ".");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText email = findViewById(R.id.savedEmail);
        Intent prev = getIntent();
        btn = findViewById(R.id.picBtn);

        email.setText(prev.getStringExtra("email"));
        btn.setOnClickListener((e)->{
            Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePic.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePic, REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override
    protected void onStart() {
        log("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        log("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        log("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        log("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        log("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        log("onActivityResult");
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap image = (Bitmap) extras.get("data");
                btn.setImageBitmap(image);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}