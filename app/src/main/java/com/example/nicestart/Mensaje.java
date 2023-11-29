package com.example.nicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Random;

public class Mensaje extends AppCompatActivity {
    private ImageView personasImageView;
    private LinearLayout linear;
    private TextView nombre, text;
    private EditText mensaje;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        // OBTENER NOMBRE E IMAGEN
        Intent intent = getIntent();
        String nombreObtenido = intent.getStringExtra("NOMBRE");
        int imagenObtenida = intent.getIntExtra("IMAGEN", 0);

        personasImageView = findViewById(R.id.imageView4);
        Glide.with(this)
                .load(imagenObtenida)
                .circleCrop()
                .into(personasImageView);

        nombre = findViewById(R.id.nombre);
        nombre.setText(nombreObtenido);

        text = findViewById(R.id.text);
        // REGISTRA LA VISTA PARA EL MENU CONTEXTUAL
        registerForContextMenu(text);

        linear = findViewById(R.id.linear);
        mensaje = findViewById(R.id.editTextMessage);

        enviar = findViewById(R.id.buttonSend);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarText();
            }
        });
    }

    private void agregarText() {
        // CREAR NUEVO TEXTVIEW
        TextView nuevoTextView = new TextView(this);
        nuevoTextView.setText(mensaje.getText().toString());

        // CONFIGURAR APARIENCIA TEXTVIEW
        nuevoTextView.setTextAppearance(this, R.style.textChat);

        // AGREGAR EL NUECO TEXTVIEW AL LINEAR LAYOUT
        linear.addView(nuevoTextView);
        linear.setBackground(getDrawable(R.drawable.bubble_background));
        mensaje.setText("");
    }

    // MENU CONTEXT
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId() == R.id.borrar) {
            // LIMPIAR LAS VISTAS Y EL BACKGROUD
            linear.removeAllViews();
            linear.setBackground(null); // Clear the background
            Toast.makeText(this, "Has borrado la conversación.", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.bloquear) {
            // METODO PARA MOSTRAR EL DIALOGO DE BLOQUEAR
            showBlockUserDialog();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    private void showBlockUserDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bloquear Usuario");
        builder.setMessage("¿Estás seguro de que quieres bloquear a este usuario?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Mensaje.this, "Has bloqueado a este usuario.", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // CERRAR DIALOG
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

}