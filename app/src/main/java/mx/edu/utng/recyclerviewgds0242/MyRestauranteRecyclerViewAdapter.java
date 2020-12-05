package mx.edu.utng.recyclerviewgds0242;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

//import mx.edu.utng.recyclerviewgds0242.dummy.DummyContent.DummyItem;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Restaurante}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private Context contexto;
    MyOpenHelper databaseHelper;
    Button btnEditar;


    public MyRestauranteRecyclerViewAdapter(Context ctx, List<Restaurante> items) {
        contexto = ctx;
        mValues = items;
        databaseHelper = new MyOpenHelper(ctx);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Restaurante restaurante = mValues.get(position);


        //holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        //holder.mContentView.setText(mValues.get(position).content)
        holder.mItem = mValues.get(position);
        //holder.tvId.setText(Integer.toString(holder.mItem.getId()));
        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvDireccion.setText(holder.mItem.getDireccion());
        holder.rbRestaurante.setRating(holder.mItem.getValoracion());

        //Actualizar
        //holder.actNom.setText(holder.mItem.getNombre());


        //Importar libreria para imagenes
        Glide.with(contexto)
                .load(holder.mItem.getUtlPhoto())
                .centerCrop()
                .placeholder(R.drawable.restaurante)
                .error(R.drawable.restaurante)
                .into(holder.ivPhoto);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        //public final TextView tvId;
        public final TextView tvNombre;
        public final TextView tvDireccion;
        public final ImageView ivPhoto;
        public final RatingBar rbRestaurante;
        public Restaurante mItem;


        public ViewHolder(View view) {
            super(view);
           // tvId = (TextView) view.findViewById(R.id.tvId);
            tvNombre = (TextView) view.findViewById(R.id.tvNombre);
            tvDireccion = (TextView) view.findViewById(R.id.tvDireccion);
            ivPhoto = (ImageView) view.findViewById(R.id.ivPhoto);
            rbRestaurante = (RatingBar) view.findViewById(R.id.rbValoracion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvNombre.getText() + "'";
        }
    }
}