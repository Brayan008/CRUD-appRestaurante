package mx.edu.utng.recyclerviewgds0242;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper  extends SQLiteOpenHelper {
    public static final String ID = "id";
    public static final String nombre = "nombre";
    public static final String photo = "photo";
    public static final String valor = "valoracion";
    public static final String dire = "direccion";
    private SQLiteDatabase sqLiteDatabase;

    private static final String REST_TABLE_CREATE = "CREATE TABLE restaurante(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, photo TEXT, valoracion REAL, direccion TEXT)";
    private static final String DB_NAME = "restaurantedb.sqlite";
    private static final int DB_VERSION = 1;

    public MyOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION); //Crear la base de datos
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(REST_TABLE_CREATE); //Crear la tabla de la base de datos
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void updateEmployee(Restaurante restaurante){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyOpenHelper.ID,restaurante.getId());
        contentValues.put(MyOpenHelper.nombre,restaurante.getNombre());
        contentValues.put(MyOpenHelper.photo,restaurante.getUtlPhoto());
        contentValues.put(MyOpenHelper.valor,restaurante.getValoracion());
        contentValues.put(MyOpenHelper.dire,restaurante.getDireccion());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update("restaurante", contentValues, "id "+" = ?" , new String[]
                {String.valueOf(restaurante.getId())});
    }



    public void deleteEmployee(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("restaurante", "id" + " = ? ", new String[]
                {String.valueOf(id)});
    }



}
