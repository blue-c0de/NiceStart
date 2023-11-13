package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Login extends AppCompatActivity {
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_login_land);
        } else {
            setContentView(R.layout.activity_login);
        }

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        // GLIDE PARA FOTOS
        ImageView mGirl = findViewById(R.id.chica);
        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(2000)) //PARA QUE DURE 2 SEGUNDOS
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200))) // MIENTRAS SE CARGA LA IMAGEN, ME PONE UN FONDO DEL COLOR ESCOGIDO
                .into(mGirl);
    }

    // METODO PARA EL BOTON LOGIN, ABRE EL REGISTER
    public void openRegister(View view){
        // SINTAXIS: INTENT(UBICACION ACTUAL, QUE QUIERO LANZAR)
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    public void openMain(View view){
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();

        if (!usernameText.isEmpty() && !passwordText.isEmpty()) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        } else{
            if (usernameText.isEmpty()) {
                username.setBackground(getResources().getDrawable(R.drawable.red_border));
                username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus){
                            username.setBackground(getResources().getDrawable(R.drawable.default_border));
                        }
                    }
                });
            }

            if (passwordText.isEmpty()) {
                password.setBackground(getResources().getDrawable(R.drawable.red_border));
                password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus){
                            password.setBackground(getResources().getDrawable(R.drawable.default_border));
                        }
                    }
                });
            }
        }
    }
}