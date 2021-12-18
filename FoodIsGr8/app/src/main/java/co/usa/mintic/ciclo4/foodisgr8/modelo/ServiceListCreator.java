package co.usa.mintic.ciclo4.foodisgr8.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ServiceItem;

public class ServiceListCreator extends BaseAdapter {

    private List<ServiceItem> listItems;
    private Context context;

    public ServiceListCreator(List<ServiceItem> listItems, Context context) {
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
        ServiceItem item = (ServiceItem) getItem(position);
        view = LayoutInflater.from(context).inflate(R.layout.component_service_item, null);
        ImageView ImgImage = (ImageView) view.findViewById(R.id.imgServiceImage);
        ImgImage.setImageDrawable(view.getResources().getDrawable(R.drawable.services));
        TextView txtName = (TextView) view.findViewById(R.id.txtServiceName);
        txtName.setText(item.getNombre());
        TextView txtDescription = (TextView) view.findViewById(R.id.txtServiceDesc);
        txtDescription.setText(item.getDescripcion());
        return view;
    }
}
