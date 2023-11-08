package com.example.nicestart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class BothTinder extends AppCompatActivity {

    private ImageView personasImageView;
    private TextView name, desc;
    private Button smashButton, passButton;

    private int[] imageResources = {R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.boy1, R.drawable.boy2, R.drawable.boy3, R.drawable.boy4, R.drawable.boy5};
    private int[] names = {R.string.girl1, R.string.girl2, R.string.girl3, R.string.girl4, R.string.girl5, R.string.boy1, R.string.boy2, R.string.boy3, R.string.boy4, R.string.boy5};
    private int[] bios = {R.string.desc_girl1, R.string.desc_girl2, R.string.desc_girl3, R.string.desc_girl4, R.string.desc_girl5, R.string.desc_boy1, R.string.desc_boy2, R.string.desc_boy3, R.string.desc_boy4, R.string.desc_boy5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girltinder);

        personasImageView = findViewById(R.id.profileImage);
        name = findViewById(R.id.nameTextView);
        desc = findViewById(R.id.bioTextView);
        smashButton = findViewById(R.id.smashButton);
        passButton = findViewById(R.id.passButton);

        smashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Generar un nuevo índice aleatorio
                int randomIndex = new Random().nextInt(imageResources.length);
                Toast.makeText(BothTinder.this, "Smash!", Toast.LENGTH_SHORT).show();
                personasImageView.setImageResource(imageResources[randomIndex]);
                name.setText(names[randomIndex]);
                desc.setText(bios[randomIndex]);
            }
        });

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Generar un nuevo índice aleatorio
                int randomIndex = new Random().nextInt(imageResources.length);
                Toast.makeText(BothTinder.this, "Pass!", Toast.LENGTH_SHORT).show();
                personasImageView.setImageResource(imageResources[randomIndex]);
                name.setText(names[randomIndex]);
                desc.setText(bios[randomIndex]);
            }
        });
    }
}
