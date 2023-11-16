package com.example.nicestart;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Random;

public class BoyTinder extends AppCompatActivity {

    private ImageView personasImageView;
    private TextView name, desc;
    private Button smashButton, passButton;

    private int[] imageResources = {R.drawable.boy1, R.drawable.boy2, R.drawable.boy3, R.drawable.boy4, R.drawable.boy5};
    private int[] names = {R.string.boy1, R.string.boy2, R.string.boy3, R.string.boy4, R.string.boy5};
    private int[] bios = {R.string.desc_boy1, R.string.desc_boy2, R.string.desc_boy3, R.string.desc_boy4, R.string.desc_boy5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boytinder);

        personasImageView = findViewById(R.id.profileImage);
        Glide.with(this)
                .load(R.drawable.boy1)
                .into(personasImageView);

        name = findViewById(R.id.nameTextView);
        desc = findViewById(R.id.bioTextView);
        smashButton = findViewById(R.id.smashButton);
        passButton = findViewById(R.id.passButton);

        smashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Generar un nuevo índice aleatorio
                int randomIndex = new Random().nextInt(imageResources.length);
                Toast.makeText(BoyTinder.this, "Smash!", Toast.LENGTH_SHORT).show();

                Glide.with(BoyTinder.this)
                        .load(imageResources[randomIndex])
                        .into(personasImageView);
                name.setText(names[randomIndex]);
                desc.setText(bios[randomIndex]);
            }
        });

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Generar un nuevo índice aleatorio
                int randomIndex = new Random().nextInt(imageResources.length);
                Toast.makeText(BoyTinder.this, "Pass!", Toast.LENGTH_SHORT).show();

                Glide.with(BoyTinder.this)
                        .load(imageResources[randomIndex])
                        .into(personasImageView);
                name.setText(names[randomIndex]);
                desc.setText(bios[randomIndex]);
            }
        });
    }
}
