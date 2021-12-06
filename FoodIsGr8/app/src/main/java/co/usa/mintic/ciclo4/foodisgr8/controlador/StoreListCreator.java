package co.usa.mintic.ciclo4.foodisgr8.controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.controlador.objetos.StoreItem;

public class StoreListCreator extends BaseAdapter {

    private ArrayList<StoreItem> listItems;
    private Context context;

    public StoreListCreator(ArrayList<StoreItem> listItems, Context context) {
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
        StoreItem item = (StoreItem) getItem(position);
        view = LayoutInflater.from(context).inflate(R.layout.component_store_item, null);
        ImageView ImgImage = (ImageView) view.findViewById(R.id.imgStoreImage);
        ImgImage.setImageDrawable(view.getResources().getDrawable(R.drawable.stores));
        TextView txtName = (TextView) view.findViewById(R.id.txtStoreName);
        txtName.setText(item.getNombre());
        TextView txtDescription = (TextView) view.findViewById(R.id.txtStoreDesc);
        txtDescription.setText(item.getDireccion());
        return view;
    }
}
