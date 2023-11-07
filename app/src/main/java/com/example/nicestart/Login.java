package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
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