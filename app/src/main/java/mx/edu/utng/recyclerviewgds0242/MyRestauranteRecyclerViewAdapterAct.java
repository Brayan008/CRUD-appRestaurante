package mx.edu.utng.recyclerviewgds0242;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

//import mx.edu.utng.recyclerviewgds0242.dummy.DummyContent.DummyItem;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Restaurante}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapterAct extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapterAct.ViewHolder> {

    private final List<Restaurante> mValues;
    private Context contexto;
    MyOpenHelper databaseHelper;


    public MyRestauranteRecyclerViewAdapterAct(Context ctx, List<Restaurante> items) {
        contexto = ctx;
        mValues = items;
        databaseHelper = new MyOpenHelper(ctx);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restauranteact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Restaurante restaurante = mValues.get(position);

        //holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        //holder.mContentView.setText(mValues.get(position).content)
        holder.mItem = mValues.get(position);
        //holder.tvId.setText(Integer.toString(holder.mItem.getId()));
        //holder.tvNombre.setText(holder.mItem.getNombre());
        //holder.tvDireccion.setText(holder.mItem.getDireccion());
        //holder.rbRestaurante.setRating(holder.mItem.getValoracion());

        holder.etNombre.setText(holder.mItem.getNombre());
        holder.etDireccion.setText(holder.mItem.getDireccion());
        holder.etPhoto.setText(holder.mItem.getUtlPhoto());
        holder.rtValoracion.setRating(holder.mItem.getValoracion());


        holder.btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringNombre = holder.etNombre.getText().toString();
                String stringDireccion = holder.etDireccion.getText().toString();
                String stringPhoto = holder.etPhoto.getText().toString();
                float rtValo = holder.rtValoracion.getRating();

                databaseHelper.updateEmployee(new Restaurante(restaurante.getId(), stringNombre, stringPhoto, rtValo, stringDireccion));
                notifyDataSetChanged();
                ((Activity) contexto).finish();
                contexto.startActivity(((Activity) contexto).getIntent());
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteEmployee(restaurante.getId());
                mValues.remove(position);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        //public final TextView tvId;
        public final EditText etNombre;
        public final EditText etDireccion;
        public final EditText etPhoto;
        public final RatingBar rtValoracion;
        public final Button btnAct;
        public final Button btnDelete;

        //public final Button btnEditar;
        public Restaurante mItem;


        public ViewHolder(View view) {
            super(view);
           // tvId = (TextView) view.findViewById(R.id.tvId);
            etNombre = (EditText) view.findViewById(R.id.etNombre);
            etDireccion = (EditText) view.findViewById(R.id.etDireccion);
            etPhoto = (EditText) view.findViewById(R.id.etPhoto);
            rtValoracion = (RatingBar) view.findViewById(R.id.ratingBar);
            btnAct = (Button) view.findViewById(R.id.btnAct);
            btnDelete = (Button) view.findViewById(R.id.btnEliminar);


            //btnEditar = (Button) view.findViewById(R.id.btnEditar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }
}