package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText name, mail, first_pass, confirm_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_register_land);
        } else {
            setContentView(R.layout.activity_register);
        }

        name = findViewById(R.id.name);
        mail = findViewById(R.id.email);
        first_pass = findViewById(R.id.password);
        confirm_pass = findViewById(R.id.password2);


    }

    public void openMain(View view){
        // OBTENGO LOS VALORES
        String nameText = name.getText().toString();
        String mailText = mail.getText().toString();
        String firstPassText = first_pass.getText().toString();
        String confirmPassText = confirm_pass.getText().toString();

        // COMPRUEBO SI NO ESTAN VACIOS
        if (!nameText.isEmpty() && !mailText.isEmpty() && !firstPassText.isEmpty() && !confirmPassText.isEmpty()) {
            if(mailText.contains("@") && mailText.endsWith(".com")){
                // COMPRUEBO SI LAS DOS CONTRASEÑAS SON IGUALES
                if (firstPassText.equals(confirmPassText)){
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    showErrorDialog("Las contraseñas no coinciden. Por favor, verifique.");
                    first_pass.setBackground(getResources().getDrawable(R.drawable.red_border));
                    confirm_pass.setBackground(getResources().getDrawable(R.drawable.red_border));
                }
            } else {
                showErrorDialog("Correo electrónico no válido. Por favor, verifique.");
                mail.setBackground(getResources().getDrawable(R.drawable.red_border));
            }
        } else {
            if (nameText.isEmpty()) {
                name.setBackground(getResources().getDrawable(R.drawable.red_border));

                // COMPROBAMOS QUE SI AGREGA TEXTO LUEGO, VOLVEMOS A PONER EL BORDE EN PREDETERMINADO
                name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus){
                            name.setBackground(getResources().getDrawable(R.drawable.default_border));
                        }
                    }
                });
            }

            if (mailText.isEmpty()) {
                mail.setBackground(getResources().getDrawable(R.drawable.red_border));
                mail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus){
                            mail.setBackground(getResources().getDrawable(R.drawable.default_border));
                        }
                    }
                });
            }

            if (firstPassText.isEmpty()) {
                first_pass.setBackground(getResources().getDrawable(R.drawable.red_border));
                first_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus){
                            first_pass.setBackground(getResources().getDrawable(R.drawable.default_border));
                        }
                    }
                });
            }

            if (confirmPassText.isEmpty()) {
                confirm_pass.setBackground(getResources().getDrawable(R.drawable.red_border));
                confirm_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus){
                            confirm_pass.setBackground(getResources().getDrawable(R.drawable.default_border));
                        }
                    }
                });
            }
        }
    }

    // DIALOGO DE ERROR
    private void showErrorDialog(String message) {
        // LLAMAMOS AL BUILER DE ALERT DIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // ESTABLECEMOS QUE NUESTRO BUILDER ES DE ERROR, IMPRIMIRA EL MENSAJE DE ERROR, Y HAY QUE DARLE AL OK
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null);

        // CREAMOS EL DIALOGO
        AlertDialog dialog = builder.create();

        // MOSTRAMOS EL DIALOGO
        dialog.show();
    }
}