package co.usa.mintic.ciclo4.foodisgr8.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.StoreItem;

public class StoreListCreator extends BaseAdapter {

    private ArrayList<StoreItem> listItems;
    private Context context;
    private View mainView;

    public StoreListCreator(ArrayList<StoreItem> listItems, Context context, View mainView) {
        this.listItems = listItems;
        this.context = context;
        this.mainView = mainView;
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
        Button btnMap = (Button) view.findViewById(R.id.btnViewMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapView mapView = (MapView) mainView.findViewById(R.id.mapStores);
                GeoPoint startPoint = new GeoPoint(item.getLatitud(), item.getLongitud());
                Marker startMarker = new Marker(mapView);
                startMarker.setTitle(item.getNombre());
                startMarker.setSubDescription(item.getDireccion());
                startMarker.setPosition(startPoint);
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                mapView.getOverlays().add(startMarker);
                MapController mapController = (MapController) mapView.getController();
                mapController.setCenter(startPoint);
            }
        });
        return view;
    }
}
