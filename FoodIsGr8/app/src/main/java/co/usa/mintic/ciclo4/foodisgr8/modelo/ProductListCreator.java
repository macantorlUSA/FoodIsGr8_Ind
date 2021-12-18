package co.usa.mintic.ciclo4.foodisgr8.modelo;

import android.content.Context;
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
import co.usa.mintic.ciclo4.foodisgr8.controlador.activities.MainActivity;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;

public class ProductListCreator extends BaseAdapter {

    private List<ProductItem> listItems;
    private Context context;
    MainActivity mainView;

    public ProductListCreator(List<ProductItem> listItems, Context context, MainActivity view) {
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
        ProductItem item = (ProductItem) getItem(position);
        view = LayoutInflater.from(context).inflate(R.layout.component_product_item, null);
        ImageView imgPhoto = (ImageView) view.findViewById(R.id.imgProductImage);
        Bitmap bm = BitmapFactory.decodeByteArray(item.getImage(), 0, item.getImage().length);
        imgPhoto.setImageBitmap(bm);
        TextView txtName = (TextView) view.findViewById(R.id.txtProductName);
        txtName.setText(item.getTitulo());
        TextView txtDescription = (TextView) view.findViewById(R.id.txtProductDescription);
        txtDescription.setText(item.getContenido());
        Button btnAddFavorite = (Button) view.findViewById(R.id.btnAddToFavorites);
        btnAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainView.agregarFavoritos(item);
                Toast.makeText(v.getContext(), "Producto Agregado!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
