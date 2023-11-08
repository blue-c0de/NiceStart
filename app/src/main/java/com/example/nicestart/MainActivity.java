package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView chica, chico, ambos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main_land);
        } else {
            setContentView(R.layout.activity_main);
        }

        chico = findViewById(R.id.imageView);
        chica = findViewById(R.id.imageView2);
        ambos = findViewById(R.id.imageView3);
    }

    public void openBoyTinder(View view){
        Intent intent = new Intent(MainActivity.this, BoyTinder.class);
        startActivity(intent);
    }

    public void openGirlTinder(View view){
        Intent intent = new Intent(MainActivity.this, GirlTinder.class);
        startActivity(intent);
    }

    public void openBothTinder(View view){
        Intent intent = new Intent(MainActivity.this, BothTinder.class);
        startActivity(intent);
    }
}