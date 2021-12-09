package co.usa.mintic.ciclo4.foodisgr8.modelo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;
import co.usa.mintic.ciclo4.foodisgr8.controlador.activities.ActivityProductDetail;

public class ProductListCreator extends BaseAdapter {

    private ArrayList<ProductItem> listItems;
    private Context context;

    public ProductListCreator(ArrayList<ProductItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
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
        ProductItem item = (ProductItem) getItem(position);
        view = LayoutInflater.from(context).inflate(R.layout.component_product_item, null);
        ImageView imgPhoto = (ImageView) view.findViewById(R.id.imgProductImage);
        imgPhoto.setImageDrawable(view.getResources().getDrawable(item.getImagen()));
        TextView txtName = (TextView) view.findViewById(R.id.txtProductName);
        txtName.setText(item.getTitulo());
        TextView txtDescription = (TextView) view.findViewById(R.id.txtProductDescription);
        txtDescription.setText(item.getContenido());
        Button btnDetails = (Button) view.findViewById(R.id.btnDetails);
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ActivityProductDetail.class);
                i.putExtra("item", item);
                context.startActivity(i);
            }
        });
        Button btnAddFavorite = (Button) view.findViewById(R.id.btnAddToFavorites);
        btnAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Módulo FAVORITOS disponible próximamente", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
