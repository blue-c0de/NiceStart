package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
// PERMITE CARGAR Y REPRODUCIR ANIMACIONES LOTTIE
import com.airbnb.lottie.LottieAnimationView;
// PERMITE CONTROLAR LA REPRODUCION, PAUSA, REANUDACION DE LA ANIMACION
import com.airbnb.lottie.LottieDrawable;
// PROPORCIONA METODOS PARA CREAR COMPOSICIONES DE UN ARCHIVO LOTTIE
import com.airbnb.lottie.LottieCompositionFactory;



public class Splash extends AppCompatActivity {
    private LottieAnimationView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp(); //ABRIR LA APLICACION

        logo = findViewById(R.id.animation_view);
        logo.setAnimation(R.raw.love);
        logo.playAnimation();
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