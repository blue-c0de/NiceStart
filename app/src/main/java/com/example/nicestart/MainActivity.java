package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView chica, chico, ambos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chico = findViewById(R.id.imageView);
        chica = findViewById(R.id.imageView2);
        ambos = findViewById(R.id.imageView3);

        Glide.with(this)
                .load(R.drawable.man)
                .into(chico);
        Glide.with(this)
                .load(R.drawable.woman)
                .into(chica);
        Glide.with(this)
                .load(R.drawable.dog)
                .into(ambos);
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

    // APP BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // INFLA EL MENÚ; AGREGA ELEMENTOS A LA BARRA DE ACCIONES SI ESTÁ PRESENTE
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // SE COMPRUEBA SI EL ELEMENTO CLICKEADO ES EL DE MENSAJE.
        if (id == R.id.mensaje) {
            Intent intent = new Intent(this, NoPeople.class);
            startActivity(intent);
            return true;
        }

        // LLAMA AL MÉTODO EN LA CLASE BASE PARA MANEJAR OTRAS OPCIONES DEL MENÚ.
        return super.onOptionsItemSelected(item);
    }
}