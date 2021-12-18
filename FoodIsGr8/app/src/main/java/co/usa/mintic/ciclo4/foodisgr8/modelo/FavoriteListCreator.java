package co.usa.mintic.ciclo4.foodisgr8.modelo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.controlador.activities.ActivityFavoriteDetail;
import co.usa.mintic.ciclo4.foodisgr8.controlador.activities.MainActivity;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.FavoriteItem;

public class FavoriteListCreator extends BaseAdapter {

    private List<FavoriteItem> listItems;
    private Context context;
    MainActivity mainView;

    public FavoriteListCreator(List<FavoriteItem> listItems, Context context, MainActivity view) {
        this.listItems = listItems;
        this.context = context;
        this.mainView = view;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        FavoriteItem item = (FavoriteItem) getItem(position);
        view = LayoutInflater.from(context).inflate(R.layout.component_favorite_item, null);
        ImageView imgPhoto = (ImageView) view.findViewById(R.id.imgFavoriteImage);
        Bitmap bm = BitmapFactory.decodeByteArray(item.getImage(), 0, item.getImage().length);
        imgPhoto.setImageBitmap(bm);
        TextView txtName = (TextView) view.findViewById(R.id.txtFavoriteName);
        txtName.setText(item.getTitulo());
        TextView txtDescription = (TextView) view.findViewById(R.id.txtFavoriteDescription);
        txtDescription.setText(item.getContenido());
        Button btnDetails = (Button) view.findViewById(R.id.btnFavoriteDetails);
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ActivityFavoriteDetail.class);
                i.putExtra("item", item);
                context.startActivity(i);
            }
        });
        Button btnDelete = (Button) view.findViewById(R.id.btnRemove);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems.remove(item);
                mainView.eliminarFavoritos(item.getId());
                Toast.makeText(v.getContext(), "Favorito Eliminado!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
