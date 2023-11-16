package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
// METODOS ESTATICOS PARA CARGAR Y CREAR ANIMACIONES A PARTIR DE XML.
import android.view.animation.AnimationUtils;
// REALIZA ANIMACION DE ROTACION EN UNA VISTA. SE ESPECIFICA PUNTO CENTRAL, ANGULO INICIAL Y FINAL.
import android.view.animation.RotateAnimation;
// REALIZA ANIMACION DE ESCALA EN UNA VISTA. SE ESPECIFICA PUNTO CENTRAL, ANCHURA Y ALTURA.
import android.view.animation.ScaleAnimation;
// REALIZA ANIMACION DE TRANSLACION EN UNA VISTA. SE ESPECIFICA DISTANCIA A LARGO DEL EJE X Y EL EJE Y.
import android.view.animation.TranslateAnimation;

public class Splash extends AppCompatActivity {
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp(); //ABRIR LA APLICACION

        logo = findViewById(R.id.logo);
        Glide
                .with(this)
                .load(R.mipmap.beso)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .into(logo);

        // SE CREA UN OBJETO PARA LA ANIMACION
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale_animation1);

        // ANIMACION AL WIDGET DE LA INTERFAZ
        logo.startAnimation(scale);
    }

    private void openApp() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 2000);
    }
}