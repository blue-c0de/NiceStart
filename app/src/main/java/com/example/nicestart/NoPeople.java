package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class NoPeople extends AppCompatActivity {
    private WebView miVisorWeb;
    private SwipeRefreshLayout miSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_people);

        miVisorWeb = findViewById(R.id.vistaweb);
        miSwipe = findViewById(R.id.swipe);

        // ESTABLECE UN ESCUCHADOR PARA EL GESTO "SWIPE TO REFRESH"
        miSwipe.setOnRefreshListener(mOnRefreshListener);

        // OBTIENE LA CONFIGURACIÓN DE WebView
        WebSettings wS = miVisorWeb.getSettings();
        // CONFIGURA LA CARGA CON VISTA GENERAL
        wS.setLoadWithOverviewMode(true);
        // CONFIGURA EL USO DE UN PUERTO ANCHO
        wS.setUseWideViewPort(true);
        // CARGA LA URL EN WebView
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");
    }

    // METODO LLAMADO AL REALIZAR EL GESTO
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            // MUESTRA UN TOAST CON UN MENSAJE
            Toast toast = Toast.makeText(NoPeople.this, "Hi there! I dont exist :", Toast.LENGTH_LONG);
            toast.show();
            // RECARGA LA PÁGINA EN WebView
            miVisorWeb.reload();
            // DETIENE LA ANIMACIÓN DE "SWIPE TO REFRESH"
            miSwipe.setRefreshing(false);
        }
    };
}