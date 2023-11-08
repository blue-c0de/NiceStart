package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
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