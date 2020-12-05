package mx.edu.utng.recyclerviewgds0242;
//Alumno Brayan Mares Bueno
//Grupo: GDS0242
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivityAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        FloatingActionButton fbaUno = findViewById(R.id.verLista);

        //Manejo el evento onClick
        fbaUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Conectar ambas actividades
                Intent intentNuevo = new Intent(MainActivityAct.this, MainActivity.class);
                startActivity(intentNuevo); //Iniciar actividad Nueva
                //finish(); //Cerrar actividad principal
            }
        });


    }
}