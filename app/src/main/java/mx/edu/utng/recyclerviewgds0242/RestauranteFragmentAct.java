package mx.edu.utng.recyclerviewgds0242;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragmentAct extends Fragment {

    //Declaraciones:
    RecyclerView recyclerView;
    List<Restaurante> restauranteList;
    MyRestauranteRecyclerViewAdapterAct adapterRestaurantes;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragmentAct() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragmentAct newInstance(int columnCount) {
        RestauranteFragmentAct fragment = new RestauranteFragmentAct();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restauranteact_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //recyclerView.setAdapter(new MyRestauranteRecyclerViewAdapter(DummyContent.ITEMS));
            //datos
            restauranteList = new ArrayList<>();//Definir como lista
            MyOpenHelper dbHelper = new MyOpenHelper(getContext());
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String consultaSQL = "select * from restaurante";
            try{


                Cursor resultado = db.rawQuery(consultaSQL, null);

                while(resultado.moveToNext()){
                    int id = Integer.parseInt(resultado.getString(0));
                    String nombre = resultado.getString(1);
                    String photo = resultado.getString(2);
                    float valoracion = resultado.getFloat(3);
                    String direccion = resultado.getString(4);
                    Restaurante r = new Restaurante(id, nombre, photo, valoracion, direccion);
                    restauranteList.add(r);
                }

            }catch (Exception ex){
                Toast.makeText(getContext(), "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }finally {
                db.close();
            }

            /*
            restauranteList.add(new Restaurante("Pizzeria Marchelos", "https://cdn.kiwilimon.com/recetaimagen/13003/5707.jpg", 4.0f, "Tlaxcala #49"));
            restauranteList.add(new Restaurante("Pollo Feliz", "https://www.pollofelizpuebla.com/images/logo.png", 3.5f, "José Alfredo #3"));
            restauranteList.add(new Restaurante("Pollo Sabroso", "https://thumbs.dreamstime.com/z/pollo-sabroso-hecho-en-casa-del-rotisserie-la-placa-blanca-vista-lateral-primer-140690225.jpg", 5.0f, "Michoacan #65"));
            */
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapterAct(getActivity(), restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}