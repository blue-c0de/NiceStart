package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.nicestart.R;

import java.util.ArrayList;
import java.util.Random;

public class NoPeople extends AppCompatActivity {
    private int currentIndex = 0;
    private SwipeRefreshLayout miSwipe;
    private ListView list;
    static String NOMBRE ="";
    static int IMAGEN;
    private int[] imageResources = {R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.boy1, R.drawable.boy2, R.drawable.boy3, R.drawable.boy4, R.drawable.boy5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_people);

        miSwipe = findViewById(R.id.swipe);
        list = findViewById(R.id.listView);

        String[] namesArray = getResources().getStringArray(R.array.names_array);
        ArrayList<String> nombresArray = new ArrayList<>();
        nombresArray.add(namesArray[0]);

        // ADAPTADOR: TOMA DATOS Y LOS ORGANIZA
        final ArrayAdapter<String>[] adapter = new ArrayAdapter[]{new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombresArray)};
        list.setAdapter(adapter[0]);

        // ESTABLECE UN ESCUCHADOR PARA EL GESTO "SWIPE TO REFRESH"
        miSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (currentIndex < namesArray.length - 1) {
                    currentIndex++;
                    nombresArray.add(namesArray[currentIndex]);
                    adapter[0] = new ArrayAdapter<>(NoPeople.this, android.R.layout.simple_list_item_1, nombresArray);
                    list.setAdapter(adapter[0]);
                }

                // Stop the swipe animation
                miSwipe.setRefreshing(false);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NoPeople.this, Mensaje.class);

                // OBTENER EL NOMBRE SELECCIONADO
                NOMBRE = nombresArray.get(position);
                IMAGEN = imageResources[position];

                intent.putExtra("NOMBRE", NOMBRE);
                intent.putExtra("IMAGEN", IMAGEN);
                startActivity(intent);
            }
        });
    }
}
