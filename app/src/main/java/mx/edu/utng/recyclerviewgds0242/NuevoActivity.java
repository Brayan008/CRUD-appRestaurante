package mx.edu.utng.recyclerviewgds0242;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class NuevoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        //Loscomponentes visuales
        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etPhoto = findViewById(R.id.etPhoto);
        final RatingBar rbVal = findViewById(R.id.ratingBar);
        final EditText etDir = findViewById(R.id.etDireccion);
        Button btnAgregar = findViewById(R.id.btnAgregar);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Manejo del evento, conectar a la base de datos
                MyOpenHelper dbHelper = new MyOpenHelper(NuevoActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    //Hacer las operaciones sobre la base de datos
                    ContentValues cv = new ContentValues(); //Objeto para datos
                    cv.put("nombre", etNombre.getText().toString()); //Clave y valor
                    cv.put("photo", etPhoto.getText().toString());
                    cv.put("valoracion", rbVal.getRating());
                    cv.put("direccion", etDir.getText().toString());
                    try {
                        db.insert("restaurante", null, cv);
                        etNombre.setText("");
                        etPhoto.setText("");
                        rbVal.setRating(0.0f);
                        etDir.setText("");
                        Toast.makeText(NuevoActivity.this, "Se insertó un Restarante", Toast.LENGTH_LONG).show();

                    }catch(Exception ex){
                        Toast.makeText(NuevoActivity.this, "Error:" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    }finally {
                        db.close();
                    }
                }

            }
        }); //Fin del manejo de OnClick de btnAgregar


        //Onlick del btnRegresar
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Invocar nuevamente a la actividad principal.
                Intent intentMain = new Intent(NuevoActivity.this, MainActivity.class);
                startActivity(intentMain);
                finish(); //Termina NuevoActivity
            }
        });
    }
}