package mx.edu.utng.recyclerviewgds0242;
//Alumno Brayan Mares Bueno
//Grupo: GDS0242

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Relacionando con la vista
        FloatingActionButton fbaUno = findViewById(R.id.fabUno);
        FloatingActionButton act = findViewById(R.id.actActua);

        //Manejo el evento onClick
        fbaUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Conectar ambas actividades
                Intent intentNuevo = new Intent(MainActivity.this, NuevoActivity.class);
                startActivity(intentNuevo); //Iniciar actividad Nueva
                //finish(); //Cerrar actividad principal
            }
        });

        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNuevo = new Intent(MainActivity.this, MainActivityAct.class);
                startActivity(intentNuevo); //Iniciar actividad Nueva
            }
        });


    }


}